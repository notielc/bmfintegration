package br.com.bexsbanco.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class WebServiceUtils {

	public static String send(String[] keys, String[] values) {

		StringBuffer line = new StringBuffer();
		try {
			// Construct data
			StringBuffer data = new StringBuffer();

			if (keys.length > 0) {

				for (int i = 0; i < keys.length; i++) {
					
					data.append(URLEncoder.encode(keys[i], "UTF-8") + "="
							+ URLEncoder.encode(values[i], "UTF-8"));
					
				}

				// Send data
				URL url = new URL(PropertiesUtil.getValor("bexsbanco_bmfws"));

				URLConnection conn = url.openConnection();
				conn.setDoOutput(true);
				OutputStreamWriter wr = new OutputStreamWriter(
						conn.getOutputStream());
				wr.write(data.toString());
				wr.flush();

				// Get the response
				BufferedReader rd = new BufferedReader(new InputStreamReader(
						conn.getInputStream()));
				String readLine;
				while ((readLine = rd.readLine()) != null) {
					line.append(readLine);
				}
				wr.close();
				rd.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return line.toString();

	}
}
