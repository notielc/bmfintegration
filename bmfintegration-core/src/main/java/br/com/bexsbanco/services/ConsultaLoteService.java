package br.com.bexsbanco.services;

import br.com.bexsbanco.converters.consulta.lote.xml.ConsultaLoteXmlConverter;
import br.com.bexsbanco.dao.ErrorMessageDAO;
import br.com.bexsbanco.dao.LoteTransacaoDAO;
import br.com.bexsbanco.enums.UrlKeys;
import br.com.bexsbanco.logs.BexBancoLogger;
import br.com.bexsbanco.pojos.DocPojo;
import br.com.bexsbanco.pojos.consulta.ConsultaSisMsg;
import br.com.bexsbanco.pojos.consulta.lote.ConsultaLoteResponse;
import br.com.bexsbanco.pojos.consulta.lote.LoteTransacao;
import br.com.bexsbanco.util.DllUtils;
import br.com.bexsbanco.util.NumberUtils;
import br.com.bexsbanco.util.PropertiesUtil;
import br.com.bexsbanco.util.WebServiceUtils;

public class ConsultaLoteService {

	public boolean consultaLote() {

		Integer idLogger = NumberUtils.randomId();
		
		try {

			String xml = ConsultaLoteXmlConverter.toXML(PropertiesUtil
					.getValor("bexsbanco_consulta_lote_req_transacao"),
					NumberUtils.randomId().toString());

			String xmlSigned = DllUtils.assinaBmf("BBMFReqSitLoteTransacao",
					xml, idLogger);
			
			BexBancoLogger.loggerInfo("["+idLogger+"]XML para envio sem security:"+xml);
			
			String assinaBmf = DllUtils.assinaBmf("BBMFReqSitLoteTransacao", xml, idLogger);
			
			BexBancoLogger.loggerInfo("["+idLogger+"]XML para envio com security:"+assinaBmf);

			if (xmlSigned != null) {

				String response = WebServiceUtils.send(
						new String[] { UrlKeys.XML.getDesc() },
						new String[] { xml });
				
				BexBancoLogger.loggerInfo("["+idLogger+"]XML de resposta:"+response);

				DocPojo responseObject = ConsultaLoteXmlConverter
						.fromXML(response);

				LoteTransacaoDAO dao = new LoteTransacaoDAO();
				ErrorMessageDAO errorMessageDAO = new ErrorMessageDAO();
				if (responseObject != null) {
					ConsultaSisMsg consultaLoteResponse = (ConsultaSisMsg) responseObject
							.getSisMsg();
					if (consultaLoteResponse != null
							&& consultaLoteResponse
									.getConsultaLoteReqResponse() != null) {
						for (LoteTransacao loteTransacao : consultaLoteResponse
								.getConsultaLoteReqResponse()
								.getLoteTransacao()) {

							dao.saveLoteTransacao(loteTransacao);
						}
					} else if (consultaLoteResponse != null
							&& consultaLoteResponse
									.getConsultaLoteReqErrorMessage() != null) {

						errorMessageDAO.saveErrorMessage("ConsultaLote",
								consultaLoteResponse
										.getConsultaLoteReqErrorMessage());
					}
				}

			}
		} catch (Exception e) {
			BexBancoLogger.loggerError("["+idLogger+"]Ocorreu algum erro na consulta de extrato :"+e.getMessage());
			return false;
		}
		return true;

	}
}
