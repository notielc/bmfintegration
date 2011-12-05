package br.com.bexsbanco.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.bexsbanco.util.PropertiesUtil;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {

	private static Connection conn;
	
	public static Connection createConnection(){

		try {

		Class.forName(PropertiesUtil.getValor("bexsbanco_database_driver"));
		conn = (Connection) DriverManager.getConnection (PropertiesUtil.getValor("bexsbanco_database_url"), PropertiesUtil.getValor("bexsbanco_database_user"),PropertiesUtil.getValor("bexsbanco_database_password"));
		
		} catch (Exception e) {
			//TODO:implementar logs
			e.printStackTrace();
		}

		return conn;
	}
	
	public static void destroyConnection(){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO implementar logs
				e.printStackTrace();
			}
		}
	}
}
