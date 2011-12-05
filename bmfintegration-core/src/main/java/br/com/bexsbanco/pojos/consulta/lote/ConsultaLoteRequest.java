package br.com.bexsbanco.pojos.consulta.lote;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("BBMFReqSitLoteTransacao")
public class ConsultaLoteRequest {

	@XStreamAlias("BBMFSecurity")
	private String security;
	@XStreamAlias("IDReqTransacao")
	private String idReqTransacao;
	@XStreamAlias("id")
	@XStreamAsAttribute
	private String id;

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getIdReqTransacao() {
		return idReqTransacao;
	}

	public void setIdReqTransacao(String idReqTransacao) {
		this.idReqTransacao = idReqTransacao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ConsultaLoteRequest [security=" + security
				+ ", idReqTransacao=" + idReqTransacao + ", id=" + id + "]";
	}

	
	
}