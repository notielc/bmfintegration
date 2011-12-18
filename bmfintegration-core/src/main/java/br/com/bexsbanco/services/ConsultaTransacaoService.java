package br.com.bexsbanco.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.bexsbanco.converters.consulta.lote.xml.ConsultaTransacaoXmlConverter;
import br.com.bexsbanco.dao.ErrorMessageDAO;
import br.com.bexsbanco.dao.LoteTransacaoDAO;
import br.com.bexsbanco.enums.UrlKeys;
import br.com.bexsbanco.logs.BexBancoLogger;
import br.com.bexsbanco.pojos.DocPojo;
import br.com.bexsbanco.pojos.consulta.ConsultaSisMsg;
import br.com.bexsbanco.pojos.consulta.ErrorMessage;
import br.com.bexsbanco.pojos.consulta.lote.CodIdent;
import br.com.bexsbanco.pojos.consulta.lote.LoteTransacao;
import br.com.bexsbanco.pojos.consulta.transacao.ConsultaTransacaoResponse;
import br.com.bexsbanco.pojos.consulta.transacao.Transacao;
import br.com.bexsbanco.util.DllUtils;
import br.com.bexsbanco.util.NumberUtils;
import br.com.bexsbanco.util.PropertiesUtil;
import br.com.bexsbanco.util.WebServiceUtils;

public class ConsultaTransacaoService {

	public boolean consultaTransacao() {

		Integer idLogger = NumberUtils.randomId();

		try {

			String dataAtual = new SimpleDateFormat("yyyyMMdd").format(new Date());
			
			String dataFormulario = PropertiesUtil.getValor("bexsbanco_consulta_transacao_dt_movimento");
			
			Transacao transacao = new Transacao();
			transacao.setAgencia(PropertiesUtil
					.getValor("bexsbanco_consulta_transacao_agencia"));
			transacao.setConta(PropertiesUtil
					.getValor("bexsbanco_consulta_transacao_conta"));
			CodIdent codIdent = new CodIdent();
			codIdent.setValue(PropertiesUtil
					.getValor("bexsbanco_consulta_transacao_cod_ident"));
			transacao.setCodIdent(codIdent);
			transacao.setMovimento(dataFormulario == null || dataFormulario.trim().equalsIgnoreCase("") ? dataAtual : dataFormulario);
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
				String response = WebServiceUtils.send(UrlKeys.XML.getDesc(),
						xmlSigned);

				BexBancoLogger.loggerInfo("[" + idLogger + "]XML de resposta:"
						+ response);

				DocPojo responseObject = ConsultaTransacaoXmlConverter
						.fromXML(response);

				LoteTransacaoDAO dao = new LoteTransacaoDAO();
				ErrorMessageDAO errorMessageDAO = new ErrorMessageDAO();
				if (responseObject != null
						&& responseObject.getSisMsg() != null
						&& responseObject.getSisMsg().getBcMasg() != null
						&& responseObject.getSisMsg().getBcMasg()
								.getConsultaTransacaoResponse() != null) {

					ConsultaTransacaoResponse consultaTransacaoResponse = responseObject
							.getSisMsg().getBcMasg()
							.getConsultaTransacaoResponse();

					for (LoteTransacao loteTransacao : consultaTransacaoResponse
							.getLoteTransacao()) {

						dao.saveLoteTransacao(loteTransacao);
					}
				} else if ((responseObject != null
						&& responseObject.getSisMsg() != null
						&& responseObject.getSisMsg().getBcMasg() != null 
						&& responseObject.getSisMsg().getBcMasg().getErrorMessage() != null)
						|| (responseObject != null
								&& responseObject.getSisMsg() != null && responseObject
								.getSisMsg().getErrorMessage() != null)) {

					ErrorMessage errorMessage = responseObject.getSisMsg().getErrorMessage() != null 
					? responseObject.getSisMsg().getErrorMessage() 
					: responseObject.getSisMsg().getBcMasg().getErrorMessage();

					errorMessageDAO.saveErrorMessage("ConsultaTransacao",
							errorMessage);
					BexBancoLogger
							.loggerInfo("["
									+ idLogger
									+ "] BMF retornou um erro, porfavor verificar errorMessage");
				}

			}

		} catch (Exception e) {
			BexBancoLogger.loggerError("[" + idLogger
					+ "]Ocorreu algum erro na consulta de transacao :"
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
				xmlResult = WebServiceUtils.send(UrlKeys.XML.getDesc(),
						xmlSigned);

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
