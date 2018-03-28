package cn.fungo.domain;

public class W12EventSet {
	String id;
	String eventCode;
	String eventName;
	String workFlowId;
	String positionId;
	String parentEventid;
	String finishPeriod;
	String eventLevel;
	String sorted;
	String remark;
	String workFlowName;
	String positionName;
	public String getWorkFlowName() {
		return workFlowName;
	}
	public void setWorkFlowName(String workFlowName) {
		this.workFlowName = workFlowName;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEventCode() {
		return eventCode;
	}
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getWorkFlowId() {
		return workFlowId;
	}
	public void setWorkFlowId(String workFlowId) {
		this.workFlowId = workFlowId;
	}
	public String getPositionId() {
		return positionId;
	}
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}
	public String getParentEventid() {
		return parentEventid;
	}
	public void setParentEventid(String parentEventid) {
		this.parentEventid = parentEventid;
	}
	public String getFinishPeriod() {
		return finishPeriod;
	}
	public void setFinishPeriod(String finishPeriod) {
		this.finishPeriod = finishPeriod;
	}
	public String getEventLevel() {
		return eventLevel;
	}
	public void setEventLevel(String eventLevel) {
		this.eventLevel = eventLevel;
	}
	public String getSorted() {
		return sorted;
	}
	public void setSorted(String sorted) {
		this.sorted = sorted;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
