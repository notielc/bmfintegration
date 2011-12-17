package br.com.bexsbanco.pojos;

import br.com.bexsbanco.pojos.consulta.ErrorMessage;
import br.com.bexsbanco.pojos.consulta.extrato.ConsultaExtratoResponse;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BMFBCMSG")
public class BcMsgPojo {

	@XStreamAlias("UserInfo")
	private UserInfoPojo userInfo = new UserInfoPojo();
	@XStreamAlias("ErrorMessage")
	private ErrorMessage errorMessage;	
	@XStreamAlias("BBMResConsMovtoConta")
	private ConsultaExtratoResponse consultaExtratoResponse;
	
	public ConsultaExtratoResponse getConsultaExtratoResponse() {
		return consultaExtratoResponse;
	}

	public void setConsultaExtratoResponse(
			ConsultaExtratoResponse consultaExtratoResponse) {
		this.consultaExtratoResponse = consultaExtratoResponse;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	public UserInfoPojo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfoPojo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "BcMsgPojo [userInfo=" + userInfo + "]";
	}
	
	

}
