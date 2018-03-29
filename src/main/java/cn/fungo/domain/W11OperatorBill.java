package cn.fungo.domain;

public class W11OperatorBill {
    private int id;
    private String operatorCode;
    private String operatorName;
    private String operatorPhone;
    private String operatorPwd;
    private String oinyinCode;
    private String idCard;
    private String portrait;
    private int loginNum;
    private String userStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorPhone() {
        return operatorPhone;
    }

    public void setOperatorPhone(String operatorPhone) {
        this.operatorPhone = operatorPhone;
    }

    public String getOperatorPwd() {
        return operatorPwd;
    }

    public void setOperatorPwd(String operatorPwd) {
        this.operatorPwd = operatorPwd;
    }

    public String getOinyinCode() {
        return oinyinCode;
    }

    public void setOinyinCode(String oinyinCode) {
        this.oinyinCode = oinyinCode;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public int getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(int loginNum) {
        this.loginNum = loginNum;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "W11OperatorBill{" +
                "id=" + id +
                ", operatorCode='" + operatorCode + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", operatorPhone='" + operatorPhone + '\'' +
                ", operatorPwd='" + operatorPwd + '\'' +
                ", oinyinCode='" + oinyinCode + '\'' +
                ", idCard='" + idCard + '\'' +
                ", portrait='" + portrait + '\'' +
                ", loginNum=" + loginNum +
                ", userStatus='" + userStatus + '\'' +
                '}';
    }
}
