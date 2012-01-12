package br.com.bexsbanco.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class testMain {

	public static void main(String[] args) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd HH:mm");

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 10);
		cal.set(Calendar.MINUTE, 23);
		System.out.println("Atual:"+dateFormat2.format(cal.getTime()));
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.HOUR, 7);
		cal2.set(Calendar.MINUTE, 0);
		System.out.println("Inicio:"+dateFormat2.format(cal2.getTime()));
		
		Calendar cal3 = Calendar.getInstance();
		cal3.set(Calendar.HOUR, 22);
		cal3.set(Calendar.MINUTE, 0);
		System.out.println("Fim:"+dateFormat2.format(cal3.getTime()));
		
		if(cal.after(cal2) && cal.before(cal3)){
			System.out.println("estou dentro");
		} else {
			System.out.println("estou fora");
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
