package br.com.bexsbanco.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class testMain {

	public static void main(String[] args) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

		Calendar cal = Calendar.getInstance();
	
		System.out.println(dateFormat.format(cal.getTime()));
		
		cal.add(Calendar.DATE, -10);
		
		System.out.println(dateFormat.format(cal.getTime()));
	}
}
