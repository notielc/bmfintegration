package br.com.bexsbanco.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.bexsbanco.logs.BexBancoLogger;
import br.com.bexsbanco.pojos.consulta.lote.Erro;
import br.com.bexsbanco.pojos.consulta.lote.LoteTransacao;
import br.com.bexsbanco.pojos.consulta.transacao.Transacao;

import com.mysql.jdbc.Connection;

public class LoteTransacaoDAO {

	public void saveLoteTransacao(LoteTransacao loteTransacao) {

		Connection connection = ConnectionFactory.createConnection();

		String insertQuery = "insert into lote_transacao(id,lote_transacao,transacao,situacao,error_id,data) values(?,?,?,?,?,?)";

		PreparedStatement st;
		try {
			for (Transacao transacao : loteTransacao.getTransacaoLote()) {
				if (transacao.getErro() != null) {
					for (Erro erro : transacao.getErro()) {

						st = connection.prepareStatement(insertQuery);
						int maxId = getMaxId();
						st.setInt(1, maxId);
						st.setString(2, loteTransacao.getId());
						st.setString(3, transacao.getCodIdent().getValue());
						st.setString(4, transacao.getCodIdent().getSituacao());
						st.setString(5, erro.getCodErro());
						st.setString(6, new SimpleDateFormat(
								"dd/MM/yyyy HH:mm:ss").format(new Date()));

						st.executeUpdate();

						st.close();
					}
				}  else {
					st = connection.prepareStatement(insertQuery);
					int maxId = getMaxId();
					st.setInt(1, maxId);
					st.setString(2, loteTransacao.getId());
					st.setString(3, transacao.getCodIdent().getValue());
					st.setString(4, transacao.getCodIdent().getSituacao());
					st.setString(5, null);
					st.setString(6, new SimpleDateFormat(
							"dd/MM/yyyy HH:mm:ss").format(new Date()));

					st.executeUpdate();

					st.close();
				}
			}

		} catch (SQLException e) {
			BexBancoLogger.loggerError("Erro ao salvar transacao:"+e.getMessage());
		} finally {
			ConnectionFactory.destroyConnection();
		}
	}

	public int getMaxId() {

		Connection connection = ConnectionFactory.createConnection();

		String selectQuery = "select max(id) from lote_transacao";

		int maxId = 0;
		PreparedStatement st;
		try {
			st = connection.prepareStatement(selectQuery);
			ResultSet resultSet = st.executeQuery();
			if (resultSet.next()) {
				maxId = resultSet.getInt(1);
			}
			resultSet.close();
			st.close();

		} catch (SQLException e) {
			BexBancoLogger.loggerError("Erro ao recuperar o ID:"+e.getMessage());
		} finally {
			ConnectionFactory.destroyConnection();
		}

		maxId++;

		return maxId;
	}
}
