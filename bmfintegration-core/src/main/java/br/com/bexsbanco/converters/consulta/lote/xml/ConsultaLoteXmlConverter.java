package br.com.bexsbanco.converters.consulta.lote.xml;

import br.com.bexsbanco.converters.consulta.lote.ConsultaLoteResponseConverter;
import br.com.bexsbanco.pojos.BcMsgPojo;
import br.com.bexsbanco.pojos.DocPojo;
import br.com.bexsbanco.pojos.SisMsgPojo;
import br.com.bexsbanco.pojos.UserInfoPojo;
import br.com.bexsbanco.pojos.consulta.ErrorMessage;
import br.com.bexsbanco.pojos.consulta.lote.CodIdent;
import br.com.bexsbanco.pojos.consulta.lote.Erro;
import br.com.bexsbanco.pojos.consulta.lote.LoteTransacao;
import br.com.bexsbanco.pojos.consulta.transacao.Transacao;
import br.com.bexsbanco.util.PropertiesUtil;

import com.thoughtworks.xstream.XStream;

public class ConsultaLoteXmlConverter{

	public static String toXML(String idReqTransacao, String loteId) throws Exception {

		String returnXml = "";
		try {
			UserInfoPojo userInfo = criarUserInfo();

//			ConsultaLoteRequest consultaStatusLote = new ConsultaLoteRequest();
//			// TODO: Onde será alimentado esse valor
//			consultaStatusLote.setIdReqTransacao(idReqTransacao);
//			// TODO: Onde será alimentado esse valor
//			consultaStatusLote.setId(loteId);
//
//			ConsultaSisMsg sismsg = new ConsultaSisMsg();
//			sismsg.setConsultaStatusLoteRequest(consultaStatusLote);
//
//			DocPojo requestObject = new DocPojo();
//			requestObject.setSisMsg(sismsg);
//			requestObject.getBcMasg().setUserInfo(userInfo);
//
//			XStream xstream = new XStream();
//			xstream.processAnnotations(new Class[] { DocPojo.class,
//					BcMsgPojo.class, UserInfoPojo.class,
//					ConsultaLoteRequest.class, ConsultaSisMsg.class });
//			xstream.registerConverter(new ConsultaLoteConverter());
//
//			returnXml = xstream.toXML(requestObject);

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
					LoteTransacao.class, ErrorMessage.class,
					Transacao.class, CodIdent.class, Erro.class,
					SisMsgPojo.class });

			fromXML = (DocPojo) xstream.fromXML(xml);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return fromXML;
	}
}
