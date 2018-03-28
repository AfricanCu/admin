package cn.fungo.domain;

public class W3MerchPosition {
	String id;
	String tradeModeId;
	String positionCode;
	String positionName;
	String remark;
	String positionType;
	public String getPositionType() {
		return positionType;
	}
	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTradeModeId() {
		return tradeModeId;
	}
	public void setTradeModeId(String tradeModeId) {
		this.tradeModeId = tradeModeId;
	}
	public String getPositionCode() {
		return positionCode;
	}
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
