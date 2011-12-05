package br.com.bexsbanco.pojos.consulta.transacao;

import java.util.List;

import br.com.bexsbanco.pojos.consulta.lote.CodIdent;
import br.com.bexsbanco.pojos.consulta.lote.Erro;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("BBMFTransacao")
public class Transacao {

	@XStreamAlias("AgDebtd")
	private String agencia;
	@XStreamAlias("CtDebtd")
	private String conta;
	@XStreamAlias("TpCtDebtd")
	private String tipo;
	@XStreamAlias("CodIdent")
	private CodIdent codIdent;
	@XStreamAlias("DtMovto")
	private String movimento;
	@XStreamImplicit
	private List<Erro> erro;

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMovimento() {
		return movimento;
	}

	public void setMovimento(String movimento) {
		this.movimento = movimento;
	}
	
	public List<Erro> getErro() {
		return erro;
	}

	public void setErro(List<Erro> erro) {
		this.erro = erro;
	}

	@Override
	public String toString() {
		return "Transacao [agencia=" + agencia + ", conta=" + conta + ", tipo="
				+ tipo + ", codIdent=" + codIdent + ", movimento=" + movimento
				+ "]";
	}

	public CodIdent getCodIdent() {
		return codIdent;
	}

	public void setCodIdent(CodIdent codIdent) {
		this.codIdent = codIdent;
	}

	
}
