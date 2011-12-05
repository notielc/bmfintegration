package br.com.bexsbanco.pojos.consulta.extrato;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BBMFResConsMovtoConta")
public class ConsultaExtratoResponse {

	@XStreamAlias("BBMFSecurity")
	private String security;
	@XStreamAlias("contabmf")
	private ContaBmf contabmf;
	@XStreamAlias("Movto")
	private Movimento movimento;

	public Movimento getMovimento() {
		return movimento;
	}

	public void setMovimento(Movimento movimento) {
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
