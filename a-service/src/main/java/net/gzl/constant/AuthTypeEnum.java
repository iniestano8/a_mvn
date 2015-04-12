package net.gzl.constant;

public enum AuthTypeEnum {

	ALL(1,"all"),
	WRITE(2,"write"),
	READ(3,"read");
	
	private int type;
	private String value;
	
	AuthTypeEnum(int type, String value){
		this.type = type;
		this.value = value;
	}
	
	public int getType(){
		return this.type;
	}
	
	public String getValue(){
		return this.value;
	}
	
}
