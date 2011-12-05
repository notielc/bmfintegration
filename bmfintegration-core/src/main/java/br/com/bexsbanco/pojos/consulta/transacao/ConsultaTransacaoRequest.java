package br.com.bexsbanco.pojos.consulta.transacao;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("BBMFReqTransacaoSit")
public class ConsultaTransacaoRequest {

	@XStreamAlias("BBMFSecurity")
	private String security;
	@XStreamAlias("id")
	@XStreamAsAttribute
	private String id;
	@XStreamAlias("BBMFTransacao")
	private Transacao transacao;

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}

	@Override
	public String toString() {
		return "ConsultaTransacaoRequest [security=" + security + ", id=" + id
				+ ", transacao=" + transacao.toString() + "]";
	}

}
