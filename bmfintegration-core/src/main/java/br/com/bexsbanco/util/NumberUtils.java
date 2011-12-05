package br.com.bexsbanco.util;

import java.util.Random;

public class NumberUtils {

	public static Integer randomId(){
		Random random = new Random();
		Integer id = random.nextInt();
		return  id < 0 ? (id*-1) : id  ;
	}	
}
