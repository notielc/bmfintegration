package br.com.bexsbanco.jobs;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import br.com.bexsbanco.services.ConsultaLoteService;

public class ConsultaLoteJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Iniciando consulta de lote");

		ConsultaLoteService consultaLoteService = new ConsultaLoteService();
		boolean resultadoConsulta = consultaLoteService.consultaLote();
		
		if (resultadoConsulta) {
			System.out.println("Consulta lote realizada com sucesso: "
					+ new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
							.format(new Date()));
		} else {
			System.out.println("Consulta lote não foi realizada com sucesso: "
					+ new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
							.format(new Date()));
		}
	}

}
