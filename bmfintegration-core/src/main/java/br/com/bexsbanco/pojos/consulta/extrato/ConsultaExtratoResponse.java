package br.com.bexsbanco.pojos.consulta.extrato;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("BBMResConsMovtoConta")
public class ConsultaExtratoResponse {

	@XStreamAlias("BBMFSecurity")
	private String security;
	@XStreamAlias("contabmf")
	private ContaBmf contabmf;
	@XStreamImplicit
	private List<Movimento> movimento;

	public List<Movimento> getMovimento() {
		return movimento;
	}

	public void setMovimento(List<Movimento> movimento) {
		this.movimento = movimento;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public ContaBmf getContabmf() {
		return contabmf;
	}

	public void setContabmf(ContaBmf contabmf) {
		this.contabmf = contabmf;
	}

	@Override
	public String toString() {
		return "ConsultaExtratoResponse [security=" + security + ", contabmf="
				+ contabmf.toString() + "]";
	}

}
