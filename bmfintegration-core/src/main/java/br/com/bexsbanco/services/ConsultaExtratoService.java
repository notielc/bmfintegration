package br.com.bexsbanco.services;

import br.com.bexsbanco.converters.consulta.lote.xml.ConsultaExtratoXmlConverter;
import br.com.bexsbanco.dao.ErrorMessageDAO;
import br.com.bexsbanco.dao.ExtratoTransacaoDAO;
import br.com.bexsbanco.enums.UrlKeys;
import br.com.bexsbanco.logs.BexBancoLogger;
import br.com.bexsbanco.pojos.DocPojo;
import br.com.bexsbanco.pojos.consulta.ConsultaSisMsg;
import br.com.bexsbanco.pojos.consulta.extrato.Movimento;
import br.com.bexsbanco.util.DllUtils;
import br.com.bexsbanco.util.NumberUtils;
import br.com.bexsbanco.util.PropertiesUtil;
import br.com.bexsbanco.util.WebServiceUtils;

public class ConsultaExtratoService {

	public boolean consultaExtrato() {

		Integer idLogger = NumberUtils.randomId();
		
		try {

			Movimento movimento = new Movimento();
			movimento.setAgencia(PropertiesUtil
					.getValor("bexsbanco_consulta_extrato_agencia"));
			movimento.setConta(PropertiesUtil
					.getValor("bexsbanco_consulta_extrato_conta"));
			movimento.setTipo(PropertiesUtil
					.getValor("bexsbanco_consulta_extrato_tipo"));
			movimento.setDtLancamento(PropertiesUtil
					.getValor("bexsbanco_consulta_extrato_data_lancamento"));
			movimento.setNumMotivo(PropertiesUtil
					.getValor("bexsbanco_consulta_extrato_movimento"));

			String xml = ConsultaExtratoXmlConverter.toXML(NumberUtils
					.randomId().toString(), movimento);
			
						
			BexBancoLogger.loggerInfo("["+idLogger+"]XML para envio sem security:"+xml);

			String assinaBmf = DllUtils.assinaBmf("BBMFConsMovtoConta", xml, idLogger);
			
			BexBancoLogger.loggerInfo("["+idLogger+"]XML para envio com security:"+assinaBmf);

			if (assinaBmf != null) {
				String response = WebServiceUtils.send(
						new String[] { UrlKeys.XML.getDesc() },
						new String[] { xml });
				
				BexBancoLogger.loggerInfo("["+idLogger+"]XML de resposta:"+response);

				DocPojo responseObject = ConsultaExtratoXmlConverter
						.fromXML(response);

				ExtratoTransacaoDAO dao = new ExtratoTransacaoDAO();
				ErrorMessageDAO errorMessageDAO = new ErrorMessageDAO();
				if (responseObject != null) {
					ConsultaSisMsg consultaSisMsg = (ConsultaSisMsg) responseObject
							.getSisMsg();
					if (consultaSisMsg != null
							&& consultaSisMsg.getConsultaExtratoResponse() != null) {

						dao.saveLoteTransacao(consultaSisMsg
								.getConsultaExtratoResponse().getContabmf(),
								consultaSisMsg.getConsultaExtratoResponse()
										.getMovimento());
					} else if (consultaSisMsg != null
							&& consultaSisMsg.getConsultaLoteReqErrorMessage() != null) {

						errorMessageDAO
								.saveErrorMessage(
										"ConsultaExtrato",
										consultaSisMsg
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
