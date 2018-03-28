package cn.fungo.vo;

import java.util.List;

public class WindowVO {
	private String id;
	private String text;

	private List<AuthVO> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<AuthVO> getChildren() {
		return children;
	}

	public void setChildren(List<AuthVO> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "WindowVO [id=" + id + ", text=" + text + ", children=" + children + "]";
	}

}
