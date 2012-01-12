package br.com.bexsbanco.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bexsbanco.logs.BexBancoLogger;
import br.com.bexsbanco.scheduler.BmfScheduler;

public class SchedulerServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(!BmfScheduler.status) {
			
			FileOutputStream saida;
			PrintStream fileSaida;
			try {
				
				saida = new FileOutputStream("/bexsbanco.properties");
				fileSaida = new PrintStream(saida);
				
				fileSaida.println("####CONFIGURACAO DE WEBSERVICE####");
				fileSaida.print("bexsbanco_bmfws=");
				fileSaida.println(req.getParameter("bexsbanco_bmfws"));
				fileSaida.print("bexsbanco_user=");
				fileSaida.println(req.getParameter("bexsbanco_user"));
				fileSaida.print("bexsbanco_password=");
				fileSaida.println(req.getParameter("bexsbanco_password"));
				fileSaida.print("bexsbanco_time_schedule=");
				fileSaida.println(req.getParameter("bexsbanco_time_schedule"));
				
				fileSaida.println("####CONFIGURACAO DE BANCO DE DADOS####");
				fileSaida.print("bexsbanco_database_url=");
				fileSaida.println(req.getParameter("bexsbanco_database_url"));
				fileSaida.print("bexsbanco_database_driver=");
				fileSaida.println(req.getParameter("bexsbanco_database_driver"));
				fileSaida.print("bexsbanco_database_user=");
				fileSaida.println(req.getParameter("bexsbanco_database_user"));
				fileSaida.print("bexsbanco_database_password=");
				fileSaida.println(req.getParameter("bexsbanco_database_password"));
				
				fileSaida.println("####CONFIGURACAO CONSULTA TRANSACAO####");
				fileSaida.print("bexsbanco_consulta_transacao_agencia=");
				fileSaida.println(req.getParameter("bexsbanco_consulta_transacao_agencia"));
				fileSaida.print("bexsbanco_consulta_transacao_conta=");
				fileSaida.println(req.getParameter("bexsbanco_consulta_transacao_conta"));
				fileSaida.print("bexsbanco_consulta_transacao_cod_ident=");
				fileSaida.println(req.getParameter("bexsbanco_consulta_transacao_cod_ident"));
				fileSaida.print("bexsbanco_consulta_transacao_dt_movimento=");
				fileSaida.println(req.getParameter("bexsbanco_consulta_transacao_dt_movimento"));
				fileSaida.print("bexsbanco_consulta_transacao_tipo=");
				fileSaida.println(req.getParameter("bexsbanco_consulta_transacao_tipo"));
				
				fileSaida.println("####CONFIGURACAO CONSULTA EXTRATO####");
				fileSaida.print("bexsbanco_consulta_extrato_agencia=");
				fileSaida.println(req.getParameter("bexsbanco_consulta_extrato_agencia"));
				fileSaida.print("bexsbanco_consulta_extrato_conta=");
				fileSaida.println(req.getParameter("bexsbanco_consulta_extrato_conta"));
				fileSaida.print("bexsbanco_consulta_extrato_data_lancamento=");
				fileSaida.println(req.getParameter("bexsbanco_consulta_extrato_data_lancamento"));
				fileSaida.print("bexsbanco_consulta_extrato_movimento=");
				fileSaida.println(req.getParameter("bexsbanco_consulta_extrato_movimento"));
				fileSaida.print("bexsbanco_consulta_extrato_tipo=");
				fileSaida.println(req.getParameter("bexsbanco_consulta_extrato_tipo"));
				fileSaida.print("bexsbanco_consulta_extrato_dias_anteriores=");
				fileSaida.println(req.getParameter("bexsbanco_consulta_extrato_dias_anteriores"));
				
				fileSaida.print("bexsbanco_consulta_periodo_inicio=");
				fileSaida.println(req.getParameter("bexsbanco_consulta_periodo_inicio"));
				fileSaida.print("bexsbanco_consulta_periodo_fim=");
				fileSaida.println(req.getParameter("bexsbanco_consulta_periodo_fim"));

				BmfScheduler.startScheduler();
			
			} catch (Exception e) {
				BexBancoLogger.loggerInfo("Erro ao criar properties");
				e.printStackTrace();
			}
			
		} else {
			BmfScheduler.shutdownScheduler();
		}
		
		resp.sendRedirect("index.jsp");
	}
}
