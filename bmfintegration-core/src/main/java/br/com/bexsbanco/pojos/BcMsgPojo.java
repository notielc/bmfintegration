package br.com.bexsbanco.pojos;

import br.com.bexsbanco.pojos.consulta.ErrorMessage;
import br.com.bexsbanco.pojos.consulta.extrato.ConsultaExtratoResponse;
import br.com.bexsbanco.pojos.consulta.transacao.ConsultaTransacaoResponse;
import br.com.bexsbanco.services.ConsultaTransacaoService;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BMFBCMSG")
public class BcMsgPojo {

	@XStreamAlias("UserInfo")
	private UserInfoPojo userInfo = new UserInfoPojo();
	@XStreamAlias("ErrorMessage")
	private ErrorMessage errorMessage;	
	@XStreamAlias("BBMResConsMovtoConta")
	private ConsultaExtratoResponse consultaExtratoResponse;
	@XStreamAlias("BBMFResSitTransacao")
	private ConsultaTransacaoResponse consultaTransacaoResponse;
	
	public ConsultaTransacaoResponse getConsultaTransacaoResponse() {
		return consultaTransacaoResponse;
	}

	public void setConsultaTransacaoResponse(
			ConsultaTransacaoResponse consultaTransacaoResponse) {
		this.consultaTransacaoResponse = consultaTransacaoResponse;
	}

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
