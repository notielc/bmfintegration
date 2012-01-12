package br.com.bexsbanco.jobs;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import br.com.bexsbanco.logs.BexBancoLogger;
import br.com.bexsbanco.services.ConsultaTransacaoService;

public class ConsultaTransacaoJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Iniciando consulta de Transacao");

		if (ValidaPeriodoDeExecucao.validate()) {
			ConsultaTransacaoService consultaTransacaoService = new ConsultaTransacaoService();
			boolean resultadoConsulta = consultaTransacaoService
					.consultaTransacao();

			if (resultadoConsulta) {
				System.out.println("Consulta transacao realizada com sucesso: "
						+ new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
								.format(new Date()));
			} else {
				System.out
						.println("Consulta transacao não foi realizada com sucesso: "
								+ new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
										.format(new Date()));
			}

		} else {
			BexBancoLogger.loggerInfo("Fora do periodo de consulta ");

		}
	}

}
