package br.com.bexsbanco.logs;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.mail.EmailException;

import br.com.bexsbanco.util.MailManager;
import br.com.bexsbanco.util.Mensagem;
import br.com.bexsbanco.util.PropertiesUtil;

public class BexBancoLogger {

	private static Logger logger = Logger.getLogger("br.com.bexsbanco");
	private static FileHandler fileHandler;

	static {

		try {
			fileHandler = new FileHandler("bexbanco.log");
			logger.addHandler(fileHandler);
			logger.setLevel(Level.ALL);
		} catch (SecurityException e) {
			System.out.println("[ERROR]Erro ao instanciar FileHanlder");
		} catch (IOException e) {
			System.out.println("[ERROR]Erro ao instanciar FileHanlder");
		}

	}

	public static void loggerInfo(String msg) {
		logger.info(msg
				+ " - "
				+ new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(new Date()));
	}

	public static void loggerWarn(String msg) {
		logger.warning(msg
				+ " - "
				+ new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(new Date()));
	}

	public static void loggerError(String msg) {
		logger.severe(msg
				+ " - "
				+ new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(new Date()));
		
		Mensagem mensagem = new Mensagem();
		mensagem.setAssunto("Erro na integração com o BMF");
		mensagem.setDestinatario(PropertiesUtil.getValor("bexbanco_email_recebimento"));
		mensagem.setMensagem(msg);
		
		MailManager sendMail = new MailManager();
		try {
			sendMail.enviarMensagem(mensagem);
		} catch (EmailException e) {
			logger.severe("Erro ao enviar email: "
					+ e.getMessage()
					+ " - "
					+ new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
							.format(new Date()));
		}
	}

}
