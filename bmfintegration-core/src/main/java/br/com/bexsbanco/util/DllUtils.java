package br.com.bexsbanco.util;

import br.com.bexsbanco.dll.BmfDll;
import br.com.bexsbanco.logs.BexBancoLogger;

import com.sun.jna.Native;

public class DllUtils {

	public static void main(String[] args) {
		String xml = "<BMFDOC>"+
					"<BMFBCMSG>"+
					"	      <UserInfo>"+
					"             <UserID>"+
					"             <Password>"+
					"        </UserInfo>	"+
					"  </BMFBCMSG>"+
					"<BMFSISMSG>"+
					"<BBMFReqTransacaoSit id=\"000000000000001\">"+
					"<BBMFSecurity>"+
					"<BBMFTransacao>"+
					"<AgDebtd></AgDebtd>	"+
					"<CtDebtd></CtDebtd>	"+
					"<TpCtDebtd></TpCtDebtd>"+
					"<CodIdent></CodIdent>	"+
					"<DtMovto></DtMovto>"+
					"</BBMFTransacao>"+		
					"</BBMFReqTransacaoSit>"+
					"</BMFSISMSG>"+
					"</BMFDOC>";
		Integer loggerId = NumberUtils.randomId();
		
		String teste = assinaBmf("BBMFReqTransacaoSit", xml, loggerId);
		
		System.out.println(teste);
	}
	
	public static String assinaBmf(String tag, String xmlSign, Integer loggerId) {
		Native.setProtected(true);

		BmfDll lib = (BmfDll) Native.loadLibrary("BBMFSecurity", BmfDll.class);

		String header = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>";
		
		String xmlSignFinal = xmlSign;//header.concat(xmlSign);
		
		byte[] outXML = new byte[xmlSignFinal.length() + 90];

		Integer bbmfSignExResult = lib.BBMFSign(xmlSignFinal, tag,
				outXML);
		
		String xmlSigned = null;

		switch (bbmfSignExResult) {
		case -1:
			BexBancoLogger.loggerError("["+loggerId+"]Sign: Parâmetro de saída não alocado!");
			break;
		case -2:
			BexBancoLogger.loggerError("["+loggerId+"]Sign: Parâmetro de saída com tamanho insuficiente");
			break;
		case -3:
			BexBancoLogger.loggerError("["+loggerId+"]Sign: Não foi possível encontrar as tags BM&F/ReqExterna");
			break;
		case -5:
			BexBancoLogger.loggerError("["+loggerId+"]Sign: Tag não pode ser vazia");
			break;
		case -10:
			BexBancoLogger.loggerError("["+loggerId+"]Sign: Tamanho insuficiente de entrada (25 caracteres)");
			break;
		case -11:
			BexBancoLogger.loggerError("["+loggerId+"]Sign: Mensagem dentro de BMFSISMSG vazia");
			break;
		case -12:
			BexBancoLogger.loggerError("["+loggerId+"]Sign: Mensagem dentro de BMFSISMSG muito longa");
			break;
		case -13:
			BexBancoLogger.loggerError("["+loggerId+"]Sign: Erro em algoritmo de hash!");
			break;
		default:
			xmlSigned = new String(outXML);
			break;
		}

	
		Integer returnCode = lib.BBMFVerify(xmlSigned, tag);

		boolean xmlVerified = false;
		switch (returnCode) {
		case 1:
			BexBancoLogger.loggerInfo("["+loggerId+"]Verify:Assinatura correta");
			xmlVerified = true;
			break;
		case 0:
			BexBancoLogger.loggerError("["+loggerId+"]Verify:Assinatura não confere!");
			break;
		case -1:
			BexBancoLogger.loggerError("["+loggerId+"]Verify:Parâmetro de saída não alocado!");
			break;
		case -3:
			BexBancoLogger.loggerError("["+loggerId+"]Verify:Não foi possível encontrar as TAGs BM&F/ReqExterna");
			break;
		case -4:
			BexBancoLogger.loggerError("["+loggerId+"]Verify:Não foi encontrado o hash da mensagem");
			break;
		case -5:
			BexBancoLogger.loggerError("["+loggerId+"]Verify:Tag não pode ser vazia");
			break;
		case -10:
			BexBancoLogger.loggerError("["+loggerId+"]Verify:Tamanho insuficiente do XML (110 caracteres)");
			break;
		case -11:
			BexBancoLogger.loggerError("["+loggerId+"]Verify:Mensagem dentro de BMFSISMSG vazia");
			break;
		case -12:
			BexBancoLogger.loggerError("["+loggerId+"]Verify:Mensagem dentro de BMFSISMSG muito longa");
			break;
		case -13:
			BexBancoLogger.loggerError("["+loggerId+"]Verify:Erro em algoritmo de hash!");
			break;
		default:
			BexBancoLogger.loggerError("["+loggerId+"]Verify:Erro desconhecido!");
			break;
		}
		
		if(!xmlVerified){
			xmlSigned = null;
		}
		
		System.out.println("Resposta de XML Assinado:"+xmlSigned);
		
		return xmlSigned;

	}
}
