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
	@XStreamAlias("Origem")
	private String origem;
	@XStreamAlias("UserID")
	private String userId;
	@XStreamAlias("IdReq")
	private String IdReq;
	@XStreamAlias("ErrorNumber")
	private String errorNumber;
	@XStreamAlias("Description")
	private String description;
		
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getIdReq() {
		return IdReq;
	}
	public void setIdReq(String idReq) {
		IdReq = idReq;
	}
	public String getErrorNumber() {
		return errorNumber;
	}
	public void setErrorNumber(String errorNumber) {
		this.errorNumber = errorNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
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
