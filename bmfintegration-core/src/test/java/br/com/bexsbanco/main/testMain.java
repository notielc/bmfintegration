package br.com.bexsbanco.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.bexsbanco.util.PropertiesUtil;

public class testMain {

	public static void main(String[] args) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd HH:mm");
		
		Calendar cal = Calendar.getInstance();

		Calendar cal2 = Calendar.getInstance();
		int inicio = Integer.parseInt(PropertiesUtil
				.getValor("bexsbanco_consulta_periodo_inicio"));
		cal2.set(Calendar.HOUR_OF_DAY, 8);
		cal2.set(Calendar.MINUTE, 0);

		Calendar cal3 = Calendar.getInstance();
		int fim = Integer.parseInt(PropertiesUtil
				.getValor("bexsbanco_consulta_periodo_fim"));
		cal3.set(Calendar.HOUR_OF_DAY, 22);
		cal3.set(Calendar.MINUTE, 0);
		
		System.out.println("ATUAL "+dateFormat2.format(cal.getTime()));
		System.out.println("INICIO "+dateFormat2.format(cal2.getTime()));
		System.out.println("FIM "+dateFormat2.format(cal3.getTime()));

		if (cal.getTime().after(cal2.getTime()) && cal.getTime().before(cal3.getTime())) {
			System.out.println("dentro");
		} else {
			System.out.println("fora");
		}
		
//		int qtdDias = 5;
//		while (qtdDias > 0) {
//			cal = Calendar.getInstance();
//			
//			cal.add(Calendar.DATE, -qtdDias);
//			String dataAnterior = dateFormat.format(cal.getTime());
//			
//			System.out.println(dataAnterior);
//			
//			System.out.println(qtdDias);
//			
//			qtdDias--;
//		}
		
		
	}
}
