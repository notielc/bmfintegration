package br.com.bexsbanco.pojos.consulta;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ErrorMessage")
public class ErrorMessage {

	@XStreamAlias("BBMFSecurity")
	private String security;
	@XStreamAlias("NameReq")
	private String nameReq;
	@XStreamAlias("Date")
	private String date;
	@XStreamAlias("ErrorID")
	private String errorId;
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public String getNameReq() {
		return nameReq;
	}
	public void setNameReq(String nameReq) {
		this.nameReq = nameReq;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getErrorId() {
		return errorId;
	}
	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}
	@Override
	public String toString() {
		return "ErrorMessage [security=" + security + ", nameReq=" + nameReq
				+ ", date=" + date + ", errorId=" + errorId + "]";
	}

	

}
