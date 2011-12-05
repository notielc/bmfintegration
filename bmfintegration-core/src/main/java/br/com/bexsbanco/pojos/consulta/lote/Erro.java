package br.com.bexsbanco.pojos.consulta.lote;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Erro")
public class Erro {

	@XStreamAlias("CodErro")
	private String codErro;

	public String getCodErro() {
		return codErro;
	}

	public void setCodErro(String codErro) {
		this.codErro = codErro;
	}

	@Override
	public String toString() {
		return "Erro [codErro=" + codErro + "]";
	}
	
	
}
