package br.com.bexsbanco.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.com.bexsbanco.logs.BexBancoLogger;
import br.com.bexsbanco.scheduler.BmfScheduler;

public class AutoRunListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			BmfScheduler.shutdownScheduler();
		} catch (Exception e) {
			BexBancoLogger.loggerInfo("Erro ao criar properties");
			e.printStackTrace();
		}

	}

	public void contextInitialized(ServletContextEvent arg0) {
		try {
			BmfScheduler.startScheduler();
		} catch (Exception e) {
			BexBancoLogger.loggerInfo("Erro ao criar properties");
			e.printStackTrace();
		}
	}

}
