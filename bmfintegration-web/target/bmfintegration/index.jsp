<jsp:useBean id="configBean"
	class="br.com.bexsbanco.beans.ConfigurationBean" scope="session" />
<html>
<head>
<title>teste</title>
<style type="text/css">
body {
	background: url(images/fundo_body.gif) 0 146px;
}

#body_aux {
	min-width: 998px;
	width: 100%;
	height: 150px;
	background: url(images/fundo_body_aux.png) repeat-x 0 0;
}

#title {
	font: bold 24px/24px Arial, Helvetica, sans-serif;
	color: #fffcc0;
	margin-left: 500px;
	margin-top: 0px;
	width: 400px;
}

#imgLogo {
	margin-left: 30px;
	padding-top: 10px;
	width: 300px;
}
</style>
</head>
<body leftmargin="0" rightmargin="0" topmargin="0">
<div id="body_aux">
<div id="imgLogo"><img src="images/logo.png" /></div>
<div id="title">Configurações Integração BM&F</div>
</div>
<h2>Serviço Scheduler Status : <%=configBean.getSchedulerStatus()%></h2>
<form action="Scheduler" method="post"><input type="submit"
	value="Iniciar Servico" /> <input type="submit" value="Parar Servico" />

<table>
	<tr>
		<td colspan="2"><b>CONFIGURACAO WEBSERVICE</b></td>
	</tr>
	<tr>
		<td>Url</td>
		<td><input type="text" name="bexsbanco_bmfws"
			value="<%=configBean.getBmfws()%>" width="300"></td>
	</tr>
	<tr>
		<td>Usuario</td>
		<td><input type="text" name="bexsbanco_user"
			value="<%=configBean.getUser()%>"></td>
	</tr>
	<tr>
		<td>Senha</td>
		<td><input type="password" name="bexsbanco_password"
			value="<%=configBean.getPassword()%>"></td>
	</tr>
	<tr>
		<td>Tempo para Execução (Minutos)</td>
		<td><input type="text" name="bexsbanco_time_schedule"
			value="<%=configBean.getBexsbancoTimeSchedule()%>"></td>
	</tr>
	<tr>
		<td colspan="2"><b>CONFIGURACAO BANCO DE DADOS</b></td>
	</tr>
	<tr>
		<td>Url</td>
		<td><input type="text" name="bexsbanco_database_url" width="300"
			value="<%=configBean.getDatabaseUrl()%>"></td>
	</tr>
	<tr>
		<td>Driver</td>
		<td><input type="text" name="bexsbanco_database_driver"
			value="<%=configBean.getDatabaseDriver()%>"></td>
	</tr>
	<tr>
		<td>Usuario</td>
		<td><input type="text" name="bexsbanco_database_user"
			value="<%=configBean.getDatabaseUser()%>"></td>
	</tr>
	<tr>
		<td>Senha</td>
		<td><input type="password" name="bexsbanco_database_password"
			value="<%=configBean.getDatabasePassword()%>"></td>
	</tr>
	<tr>
		<td colspan="2"><b>CONFIGURACAO CONSULTA TRANSACAO</b></td>
	</tr>
	<tr>
		<td>Agencia</td>
		<td><input type="text"
			name="bexsbanco_consulta_transacao_agencia"
			value="<%=configBean.getConsultaTransacaoAgencia()%>"></td>
	</tr>
	<tr>
		<td>Conta</td>
		<td><input type="text" name="bexsbanco_consulta_transacao_conta"
			value="<%=configBean.getConsultaTransacaoConta()%>"></td>
	</tr>
	<tr>
		<td>Cod. Identificador</td>
		<td><input type="text"
			name="bexsbanco_consulta_transacao_cod_ident"
			value="<%=configBean.getConsultaTransacaoCodIdent()%>"></td>
	</tr>
	<tr>
		<td>Data Movimento (Deixar em Branco para data atual)</td>
		<td><input type="text"
			name="bexsbanco_consulta_transacao_dt_movimento"
			value="<%=configBean.getConsultaTransacaoMovimento()%>"></td>
	</tr>
	<tr>
		<td>Tipo de Conta</td>
		<td><input type="text" name="bexsbanco_consulta_transacao_tipo"
			value="<%=configBean.getConsultaTransacaoTipo()%>"></td>
	</tr>
	<tr>
		<td colspan="2"><b>CONFIGURACAO CONSULTA EXTRATO</b></td>
	</tr>
	<tr>
		<td>Agencia</td>
		<td><input type="text" name="bexsbanco_consulta_extrato_agencia"
			value="<%=configBean.getConsultaExtratoAgencia()%>"></td>
	</tr>
	<tr>
		<td>Conta</td>
		<td><input type="text" name="bexsbanco_consulta_extrato_conta"
			value="<%=configBean.getConsultaExtratoConta()%>"></td>
	</tr>
	<tr>
		<td>Data Lancamento (Deixar em Branco para data atual)</td>
		<td><input type="text"
			name="bexsbanco_consulta_extrato_data_lancamento"
			value="<%=configBean.getConsultaExtratoDataLancamento()%>"></td>
	</tr>
	<tr>
		<td>Ultimo Movimento</td>
		<td><input type="text"
			name="bexsbanco_consulta_extrato_movimento"
			value="<%=configBean.getConsultaExtratoMovimento()%>"></td>
	</tr>
	<tr>
		<td>Tipo de Conta</td>
		<td><input type="text" name="bexsbanco_consulta_extrato_tipo"
			value="<%=configBean.getConsultaExtratoTipo()%>"></td>
	</tr>
	<tr>
		<td>Dias Anteriores</td>
		<td>
			<input type="text" name="bexsbanco_consulta_extrato_dias_anteriores"
			value="<%=configBean.getDiasAnteriores()%>"></td>
	</tr>
</table>
</form>
</body>
</html>
