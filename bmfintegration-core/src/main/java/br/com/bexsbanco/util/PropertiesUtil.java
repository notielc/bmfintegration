package br.com.bexsbanco.util;

public class PropertiesUtil {


	public static String getValor(String chave) {
		PropertiesLoader loader = new PropertiesLoader();
		return (String) loader.getValor(chave);
	}
}
