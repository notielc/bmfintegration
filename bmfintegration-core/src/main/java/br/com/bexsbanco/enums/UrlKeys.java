package br.com.bexsbanco.enums;

public enum UrlKeys {

	XML("XML");
	
	private String desc;
	
	private UrlKeys(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
