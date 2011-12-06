<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title>Simulador BMF</title>
</head>
<body leftmargin="0" rightmargin="0" topmargin="0">
<div id="body_aux">
<div id="imgLogo"><img src="images/logo.png" /></div>
<div id="title">Configurações Integração BM&F</div>
</div>
<form action="SimuladorTeste" method="post">
Consultar: Extrato 
<input type="radio" name="tipo_consulta" value="extrato" checked>
	Transação
<input type="radio" name="tipo_consulta" value="transacao">
<table>
	<tr>
		<td colspan="2"><b>CONFIGURACAO CONSULTA TRANSACAO</b></td>
	</tr>
	<tr>
		<td>Agencia</td>
		<td><input type="text" name="agencia_transacao"></td>
	</tr>
	<tr>
		<td>Conta</td>
		<td><input type="text" name="conta_transacao"></td>
	</tr>
	<tr>
		<td>Cod. Identificador</td>
		<td><input type="text" name="codident_transacao"></td>
	</tr>
	<tr>
		<td>Data Movimento</td>
		<td><input type="text" name="data_transacao"></td>
	</tr>
	<tr>
		<td>Tipo de Conta</td>
		<td><input type="text" name="tipo_conta_transacao"></td>
	</tr>
	<tr>
		<td colspan="2"><b>CONFIGURACAO CONSULTA EXTRATO</b></td>
	</tr>
	<tr>
		<td>Agencia</td>
		<td><input type="text" name="agencia_extrato"></td>
	</tr>
	<tr>
		<td>Conta</td>
		<td><input type="text" name="conta_extrato"></td>
	</tr>
	<tr>
		<td>Numero Movimento</td>
		<td><input type="text" name="numero_extrato"></td>
	</tr>
	<tr>
		<td>Data lancamento</td>
		<td><input type="text" name="data_extrato"></td>
	</tr>
	<tr>
		<td>Tipo de Conta</td>
		<td><input type="text" name="tipo_conta_extrato"></td>
	</tr>
</table>
<input type="submit" value="Enviar">
</form>
</body>
</html>