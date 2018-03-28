package cn.fungo.domain;

public class W2Position {
    private String id;
    private String positionCode;
    private String positionName;
    private String remark;
    private String positionType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    @Override
    public String toString() {
        return "W2Position [id=" + id + ", positionCode=" + positionCode + ", positionName=" + positionName
                + ", remark=" + remark + ", positionType=" + positionType + "]";
    }
}