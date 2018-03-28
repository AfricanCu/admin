package cn.fungo.vo;

public class PositionVO {

	private String type;
	private String id;
	private String positionName;
	private String positionCode;
	private String positionType;

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionType() {
		return positionType;
	}

	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	@Override
	public String toString() {
		return "PositionVO [type=" + type + ", id=" + id + ", positionName=" + positionName + ", positionCode="
				+ positionCode + ", positionType=" + positionType + "]";
	}

}
