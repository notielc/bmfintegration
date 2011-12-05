package br.com.bexsbanco.util;

public class PropertiesUtil {

	private static PropertiesLoader loader = new PropertiesLoader();

	public static String getValor(String chave) {
		return (String) loader.getValor(chave);
	}
}
