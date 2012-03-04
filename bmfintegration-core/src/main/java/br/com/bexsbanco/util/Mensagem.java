package br.com.bexsbanco.util;

public class Mensagem {

	private String destinatario;
	private String assunto;
	private String mensagem;

	public Mensagem() {
		super();
	}

	public Mensagem(String destinatario, String assunto, String mensagem) {
		super();
		this.destinatario = destinatario;
		this.assunto = assunto;
		this.mensagem = mensagem;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
