package br.com.bexsbanco.services;

import br.com.bexsbanco.converters.consulta.lote.xml.ConsultaTransacaoXmlConverter;
import br.com.bexsbanco.dao.ErrorMessageDAO;
import br.com.bexsbanco.dao.LoteTransacaoDAO;
import br.com.bexsbanco.enums.UrlKeys;
import br.com.bexsbanco.logs.BexBancoLogger;
import br.com.bexsbanco.pojos.DocPojo;
import br.com.bexsbanco.pojos.consulta.ConsultaSisMsg;
import br.com.bexsbanco.pojos.consulta.lote.CodIdent;
import br.com.bexsbanco.pojos.consulta.lote.LoteTransacao;
import br.com.bexsbanco.pojos.consulta.transacao.Transacao;
import br.com.bexsbanco.util.DllUtils;
import br.com.bexsbanco.util.NumberUtils;
import br.com.bexsbanco.util.PropertiesUtil;
import br.com.bexsbanco.util.WebServiceUtils;

public class ConsultaTransacaoService {

	public boolean consultaTransacao() {

		Integer idLogger = NumberUtils.randomId();

		try {

			Transacao transacao = new Transacao();
			transacao.setAgencia(PropertiesUtil
					.getValor("bexsbanco_consulta_transacao_agencia"));
			transacao.setConta(PropertiesUtil
					.getValor("bexsbanco_consulta_transacao_conta"));
			CodIdent codIdent = new CodIdent();
			codIdent.setValue(PropertiesUtil
					.getValor("bexsbanco_consulta_transacao_cod_ident"));
			transacao.setCodIdent(codIdent);
			transacao.setMovimento(PropertiesUtil
					.getValor("bexsbanco_consulta_transacao_movimento"));
			transacao.setTipo(PropertiesUtil
					.getValor("bexsbanco_consulta_transacao_tipo"));

			String xml = ConsultaTransacaoXmlConverter.toXML(NumberUtils
					.randomId().toString(), transacao);

			BexBancoLogger.loggerInfo("[" + idLogger
					+ "]XML para envio sem security:" + xml);

			String xmlSigned = DllUtils.assinaBmf("BBMFReqTransacaoSit", xml,
					idLogger);

			BexBancoLogger.loggerInfo("[" + idLogger
					+ "]XML para envio com security:" + xmlSigned);

			if (xmlSigned != null) {
				String response = WebServiceUtils.send(
						new String[] { UrlKeys.XML.getDesc() },
						new String[] { xml });

				BexBancoLogger.loggerInfo("[" + idLogger + "]XML de resposta:"
						+ response);

				DocPojo responseObject = ConsultaTransacaoXmlConverter
						.fromXML(response);

				LoteTransacaoDAO dao = new LoteTransacaoDAO();
				ErrorMessageDAO errorMessageDAO = new ErrorMessageDAO();
				if (responseObject != null) {
					ConsultaSisMsg consultaTransacaoResponse = (ConsultaSisMsg) responseObject
							.getSisMsg();
					if (consultaTransacaoResponse != null
							&& consultaTransacaoResponse
									.getConsultaLoteReqResponse() != null) {
						for (LoteTransacao loteTransacao : consultaTransacaoResponse
								.getConsultaLoteReqResponse()
								.getLoteTransacao()) {

							dao.saveLoteTransacao(loteTransacao);
						}
					} else if (consultaTransacaoResponse != null
							&& consultaTransacaoResponse
									.getConsultaLoteReqErrorMessage() != null) {
						errorMessageDAO.saveErrorMessage("ConsultaTransacao",
								consultaTransacaoResponse
										.getConsultaLoteReqErrorMessage());
					}
				}

			}

		} catch (Exception e) {
			BexBancoLogger.loggerError("[" + idLogger
					+ "]Ocorreu algum erro na consulta de extrato :"
					+ e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public String consultaTransacao(Transacao transacao) {
		Integer idLogger = NumberUtils.randomId();
		String xmlResult = "";
		try {

			String xml = ConsultaTransacaoXmlConverter.toXML(NumberUtils
					.randomId().toString(), transacao);

			BexBancoLogger.loggerInfo("[" + idLogger
					+ "]XML para envio sem security:" + xml);

			String xmlSigned = DllUtils.assinaBmf("BBMFReqTransacaoSit", xml,
					idLogger);

			BexBancoLogger.loggerInfo("[" + idLogger
					+ "]XML para envio com security:" + xmlSigned);

			if (xmlSigned != null) {
				xmlResult = WebServiceUtils.send(
						new String[] { UrlKeys.XML.getDesc() },
						new String[] { xml });

				BexBancoLogger.loggerInfo("[" + idLogger + "]XML de resposta:"
						+ xmlResult);
			}

		} catch (Exception e) {
			BexBancoLogger.loggerError("[" + idLogger
					+ "]Ocorreu algum erro na consulta de extrato :"
					+ e.getMessage());
			e.printStackTrace();
		}
		
		return xmlResult;

	}
}
