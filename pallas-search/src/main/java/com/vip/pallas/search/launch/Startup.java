/**
 * Copyright 2019 vip.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.vip.pallas.search.launch;

import java.util.Locale;

import com.vip.pallas.search.rampup.RampupCounter;
import com.vip.pallas.utils.LogUtils;
import com.vip.pallas.search.utils.SearchLogEvent;
import org.elasticsearch.common.Booleans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vip.pallas.search.monitor.UploadInfoService;
import com.vip.pallas.search.netty.http.server.PallasNettyServer;
import com.vip.pallas.search.service.PallasCacheFactory;
import com.vip.pallas.search.timeout.TimeoutRetryController;
import com.vip.pallas.search.trace.TraceAop;
import com.vip.pallas.search.utils.PallasSearchProperties;
import com.vip.pallas.search.utils.StartCheckUtil;

public class Startup {
	private static Logger logger = LoggerFactory.getLogger(Startup.class);

	public static void main(String[] args) {
		try {
			start();
		} catch (Exception e) {
			LogUtils.error(logger, SearchLogEvent.INIT_EVENT, e.getMessage(), e);
			System.exit(1);
		}
	}

	public static void start() throws Exception {
		//TODO 临时设置es netty参数, 后续版本移除
		if(!Booleans.parseBoolean(System.getProperty("es.set.netty.runtime.available.processors"), false)){
			System.setProperty("es.set.netty.runtime.available.processors", "false");
		}

		StartCheckUtil.add2CheckList(StartCheckUtil.StartCheckItem.PORT);
		prepareSysProps();

		LogUtils.info(logger, SearchLogEvent.INIT_EVENT, "Gateway Application Start...");
		LogUtils.info(logger, SearchLogEvent.INIT_EVENT, "init zuul ...");
		BootStrap.initZuul();

		LogUtils.info(logger, SearchLogEvent.INIT_EVENT, "init trace ...");
		TraceAop.instance().start();

		LogUtils.info(logger, SearchLogEvent.INIT_EVENT, "start upload info timmer ...");
		new UploadInfoService().startUploadTimmer();

		LogUtils.info(logger, SearchLogEvent.INIT_EVENT, "start timeout retry checker ...");
		TimeoutRetryController.start();

		LogUtils.info(logger, SearchLogEvent.INIT_EVENT, "init cache service ...");
		try{
			PallasCacheFactory.getCacheService().initCache();
		}catch(Exception ex){
			LogUtils.error(logger, SearchLogEvent.INIT_EVENT, ex.getMessage(), ex);
		}

		LogUtils.info(logger, SearchLogEvent.INIT_EVENT, "start index rampup counter ...");
		RampupCounter.start();

		LogUtils.info(logger, SearchLogEvent.INIT_EVENT, "start netty ...");
		final PallasNettyServer gatewayServer = new PallasNettyServer();
		gatewayServer.startServer(PallasSearchProperties.PALLAS_SEARCH_PORT); // 启动HTTP容器
	}
	
	/**
	 *  System properties default reset
	 */
	private static void prepareSysProps(){
		LogUtils.info(logger, SearchLogEvent.INIT_EVENT, "Set default locale language[en] ...");
		Locale.setDefault(Locale.ENGLISH);
	}

	public static void fail(String message) {
		LogUtils.info(logger, SearchLogEvent.INIT_EVENT, "Error: " + message);
		System.exit(-1);
	}
    
}
