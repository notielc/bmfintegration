package br.com.bexsbanco.beans;

import br.com.bexsbanco.util.PropertiesUtil;

@SuppressWarnings("unused")
public class ConfigurationBean {

	private static String schedulerStatus;
	
	private String bmfws;
	private String user;
	private String password;
	private String bexsbancoTimeSchedule;
	
	private String consultaTransacaoAgencia;
	private String consultaTransacaoConta;
	private String consultaTransacaoCodIdent;
	private String consultaTransacaoMovimento;
	private String consultaTransacaoTipo;
		
	private String consultaLoteReqTransacaoTipo;

	private String consultaExtratoAgencia;
	private String consultaExtratoConta;
	private String consultaExtratoDataLancamento;
	private String consultaExtratoMovimento;
	private String consultaExtratoTipo;
	
	private String consultaExtratoDiasAnteriores;
	
	private String databaseUrl;
	private String databaseDriver;
	private String databaseUser;
	private String databasePassword;
	
	private String consultaPeriodoInicio;
	private String consultaPeriodoFim;
	
	private String consultaTransacao;
	private String consultaExtrato;
	
	private String consultaEmailHost;
	private String consultaEmailLogin;
	private String consultaEmailPassword;
	private String consultaEmailRecebimento;
	private String consultaEmailSsl;
	
	public String getConsultaPeriodoInicio() {
		return PropertiesUtil.getValor("bexsbanco_consulta_periodo_inicio");
	}
	
	public String getConsultaPeriodoFim() {
		return PropertiesUtil.getValor("bexsbanco_consulta_periodo_fim");
	}
	
	
	public String getDatabaseUrl() {
		return PropertiesUtil.getValor("bexsbanco_database_url");
	}

	public String getDatabaseDriver() {
		return PropertiesUtil.getValor("bexsbanco_database_driver");
	}

	public String getDatabaseUser() {
		return PropertiesUtil.getValor("bexsbanco_database_user");
	}

	public String getDatabasePassword() {
		return PropertiesUtil.getValor("bexsbanco_database_password");
	}

	public String getBmfws() {
		return PropertiesUtil.getValor("bexsbanco_bmfws");
	}

	public String getUser() {
		return PropertiesUtil.getValor("bexsbanco_user");
	}

	public String getPassword() {
		return PropertiesUtil.getValor("bexsbanco_password");
	}

	public String getBexsbancoTimeSchedule() {
		return PropertiesUtil.getValor("bexsbanco_time_schedule");
	}

	public String getConsultaTransacaoAgencia() {
		return PropertiesUtil.getValor("bexsbanco_consulta_transacao_agencia");
	}

	public String getConsultaTransacaoConta() {
		return PropertiesUtil.getValor("bexsbanco_consulta_transacao_conta");
	}

	public String getConsultaTransacaoCodIdent() {
		return PropertiesUtil.getValor("bexsbanco_consulta_transacao_cod_ident");
	}

	public String getConsultaTransacaoMovimento() {
		return PropertiesUtil.getValor("bexsbanco_consulta_transacao_dt_movimento");
	}

	public String getConsultaTransacaoTipo() {
		return PropertiesUtil.getValor("bexsbanco_consulta_transacao_tipo");
	}

	public String getConsultaLoteReqTransacaoTipo() {
		return PropertiesUtil.getValor("bexsbanco_consulta_lote_req_transacao");
	}
	
	public String getConsultaExtratoAgencia() {
		return PropertiesUtil.getValor("bexsbanco_consulta_extrato_agencia");
	}

	public String getConsultaExtratoConta() {
		return PropertiesUtil.getValor("bexsbanco_consulta_extrato_conta");
	}

	public String getConsultaExtratoDataLancamento() {
		return PropertiesUtil.getValor("bexsbanco_consulta_extrato_data_lancamento");
	}

	public String getConsultaExtratoMovimento() {
		return PropertiesUtil.getValor("bexsbanco_consulta_extrato_movimento");
	}

	public String getConsultaExtratoTipo() {
		return PropertiesUtil.getValor("bexsbanco_consulta_extrato_tipo");
	}

	public static String getSchedulerStatus() {
		return schedulerStatus == null ? "Not Running" : schedulerStatus;
	}
	
	public String getDiasAnteriores() {
		return PropertiesUtil.getValor("bexsbanco_consulta_extrato_dias_anteriores");
	}

	public String getConsultaTransacaoSim() {
		return PropertiesUtil.getValor("bexsbanco_consulta_transacao") != null 
				&& !PropertiesUtil.getValor("bexsbanco_consulta_transacao").equalsIgnoreCase("null")
				&& PropertiesUtil.getValor("bexsbanco_consulta_transacao").equalsIgnoreCase("true") ? "checked" : "";
	}
	
	public String getConsultaTransacaoNao() {
		return PropertiesUtil.getValor("bexsbanco_consulta_transacao") != null 
				&& !PropertiesUtil.getValor("bexsbanco_consulta_transacao").equalsIgnoreCase("null")
				&& PropertiesUtil.getValor("bexsbanco_consulta_transacao").equalsIgnoreCase("false") ? "checked" : "";
	}

	public String getConsultaExtratoSim() {
		return PropertiesUtil.getValor("bexsbanco_consulta_extrato") != null 
					&& !PropertiesUtil.getValor("bexsbanco_consulta_extrato").equalsIgnoreCase("null")
					&& PropertiesUtil.getValor("bexsbanco_consulta_extrato").equalsIgnoreCase("true") ? "checked" : "";
	}
	
	public String getConsultaExtratoNao() {
		return PropertiesUtil.getValor("bexsbanco_consulta_extrato") != null 
					&& !PropertiesUtil.getValor("bexsbanco_consulta_extrato").equalsIgnoreCase("null")
					&& PropertiesUtil.getValor("bexsbanco_consulta_extrato").equalsIgnoreCase("false") ? "checked" : "";
	}

	public String getConsultaEmailHost() {
		return PropertiesUtil.getValor("bexsbanco_email_host");
	}

	public String getConsultaEmailLogin() {
		return PropertiesUtil.getValor("bexsbanco_email_login");
	}

	public String getConsultaEmailPassword() {
		return PropertiesUtil.getValor("bexsbanco_email_senha");
	}
	
	public String getConsultaEmailRecebimento() {
		return PropertiesUtil.getValor("bexsbanco_email_recebimento");
	}
	
	public String getConsultaEmailSslSim() {
		return PropertiesUtil.getValor("bexsbanco_email_ssl") != null 
					&& !PropertiesUtil.getValor("bexsbanco_email_ssl").equalsIgnoreCase("null")
					&& PropertiesUtil.getValor("bexsbanco_email_ssl").equalsIgnoreCase("true") ? "checked" : "";
	}
	
	public String getConsultaEmailSslNao() {
		return PropertiesUtil.getValor("bexsbanco_email_ssl") != null 
					&& !PropertiesUtil.getValor("bexsbanco_email_ssl").equalsIgnoreCase("null")
					&& PropertiesUtil.getValor("bexsbanco_email_ssl").equalsIgnoreCase("false") ? "checked" : "";
	}

	public static void setSchedulerStatus(String schedulerStatus) {
		ConfigurationBean.schedulerStatus = schedulerStatus;
	}
	
	

		
	
}
