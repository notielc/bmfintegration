package br.com.bexsbanco.converters.consulta.lote.xml;

import br.com.bexsbanco.converters.consulta.lote.ConsultaLoteConverter;
import br.com.bexsbanco.converters.consulta.lote.ConsultaLoteResponseConverter;
import br.com.bexsbanco.pojos.BcMsgPojo;
import br.com.bexsbanco.pojos.DocPojo;
import br.com.bexsbanco.pojos.SisMsgPojo;
import br.com.bexsbanco.pojos.UserInfoPojo;
import br.com.bexsbanco.pojos.consulta.ConsultaSisMsg;
import br.com.bexsbanco.pojos.consulta.lote.CodIdent;
import br.com.bexsbanco.pojos.consulta.lote.Erro;
import br.com.bexsbanco.pojos.consulta.lote.LoteTransacao;
import br.com.bexsbanco.pojos.consulta.transacao.ConsultaTransacaoResponse;
import br.com.bexsbanco.pojos.consulta.transacao.ConsultaTransacaoRequest;
import br.com.bexsbanco.pojos.consulta.transacao.Transacao;
import br.com.bexsbanco.util.PropertiesUtil;

import com.thoughtworks.xstream.XStream;

public class ConsultaTransacaoXmlConverter{

	public static String toXML(String transacaoId, Transacao transacao) throws Exception {

		String returnXml = "";
		try {
			UserInfoPojo userInfo = criarUserInfo();

			ConsultaTransacaoRequest consultaTransacao = new ConsultaTransacaoRequest();
			// TODO: Onde será alimentado esse valor
			consultaTransacao.setTransacao(transacao);
			// TODO: Onde será alimentado esse valor
			consultaTransacao.setId(transacaoId);

			ConsultaSisMsg sismsg = new ConsultaSisMsg();
			sismsg.setConsultaTransacaoRequest(consultaTransacao);

			DocPojo requestObject = new DocPojo();
			requestObject.setSisMsg(sismsg);
			requestObject.getBcMasg().setUserInfo(userInfo);

			XStream xstream = new XStream();
			xstream.processAnnotations(new Class[] { DocPojo.class,
					BcMsgPojo.class, UserInfoPojo.class,
					ConsultaTransacaoRequest.class, ConsultaSisMsg.class, Transacao.class });
			xstream.registerConverter(new ConsultaLoteConverter());

			returnXml = xstream.toXML(requestObject);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return returnXml;
	}

	private static UserInfoPojo criarUserInfo() {
		UserInfoPojo userInfo = new UserInfoPojo();
		userInfo.setUserId(PropertiesUtil.getValor("bexsbanco_user"));
		userInfo.setPassowrd(PropertiesUtil.getValor("bexsbanco_password"));
		return userInfo;
	}

	public static DocPojo fromXML(String xml) throws Exception {
		DocPojo fromXML = new DocPojo();

		try {
			XStream xstream = new XStream();
			xstream.processAnnotations(new Class[] { DocPojo.class,
					BcMsgPojo.class, UserInfoPojo.class,
					ConsultaTransacaoResponse.class, LoteTransacao.class,
					Transacao.class, CodIdent.class, Erro.class,
					ConsultaSisMsg.class, SisMsgPojo.class });
			xstream.registerConverter(new ConsultaLoteResponseConverter());

			fromXML = (DocPojo) xstream.fromXML(xml);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return fromXML;
	}
}
