package br.com.bexsbanco.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import br.com.bexsbanco.logs.BexBancoLogger;

public class WebServiceUtils {

	public static String send(String key, String value) {

		StringBuffer line = new StringBuffer();
		try {

			if (key.length() > 0) {

				HttpClient httpClient = new HttpClient();
				PostMethod postMethod = new PostMethod(
						PropertiesUtil.getValor("bexsbanco_bmfws"));
				postMethod.addParameter(key, value);
				BexBancoLogger.loggerInfo("Value for Post: "+value);
				httpClient.executeMethod(postMethod);
				InputStream is = postMethod.getResponseBodyAsStream();
				BufferedReader rd = new BufferedReader(
						new InputStreamReader(is));

//				// Send data
//				URL url = new URL(PropertiesUtil.getValor("bexsbanco_bmfws"));
//
//				URLConnection conn = url.openConnection();
//				conn.setRequestProperty("Content-Type",
//						"application/x-www-form-urlencoded;");
//				conn.setDoOutput(true);
//				OutputStreamWriter wr = new OutputStreamWriter(
//						conn.getOutputStream());
//				wr.write(data.toString());
//				wr.flush();
//
//				// Get the response
//				BufferedReader rd = new BufferedReader(new InputStreamReader(
//						conn.getInputStream()));
				String readLine;
				while ((readLine = rd.readLine()) != null) {
					line.append(readLine);
				}
//				wr.close();
				rd.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return line.toString();

	}
}
