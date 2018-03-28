package cn.fungo.domain;

public class W2PositionAuth {

	private String id;
	private String positionId;
	private String authId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	@Override
	public String toString() {
		return "W2PositionAuth [id=" + id + ", positionId=" + positionId + ", authId=" + authId + "]";
	}

}
