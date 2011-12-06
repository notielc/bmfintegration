package br.com.bexsbanco.converters.consulta.lote.xml;

import br.com.bexsbanco.converters.consulta.lote.ConsultaLoteConverter;
import br.com.bexsbanco.converters.consulta.lote.ConsultaLoteResponseConverter;
import br.com.bexsbanco.pojos.BcMsgPojo;
import br.com.bexsbanco.pojos.DocPojo;
import br.com.bexsbanco.pojos.SisMsgPojo;
import br.com.bexsbanco.pojos.UserInfoPojo;
import br.com.bexsbanco.pojos.consulta.ConsultaSisMsg;
import br.com.bexsbanco.pojos.consulta.extrato.ConsultaExtratoRequest;
import br.com.bexsbanco.pojos.consulta.extrato.ConsultaExtratoResponse;
import br.com.bexsbanco.pojos.consulta.extrato.ContaBmf;
import br.com.bexsbanco.pojos.consulta.extrato.Movimento;
import br.com.bexsbanco.pojos.consulta.lote.CodIdent;
import br.com.bexsbanco.pojos.consulta.lote.Erro;
import br.com.bexsbanco.util.PropertiesUtil;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;

public class ConsultaExtratoXmlConverter{
	
	public static String toXML(String transacaoId, Movimento movimento) throws Exception {

		String returnXml = "";
		try {
			UserInfoPojo userInfo = criarUserInfo();

			ConsultaExtratoRequest consultaExtrato = new ConsultaExtratoRequest();
			consultaExtrato.setId(transacaoId);
			consultaExtrato.setMovimento(movimento);
		
			ConsultaSisMsg sismsg = new ConsultaSisMsg();
			sismsg.setConsultaExtratoRequest(consultaExtrato);

			DocPojo requestObject = new DocPojo();
			requestObject.setSisMsg(sismsg);
			requestObject.getBcMasg().setUserInfo(userInfo);

			XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyReplacer("__", "_")));  
			xstream.processAnnotations(new Class[] { DocPojo.class,
					BcMsgPojo.class, UserInfoPojo.class,
					ConsultaExtratoRequest.class, ConsultaSisMsg.class,
					Movimento.class, ContaBmf.class });
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
			XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyReplacer("__", "_")));  
			xstream.processAnnotations(new Class[] { DocPojo.class,
					BcMsgPojo.class, UserInfoPojo.class,
					ConsultaExtratoResponse.class, Movimento.class, 
					CodIdent.class, Erro.class,
					ConsultaSisMsg.class, SisMsgPojo.class,
					ContaBmf.class});
			xstream.registerConverter(new ConsultaLoteResponseConverter());

			fromXML = (DocPojo) xstream.fromXML(xml);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return fromXML;
	}
}
