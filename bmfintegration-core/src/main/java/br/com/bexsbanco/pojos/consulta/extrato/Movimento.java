package br.com.bexsbanco.pojos.consulta.extrato;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Movto")
public class Movimento {

	@XStreamAlias("AgeCtp")
	private String agencia;
	@XStreamAlias("CtaCtp")
	private String conta;
	@XStreamAlias("TipoCtaCtp")
	private String tipo;
	@XStreamAlias("DtLanc")
	private String dtLancamento;
	@XStreamAlias("NumMovto")
	private String numMotivo;

	@XStreamAlias("CodIdent")
	private String codIdent;
	@XStreamAlias("NumDocto")
	private String documento;
	@XStreamAlias("CodHist")
	private String codHistorico;
	@XStreamAlias("DescHist")
	private String descHistorico;
	@XStreamAlias("VlrLanc")
	private String vlrLancamento;
	@XStreamAlias("TpDeb_Cred")
	private String tipoCreditoDebito;
	@XStreamAlias("BcoCtp")
	private String bancoCtp;
	@XStreamAlias("CnpjCpfCtpTitular1")
	private String docTitular1;
	@XStreamAlias("NomeCtpTitular1")
	private String nomeTitular1;
	@XStreamAlias("CnpjCpfCtpTitular2")
	private String docTitular2;
	@XStreamAlias("NomeCtpTitular2")
	private String nomeTitular2;
	@XStreamAlias("TpPessoaCtp")
	private String tipoPessoaCtp;
	@XStreamAlias("CodCli")
	private String codCliente;
	@XStreamAlias("TpPessoaInvest")
	private String tipoPessoaInvest;
	@XStreamAlias("CNPJ_CPFInvest")
	private String documentoInvest;
	@XStreamAlias("Nom_RzSocInvest")
	private String razaoSocialInvest;

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

	public String getDtLancamento() {
		return dtLancamento;
	}

	public void setDtLancamento(String dtLancamento) {
		this.dtLancamento = dtLancamento;
	}

	public String getNumMotivo() {
		return numMotivo;
	}

	public void setNumMotivo(String numMotivo) {
		this.numMotivo = numMotivo;
	}

	public String getCodIdent() {
		return codIdent;
	}

	public void setCodIdent(String codIdent) {
		this.codIdent = codIdent;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getCodHistorico() {
		return codHistorico;
	}

	public void setCodHistorico(String codHistorico) {
		this.codHistorico = codHistorico;
	}

	public String getDescHistorico() {
		return descHistorico;
	}

	public void setDescHistorico(String descHistorico) {
		this.descHistorico = descHistorico;
	}

	public String getVlrLancamento() {
		return vlrLancamento;
	}

	public void setVlrLancamento(String vlrLancamento) {
		this.vlrLancamento = vlrLancamento;
	}

	public String getTipoCreditoDebito() {
		return tipoCreditoDebito;
	}

	public void setTipoCreditoDebito(String tipoCreditoDebito) {
		this.tipoCreditoDebito = tipoCreditoDebito;
	}

	public String getBancoCtp() {
		return bancoCtp;
	}

	public void setBancoCtp(String bancoCtp) {
		this.bancoCtp = bancoCtp;
	}

	public String getDocTitular1() {
		return docTitular1;
	}

	public void setDocTitular1(String docTitular1) {
		this.docTitular1 = docTitular1;
	}

	public String getNomeTitular1() {
		return nomeTitular1;
	}

	public void setNomeTitular1(String nomeTitular1) {
		this.nomeTitular1 = nomeTitular1;
	}

	public String getDocTitular2() {
		return docTitular2;
	}

	public void setDocTitular2(String docTitular2) {
		this.docTitular2 = docTitular2;
	}

	public String getNomeTitular2() {
		return nomeTitular2;
	}

	public void setNomeTitular2(String nomeTitular2) {
		this.nomeTitular2 = nomeTitular2;
	}

	public String getTipoPessoaCtp() {
		return tipoPessoaCtp;
	}

	public void setTipoPessoaCtp(String tipoPessoaCtp) {
		this.tipoPessoaCtp = tipoPessoaCtp;
	}

	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}

	public String getTipoPessoaInvest() {
		return tipoPessoaInvest;
	}

	public void setTipoPessoaInvest(String tipoPessoaInvest) {
		this.tipoPessoaInvest = tipoPessoaInvest;
	}

	public String getDocumentoInvest() {
		return documentoInvest;
	}

	public void setDocumentoInvest(String documentoInvest) {
		this.documentoInvest = documentoInvest;
	}

	public String getRazaoSocialInvest() {
		return razaoSocialInvest;
	}

	public void setRazaoSocialInvest(String razaoSocialInvest) {
		this.razaoSocialInvest = razaoSocialInvest;
	}

	@Override
	public String toString() {
		return "Movimento [agencia=" + agencia + ", conta=" + conta + ", tipo="
				+ tipo + ", dtLancamento=" + dtLancamento + ", numMotivo="
				+ numMotivo + ", codIdent=" + codIdent + ", documento="
				+ documento + ", codHistorico=" + codHistorico
				+ ", descHistorico=" + descHistorico + ", vlrLancamento="
				+ vlrLancamento + ", tipoCreditoDebito=" + tipoCreditoDebito
				+ ", bancoCtp=" + bancoCtp + ", docTitular1=" + docTitular1
				+ ", nomeTitular1=" + nomeTitular1 + ", docTitular2="
				+ docTitular2 + ", nomeTitular2=" + nomeTitular2
				+ ", tipoPessoaCtp=" + tipoPessoaCtp + ", codCliente="
				+ codCliente + ", tipoPessoaInvest=" + tipoPessoaInvest
				+ ", documentoInvest=" + documentoInvest
				+ ", razaoSocialInvest=" + razaoSocialInvest + "]";
	}

}
