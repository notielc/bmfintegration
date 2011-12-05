package br.com.bexsbanco.pojos.consulta.lote;

import java.util.List;

import br.com.bexsbanco.pojos.consulta.transacao.Transacao;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("BBMFResSitTransacao")
public class ConsultaLoteResponse{

	@XStreamAlias("BBMFSecurity")
	private String security;
	@XStreamImplicit
	private List<LoteTransacao> loteTransacao;

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public List<LoteTransacao> getLoteTransacao() {
		return loteTransacao;
	}

	public void setLoteTransacao(List<LoteTransacao> loteTransacao) {
		this.loteTransacao = loteTransacao;
	}

	@Override
	public String toString() {
		return "ConsultaLoteResponse [security=" + security
				+ ", loteTransacao=" + loteTransacao + "]";
	}

	
}
