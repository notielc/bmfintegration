package br.com.bexsbanco.pojos.consulta;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import br.com.bexsbanco.pojos.SisMsgPojo;
import br.com.bexsbanco.pojos.consulta.extrato.ConsultaExtratoRequest;
import br.com.bexsbanco.pojos.consulta.extrato.ConsultaExtratoResponse;
import br.com.bexsbanco.pojos.consulta.lote.ConsultaLoteRequest;
import br.com.bexsbanco.pojos.consulta.transacao.ConsultaTransacaoResponse;
import br.com.bexsbanco.pojos.consulta.transacao.ConsultaTransacaoRequest;

public class ConsultaSisMsg extends SisMsgPojo {

	@XStreamAlias("BBMFReqSitLoteTransacao")
	private ConsultaLoteRequest consultaStatusLoteRequest;

	@XStreamAlias("BBMFResSitTransacao")
	private ConsultaTransacaoResponse consultaLoteReqResponse;
	@XStreamAlias("BBMFReqTransacaoSit")
	private ConsultaTransacaoRequest consultaTransacaoRequest;

	@XStreamAlias("BBMFConsMovtoConta")
	private ConsultaExtratoRequest consultaExtratoRequest;	
	@XStreamAlias("BBMResConsMovtoConta")
	private ConsultaExtratoResponse consultaExtratoResponse;

	@XStreamAlias("ErrorMessage")
	private ErrorMessage consultaLoteReqErrorMessage;

	public ConsultaTransacaoResponse getConsultaLoteReqResponse() {
		return consultaLoteReqResponse;
	}

	public void setConsultaLoteReqResponse(
			ConsultaTransacaoResponse consultaLoteReqResponse) {
		this.consultaLoteReqResponse = consultaLoteReqResponse;
	}

	public ConsultaLoteRequest getConsultaStatusLoteRequest() {
		return consultaStatusLoteRequest;
	}

	public void setConsultaStatusLoteRequest(
			ConsultaLoteRequest consultaStatusLoteRequest) {
		this.consultaStatusLoteRequest = consultaStatusLoteRequest;
	}

	public ErrorMessage getConsultaLoteReqErrorMessage() {
		return consultaLoteReqErrorMessage;
	}

	public void setConsultaLoteReqErrorMessage(
			ErrorMessage consultaLoteReqErrorMessage) {
		this.consultaLoteReqErrorMessage = consultaLoteReqErrorMessage;
	}

	public ConsultaTransacaoRequest getConsultaTransacaoRequest() {
		return consultaTransacaoRequest;
	}

	public void setConsultaTransacaoRequest(
			ConsultaTransacaoRequest consultaTransacaoRequest) {
		this.consultaTransacaoRequest = consultaTransacaoRequest;
	}

	public ConsultaExtratoRequest getConsultaExtratoRequest() {
		return consultaExtratoRequest;
	}

	public void setConsultaExtratoRequest(
			ConsultaExtratoRequest consultaExtratoRequest) {
		this.consultaExtratoRequest = consultaExtratoRequest;
	}

	public ConsultaExtratoResponse getConsultaExtratoResponse() {
		return consultaExtratoResponse;
	}

	public void setConsultaExtratoResponse(
			ConsultaExtratoResponse consultaExtratoResponse) {
		this.consultaExtratoResponse = consultaExtratoResponse;
	}

	@Override
	public String toString() {
		return "ConsultaLoteSisMsg [consultaStatusLoteRequest="
				+ consultaStatusLoteRequest + ", consultaLoteReqErrorMessage="
				+ consultaLoteReqErrorMessage + ", consultaLoteReqResponse="
				+ consultaLoteReqResponse + ", consultaTransacaoRequest="
				+ consultaTransacaoRequest + "]";
	}

}
