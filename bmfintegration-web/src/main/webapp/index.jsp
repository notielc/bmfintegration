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
</form>
<table>
	<tr>
		<td>Webservice BM&F = <%=configBean.getBmfws()%></td>
	</tr>
	<tr>
		<td>Usuario para acesso = <%=configBean.getUser()%></td>
	</tr>
	<tr>
		<td>Agendar consultas(Segundos) = <%=configBean.getBexsbancoTimeSchedule()%>
		</td>
	</tr>
</table>
<br>
<table>
	<tr>
		<td><b>CONFIGURACAO CONSULTA TRANSACAO</b></td>
	</tr>
	<tr>
		<td>Agencia=<%=configBean.getConsultaTransacaoAgencia()%></td>
	</tr>
	<tr>
		<td>Conta=<%=configBean.getConsultaTransacaoConta()%></td>
	</tr>
	<tr>
		<td>Cod. Identificador=<%=configBean.getConsultaTransacaoCodIdent()%>
		</td>
	</tr>
	<tr>
		<td>Movimento=<%=configBean.getConsultaTransacaoMovimento()%></td>
	</tr>
	<tr>
		<td>Tipo de Conta=<%=configBean.getConsultaTransacaoTipo()%></td>
	</tr>
</table>
<br>
<table>
	<tr>
		<td><b>CONFIGURACAO CONSULTA EXTRATO</b></td>
	</tr>
	<tr>
		<td>Agencia=<%=configBean.getConsultaExtratoAgencia()%></td>
	</tr>
	<tr>
		<td>Conta=<%=configBean.getConsultaExtratoConta()%></td>
	</tr>
	<tr>
		<td>Data do Lancamento=<%=configBean.getConsultaExtratoDataLancamento()%>
		</td>
	</tr>
	<tr>
		<td>Movimento=<%=configBean.getConsultaExtratoMovimento()%></td>
	</tr>
	<tr>
		<td>Tipo=<%=configBean.getConsultaTransacaoTipo()%></td>
	</tr>
</table>
</body>
</html>
