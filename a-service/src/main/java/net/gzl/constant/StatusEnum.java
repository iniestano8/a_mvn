package net.gzl.constant;

public enum StatusEnum {

	STATUS_DEFAULT(0, "default", ""),
	STATUS_NORMAL(1, "normal", ""),
	STATUS_FORBID(2, "forbid", ""),
	STATUS_DELETE(3, "delete", ""),
	
	STATUS_200(200, "OK", ""),
	STATUS_201(201, "Created", ""),
	STATUS_202(202, "Accepted", ""),
	STATUS_400(400, "Bad Request", ""),
	STATUS_403(403, "Forbidden", ""),
	STATUS_404(404, "Not Found", ""),
	STATUS_500(500, "Internal Server Error", ""),
	STATUS_501(501, "Not Implemented", ""),
	STATUS_502(502, "Bad Gateway", ""),
	STATUS_503(503, "Service Unavailable", ""),
	STATUS_504(504, "Gateway Timeout", ""),
	STATUS_505(505, "HTTP Version Not Supported", "");
	
	private int value;
	private String name;
	private String description;
	
	private StatusEnum (int value, String name, String description){
		this.value = value;
		this.name = name;
		this.description = description;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
