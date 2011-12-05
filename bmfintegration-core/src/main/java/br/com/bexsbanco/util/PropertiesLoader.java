package br.com.bexsbanco.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

	private Properties props;
	private String nomeDoProperties = "/bexsbanco.properties";

	protected PropertiesLoader() {
		props = new Properties();
		InputStream in = this.getClass().getResourceAsStream(nomeDoProperties);
		try {		
			props.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected String getValor(String chave) {
		return (String) props.getProperty(chave);
	}
}
