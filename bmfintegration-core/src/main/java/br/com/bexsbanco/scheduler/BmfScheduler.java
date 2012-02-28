package br.com.bexsbanco.scheduler;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import br.com.bexsbanco.beans.ConfigurationBean;
import br.com.bexsbanco.jobs.ConsultaExtratoJob;
import br.com.bexsbanco.jobs.ConsultaLoteJob;
import br.com.bexsbanco.jobs.ConsultaTransacaoJob;
import br.com.bexsbanco.util.PropertiesUtil;

public class BmfScheduler {

	private static Scheduler scheduler;
	public static boolean status;

	public static void startScheduler() {
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();

			scheduler.start();

			//incluirConsultaTransacao();
			//incluirConsultaLote();
			incluirConsultaExtrato();

			ConfigurationBean.setSchedulerStatus("Running");
			status = true;

		} catch (SchedulerException e) {
			// TODO:implementar Logs
			e.printStackTrace();
		}
	}

	private static void incluirConsultaTransacao() throws SchedulerException {
		// incluindo jobs
		JobDetail consultaTransacaoJob = newJob(ConsultaTransacaoJob.class)
				.withIdentity("consultaTransacaoJob", "consultaTransacaoJob").build();

		// configurando o valor do timer
		Trigger trigger = newTrigger()
				.withIdentity("consultaTransacaoTrigger", "consultaTransacaoTrigger")
				.startNow()
				.withSchedule(
						simpleSchedule().withIntervalInMinutes(
								Integer.parseInt(PropertiesUtil
										.getValor("bexsbanco_time_schedule")))
								.repeatForever()).build();

		// adicionando servico no agendador
		scheduler.scheduleJob(consultaTransacaoJob, trigger);
	}
	
	private static void incluirConsultaLote() throws SchedulerException {
		// incluindo jobs
		JobDetail consultaLoteJob = newJob(ConsultaLoteJob.class)
				.withIdentity("consultaLoteJob", "consultaLoteJob").build();

		// configurando o valor do timer
		Trigger trigger = newTrigger()
				.withIdentity("consultaLoteTrigger", "consultaLoteTrigger")
				.startNow()
				.withSchedule(
						simpleSchedule().withIntervalInMinutes(
								Integer.parseInt(PropertiesUtil
										.getValor("bexsbanco_time_schedule")))
								.repeatForever()).build();

		// adicionando servico no agendador
		scheduler.scheduleJob(consultaLoteJob, trigger);
	}
	
	private static void incluirConsultaExtrato() throws SchedulerException {
		// incluindo jobs
		JobDetail consultaExtratoJob = newJob(ConsultaExtratoJob.class)
				.withIdentity("consultaExtratoJob", "consultaExtratoJob").build();

		// configurando o valor do timer
		Trigger trigger = newTrigger()
				.withIdentity("consultaExtratoTrigger", "consultaExtratoTrigger")
				.startNow()
				.withSchedule(
						simpleSchedule().withIntervalInMinutes(
								Integer.parseInt(PropertiesUtil
										.getValor("bexsbanco_time_schedule")))
								.repeatForever()).build();

		// adicionando servico no agendador
		scheduler.scheduleJob(consultaExtratoJob, trigger);
	}

	public static void shutdownScheduler() {
		if (scheduler != null) {
			try {
				scheduler.shutdown(true);

				ConfigurationBean.setSchedulerStatus("Not Running");
				status = false;
			} catch (SchedulerException e) {
				// TODO: Implentar log de aviso
				e.printStackTrace();
			}
		} else {
			// TODO: Implentar log de aviso
		}
	}
}
