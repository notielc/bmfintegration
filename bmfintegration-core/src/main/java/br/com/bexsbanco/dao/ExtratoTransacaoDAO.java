package br.com.bexsbanco.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.bexsbanco.pojos.consulta.extrato.ContaBmf;
import br.com.bexsbanco.pojos.consulta.extrato.Movimento;

import com.mysql.jdbc.Connection;

public class ExtratoTransacaoDAO {

	public void saveLoteTransacao(ContaBmf contaBmf, Movimento movimento) {

		if (contaBmf != null && movimento != null) {
			int maxId = getMaxId();

			Connection connection = ConnectionFactory.createConnection();

			String insertQuery = "insert into extrato(id,banco,agencia,conta,dt_saldo_ant,dt_saldo_atual,vlr_saldo,cod_ident,dt_lancamento,"
					+ "num_movto,num_docto,cod_hist,desc_hist,vlr_lanc,tp_deb_cred,bco_ctp,age_ctp,cta_ctp,tipo_cta_ctp,cnpj_cpf_ctp_titular1,"
					+ "nome_ctp_titular1,cnpj_cpf_ctp_titular2,nome_ctp_titular2,tp_pessoa_ctp,cod_cli,tp_pessoa_invest,cnpj_cpfinvest,"
					+ "nom_rzsocInvest) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st;
			try {

				st = connection.prepareStatement(insertQuery);
				st.setInt(1, maxId);
				st.setString(2, contaBmf.getBanco());
				st.setString(3, contaBmf.getAgencia());
				st.setString(4, contaBmf.getConta());
				st.setString(5, contaBmf.getDtSaldoAnt());
				st.setString(6, contaBmf.getDtSaldoAtual());
				st.setString(7, contaBmf.getVlrSaldo());
				st.setString(8, movimento.getCodIdent());
				st.setString(9, movimento.getDtLancamento());
				st.setString(10, movimento.getNumMotivo());
				st.setString(11, movimento.getDocumento());
				st.setString(12, movimento.getCodHistorico());
				st.setString(13, movimento.getDescHistorico());
				st.setString(14, movimento.getVlrLancamento());
				st.setString(15, movimento.getTipoCreditoDebito());
				st.setString(16, movimento.getBancoCtp());
				st.setString(17, movimento.getAgencia());
				st.setString(18, movimento.getConta());
				st.setString(19, movimento.getTipo());
				st.setString(20, movimento.getDocTitular1());
				st.setString(21, movimento.getNomeTitular1());
				st.setString(22, movimento.getDocTitular2());
				st.setString(23, movimento.getNomeTitular2());
				st.setString(24, movimento.getTipoPessoaCtp());
				st.setString(25, movimento.getCodCliente());
				st.setString(26, movimento.getTipoPessoaInvest());
				st.setString(27, movimento.getDocumentoInvest());
				st.setString(28, movimento.getRazaoSocialInvest());

				st.executeUpdate();

				st.close();

			} catch (SQLException e) {
				// TODO implementar logs
				e.printStackTrace();
			} finally {
				ConnectionFactory.destroyConnection();
			}
		}
	}

	public int getMaxId() {

		Connection connection = ConnectionFactory.createConnection();

		String selectQuery = "select max(id) from extrato";

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
			// TODO implementar logs
			e.printStackTrace();
		} finally {
			ConnectionFactory.destroyConnection();
		}

		return ++maxId;
	}
}
