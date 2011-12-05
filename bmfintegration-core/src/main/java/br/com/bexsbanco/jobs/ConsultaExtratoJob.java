package br.com.bexsbanco.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import br.com.bexsbanco.logs.BexBancoLogger;
import br.com.bexsbanco.services.ConsultaExtratoService;

public class ConsultaExtratoJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		BexBancoLogger.loggerInfo("Iniciando consulta de extrato");

		ConsultaExtratoService consultaExtratoService = new ConsultaExtratoService();
		boolean resultadoConsulta = consultaExtratoService.consultaExtrato();

		if (resultadoConsulta) {
			BexBancoLogger.loggerInfo("Consulta extrato realizada com sucesso");
		} else {
			BexBancoLogger.loggerError("Consulta extrato não foi realizada com sucesso ");
		}
	}

}
