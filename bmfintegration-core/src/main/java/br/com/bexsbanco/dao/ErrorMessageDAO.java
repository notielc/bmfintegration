package br.com.bexsbanco.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.bexsbanco.pojos.consulta.ErrorMessage;

import com.mysql.jdbc.Connection;

public class ErrorMessageDAO {

	public void saveErrorMessage(String operacao, ErrorMessage errorMessage ){
		
		int maxId = getMaxId();
		
		Connection connection = ConnectionFactory.createConnection();
		
		String insertQuery = "insert into error_message(id,operacao,nome_requisicao,error_id,data) values(?,?,?,?,?)" ;
		
		PreparedStatement st;
		try {
			st = connection.prepareStatement(insertQuery);
			st.setInt(1, maxId);
			st.setString(2, operacao);
			st.setString(3, errorMessage.getNameReq());
			st.setString(4, errorMessage.getErrorId());
			st.setString(5, errorMessage.getDate());
			
			st.executeUpdate();
			
			st.close();
			
		} catch (SQLException e) {
			//TODO implementar logs
			e.printStackTrace();
		} finally {
			ConnectionFactory.destroyConnection();
		}
	}

	public int getMaxId( ){
		
		Connection connection = ConnectionFactory.createConnection();
		
		String selectQuery = "select max(id) from error_message" ;
		
		int maxId = 0;
		PreparedStatement st;
		try {
			st = connection.prepareStatement(selectQuery);
			ResultSet resultSet = st.executeQuery();
			if(resultSet.next()){
				maxId = resultSet.getInt(1);
			}
			resultSet.close();
			st.close();
			
		} catch (SQLException e) {
			//TODO implementar logs
			e.printStackTrace();
		} finally {
			ConnectionFactory.destroyConnection();
		}
		
		return ++maxId;
	}
}
