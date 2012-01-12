package br.com.bexsbanco.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class testMain {

	public static void main(String[] args) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		int qtdDias = 5;
		while (qtdDias > 0) {
			cal = Calendar.getInstance();
			
			cal.add(Calendar.DATE, -qtdDias);
			String dataAnterior = dateFormat.format(cal.getTime());
			
			System.out.println(dataAnterior);
			
			System.out.println(qtdDias);
			
			qtdDias--;
		}
	}
}
