package br.com.bexsbanco.jobs;

import java.util.Calendar;

import br.com.bexsbanco.logs.BexBancoLogger;
import br.com.bexsbanco.util.PropertiesUtil;

public class ValidaPeriodoDeExecucao {

	public static boolean validate() {

		boolean result = false;

		try {

			Calendar cal = Calendar.getInstance();

			Calendar cal2 = Calendar.getInstance();
			int inicio = Integer.parseInt(PropertiesUtil
					.getValor("bexsbanco_consulta_periodo_inicio"));
			cal2.set(Calendar.HOUR, inicio);
			cal2.set(Calendar.MINUTE, 0);

			Calendar cal3 = Calendar.getInstance();
			int fim = Integer.parseInt(PropertiesUtil
					.getValor("bexsbanco_consulta_periodo_fim"));
			cal3.set(Calendar.HOUR, fim);
			cal3.set(Calendar.MINUTE, 0);

			if (cal.after(cal2) && cal.before(cal3)) {
				result = true;
			}

		} catch (Exception e) {
			BexBancoLogger.loggerError("Error ao validar o periodo de execucao: "+e.getMessage());
		}

		return result;
	}
}
