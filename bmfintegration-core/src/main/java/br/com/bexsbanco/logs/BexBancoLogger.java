package br.com.bexsbanco.logs;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	}

}
