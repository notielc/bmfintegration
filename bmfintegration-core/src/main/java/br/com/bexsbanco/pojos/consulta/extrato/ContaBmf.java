package br.com.bexsbanco.pojos.consulta.extrato;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("contabmf")
public class ContaBmf {

	@XStreamAlias("banco")
	@XStreamAsAttribute
	private String banco;
	@XStreamAlias("agencia")
	@XStreamAsAttribute
	private String agencia;
	@XStreamAlias("conta")
	@XStreamAsAttribute
	private String conta;
	@XStreamAlias("dtSaldoAnt")
	@XStreamAsAttribute
	private String dtSaldoAnt;
	@XStreamAlias("dtSaldoAtual")
	@XStreamAsAttribute
	private String dtSaldoAtual;
	@XStreamAlias("vlrSaldo")
	@XStreamAsAttribute
	private String vlrSaldo;

	@XStreamAlias("Movto")
	private Movimento movimento;

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

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

	public String getDtSaldoAnt() {
		return dtSaldoAnt;
	}

	public void setDtSaldoAnt(String dtSaldoAnt) {
		this.dtSaldoAnt = dtSaldoAnt;
	}

	public String getDtSaldoAtual() {
		return dtSaldoAtual;
	}

	public void setDtSaldoAtual(String dtSaldoAtual) {
		this.dtSaldoAtual = dtSaldoAtual;
	}

	public String getVlrSaldo() {
		return vlrSaldo;
	}

	public void setVlrSaldo(String vlrSaldo) {
		this.vlrSaldo = vlrSaldo;
	}

	public Movimento getMovimento() {
		return movimento;
	}

	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
	}

	@Override
	public String toString() {
		return "ContaBmf [banco=" + banco + ", agencia=" + agencia + ", conta="
				+ conta + ", dtSaldoAnt=" + dtSaldoAnt + ", dtSaldoAtual="
				+ dtSaldoAtual + ", vlrSaldo=" + vlrSaldo + ", movimento="
				+ movimento.toString() + "]";
	}

}
