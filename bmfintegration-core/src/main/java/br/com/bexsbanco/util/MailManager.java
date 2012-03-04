package br.com.bexsbanco.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class MailManager {

	private String hostName;
	private String usuario;
	private String senha;
	private String email;
	private Boolean ssl;

	private SimpleEmail simpleEmail;

	public MailManager() {
		this.simpleEmail = new SimpleEmail();
		
		hostName = PropertiesUtil.getValor("bexsbanco_email_host");
		usuario = PropertiesUtil.getValor("bexsbanco_email_login");
		senha = PropertiesUtil.getValor("bexsbanco_email_senha");
		email = PropertiesUtil.getValor("bexsbanco_email_recebimento");
		ssl = (PropertiesUtil.getValor("bexsbanco_email_ssl") != null && !PropertiesUtil.getValor("bexsbanco_email_ssl").isEmpty() ? true : false);
	}

	public void enviarMensagem(Mensagem mensagem) throws EmailException {

		simpleEmail.setHostName(hostName);
		simpleEmail.setAuthentication(usuario, senha);
		simpleEmail.setSSL(ssl);

		simpleEmail.setFrom(email);
		simpleEmail.addTo(mensagem.getDestinatario());
		simpleEmail.setSubject(mensagem.getAssunto());
		simpleEmail.setMsg(mensagem.getMensagem());

		simpleEmail.send();

	}
}
