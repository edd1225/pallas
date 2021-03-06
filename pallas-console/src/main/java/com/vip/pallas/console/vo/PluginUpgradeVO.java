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

package com.vip.pallas.console.vo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class PluginUpgradeVO {

    private Long id;

    private String clusterId;

    private String clusterDescription;

    private String pluginName;

    private int pluginType;

    private int state;

    private String note;

    private String applyUser;

    private String approveUser;

    private String packagePath;

    private String pluginVersion;

    private Date updateTime;

    protected List<PluginNodeState> nodeStates = new LinkedList<>();

    private String flowlshNo;

    private int flowlshState = 0;

    private boolean canExecuteFlowlsh = false;

    private String flowlshMessage = null;

    private String greyIps = null;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApproveUser() {
        return approveUser;
    }

    public void setApproveUser(String approveUser) {
        this.approveUser = approveUser;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getPluginVersion() {
        return pluginVersion;
    }

    public void setPluginVersion(String pluginVersion) {
        this.pluginVersion = pluginVersion;
    }

    public int getPluginType() {
        return pluginType;
    }

    public void setPluginType(int pluginType) {
        this.pluginType = pluginType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    public String getClusterDescription() {
        return clusterDescription;
    }

    public void setClusterDescription(String clusterDescription) {
        this.clusterDescription = clusterDescription;
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<PluginNodeState> getNodeStates() {
        return nodeStates;
    }

    public void setNodeStates(List<PluginNodeState> nodeStates) {
        this.nodeStates = nodeStates;
    }

    public String getFlowlshNo() {
        return flowlshNo;
    }

    public void setFlowlshNo(String flowlshNo) {
        this.flowlshNo = flowlshNo;
    }

    public int getFlowlshState() {
        return flowlshState;
    }

    public void setFlowlshState(int flowlshState) {
        this.flowlshState = flowlshState;
    }

    public boolean isCanExecuteFlowlsh() {
        return canExecuteFlowlsh;
    }

    public void setCanExecuteFlowlsh(boolean canExecuteFlowlsh) {
        this.canExecuteFlowlsh = canExecuteFlowlsh;
    }

    public String getFlowlshMessage() {
        return flowlshMessage;
    }

    public void setFlowlshMessage(String flowlshMessage) {
        this.flowlshMessage = flowlshMessage;
    }

	public String getGreyIps() {
		return greyIps;
	}

	public void setGreyIps(String greyIps) {
		this.greyIps = greyIps;
	}

	@Override
	public String toString() {
		return "PluginUpgradeVO{" + "id=" + id + ", clusterId='" + clusterId + '\'' + ", clusterDescription='"
				+ clusterDescription + '\'' + ", pluginName='" + pluginName + '\'' + ", pluginType=" + pluginType
				+ ", state=" + state + ", note='" + note + '\'' + ", applyUser='" + applyUser + '\'' + ", approveUser='"
				+ approveUser + '\'' + ", packagePath='" + packagePath + '\'' + ", pluginVersion='" + pluginVersion
				+ '\'' + ", updateTime=" + updateTime + ", nodeStates=" + nodeStates + ", flowlshNo='" + flowlshNo
				+ '\'' + ", flowlshState=" + flowlshState + ", canExecuteFlowlsh=" + canExecuteFlowlsh
				+ ", flowlshMessage='" + flowlshMessage + '\'' + ", greyIps='" + greyIps + '\'' + '}';
	}
}