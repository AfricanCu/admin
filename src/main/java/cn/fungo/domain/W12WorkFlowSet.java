package cn.fungo.domain;

public class W12WorkFlowSet {
	private String id;
	private String workFlowName;
	private String systemType;
	private String workFlowLevel;
	private String sorted;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getWorkFlowName() {
		return workFlowName;
	}

	public void setWorkFlowName(String workFlowName) {
		this.workFlowName = workFlowName;
	}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	public String getWorkFlowLevel() {
		return workFlowLevel;
	}

	public void setWorkFlowLevel(String workFlowLevel) {
		this.workFlowLevel = workFlowLevel;
	}

	public String getSorted() {
		return sorted;
	}

	public void setSorted(String sorted) {
		this.sorted = sorted;
	}

	@Override
	public String toString() {
		return "W12WorkFlowSet [id=" + id + ", workFlowName=" + workFlowName + ", systemType=" + systemType
				+ ", workFlowLevel=" + workFlowLevel + ", sorted=" + sorted + "]";
	}

	

}
