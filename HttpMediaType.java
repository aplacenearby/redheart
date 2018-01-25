package cn.woonton.business.enums;

public enum HttpMediaType {
	JSON(1, "application/json;charset=utf‐8");
	private int id = -1;
	private String value = "";

	private HttpMediaType(int id, String value) {
		this.value = value;
		this.id = id;
	}

	public static HttpMediaType valueOf(int value) {
		switch (value) {
		case 1:
			return JSON;
		default:
			return JSON;
		}
	}

	public int id() {
		return this.id;
	}

	public String value() {
		return this.value;
	}
}
