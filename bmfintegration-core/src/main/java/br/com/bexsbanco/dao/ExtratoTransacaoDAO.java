package br.com.bexsbanco.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.bexsbanco.logs.BexBancoLogger;
import br.com.bexsbanco.pojos.consulta.extrato.ContaBmf;
import br.com.bexsbanco.pojos.consulta.extrato.Movimento;

import com.mysql.jdbc.Connection;

public class ExtratoTransacaoDAO {

	public void saveLoteTransacao(ContaBmf contaBmf,
			List<Movimento> movimentoList) {

		if (contaBmf != null && movimentoList != null
				&& movimentoList.size() > 0) {

			try {
				Connection connection = ConnectionFactory.createConnection();

				for (Movimento movimento : movimentoList) {

					if (findMovimento(movimento.getNumMotivo())) {

						String insertQuery = "update extrato set banco=? ,agencia=?,conta=?,dt_saldo_ant=?,dt_saldo_atual=?,vlr_saldo=?," +
								"cod_ident=?,dt_lancamento=?,num_movto=?,num_docto=?,cod_hist=?,desc_hist=?,vlr_lanc=?,tp_deb_cred=?," +
								"bco_ctp=?,age_ctp=?,cta_ctp=?,tipo_cta_ctp=?,cnpj_cpf_ctp_titular1=?,nome_ctp_titular1=?,cnpj_cpf_ctp_titular2=?," +
								"nome_ctp_titular2=?,tp_pessoa_ctp=?,cod_cli=?,tp_pessoa_invest=?,cnpj_cpfinvest=?,nom_rzsocInvest=?, data=? " +
								" where num_movto=? ";

						PreparedStatement st;

						st = connection.prepareStatement(insertQuery);
						st.setString(1, contaBmf.getBanco());
						st.setString(2, contaBmf.getAgencia());
						st.setString(3, contaBmf.getConta());
						st.setString(4, contaBmf.getDtSaldoAnt());
						st.setString(5, contaBmf.getDtSaldoAtual());
						st.setString(6, contaBmf.getVlrSaldo());
						st.setString(7, movimento.getCodIdent());
						st.setString(8, movimento.getDtLancamento());
						st.setString(9, movimento.getNumMotivo());
						st.setString(10, movimento.getDocumento());
						st.setString(11, movimento.getCodHistorico());
						st.setString(12, movimento.getDescHistorico());
						st.setString(13, movimento.getVlrLancamento());
						st.setString(14, movimento.getTipoCreditoDebito());
						st.setString(15, movimento.getBancoCtp());
						st.setString(16, movimento.getAgencia());
						st.setString(17, movimento.getConta());
						st.setString(18, movimento.getTipo());
						st.setString(19, movimento.getDocTitular1());
						st.setString(20, movimento.getNomeTitular1());
						st.setString(21, movimento.getDocTitular2());
						st.setString(22, movimento.getNomeTitular2());
						st.setString(23, movimento.getTipoPessoaCtp());
						st.setString(24, movimento.getCodCliente());
						st.setString(25, movimento.getTipoPessoaInvest());
						st.setString(26, movimento.getDocumentoInvest());
						st.setString(27, movimento.getRazaoSocialInvest());
						st.setString(28, new SimpleDateFormat(
								"dd/MM/yyyy HH:mm:ss").format(new Date()));
						st.setString(29, movimento.getNumMotivo());

						st.executeUpdate();

						st.close();

					} else {

						int maxId = getMaxId();

						String insertQuery = "insert into extrato(id,banco,agencia,conta,dt_saldo_ant,dt_saldo_atual,vlr_saldo,cod_ident,dt_lancamento,"
								+ "num_movto,num_docto,cod_hist,desc_hist,vlr_lanc,tp_deb_cred,bco_ctp,age_ctp,cta_ctp,tipo_cta_ctp,cnpj_cpf_ctp_titular1,"
								+ "nome_ctp_titular1,cnpj_cpf_ctp_titular2,nome_ctp_titular2,tp_pessoa_ctp,cod_cli,tp_pessoa_invest,cnpj_cpfinvest,"
								+ "nom_rzsocInvest, data) "
								+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

						PreparedStatement st;

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
						st.setString(29, new SimpleDateFormat(
								"dd/MM/yyyy HH:mm:ss").format(new Date()));

						st.executeUpdate();

						st.close();
					}

				}
			} catch (SQLException e) {
				BexBancoLogger.loggerError("Erro ao salvar extrato:"
						+ e.getMessage());
			} finally {
				ConnectionFactory.destroyConnection();
			}
		}
	}

	public boolean findMovimento(String numMovto) {

		boolean result = false;

		Connection connection = ConnectionFactory.createConnection();

		String selectQuery = "select num_movto from extrato where num_movto = ? ";

		PreparedStatement st;
		try {
			st = connection.prepareStatement(selectQuery);
			st.setString(1, numMovto);
			ResultSet resultSet = st.executeQuery();
			if (resultSet.next()) {
				result = true;
			}
			resultSet.close();
			st.close();

		} catch (SQLException e) {
			BexBancoLogger.loggerError("Erro ao verificar movimento existente:"
					+ e.getMessage());
		} finally {
			ConnectionFactory.destroyConnection();
		}

		return result;
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
			BexBancoLogger.loggerError("Erro ao recuperar o ID:"
					+ e.getMessage());
		} finally {
			ConnectionFactory.destroyConnection();
		}

		return ++maxId;
	}
}
