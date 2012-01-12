package br.com.bexsbanco.xml.converters;

import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import br.com.bexsbanco.converters.consulta.lote.xml.ConsultaExtratoXmlConverter;
import br.com.bexsbanco.pojos.DocPojo;
import br.com.bexsbanco.pojos.consulta.extrato.Movimento;
import br.com.bexsbanco.util.DllUtils;

public class XmlConsultaExtratoTest {

	@Test
	public void testConsultaRequest() {
		try {
			
			Movimento movimento = new Movimento();
			movimento.setAgencia("0001");
			movimento.setConta("0000012663");
			movimento.setTipo("CC");
			movimento.setNumMotivo("0");
			movimento.setDtLancamento("20111216");//new SimpleDateFormat("yyyyMMdd").format(new Date()));
			
			String consultaExtratoToXML = ConsultaExtratoXmlConverter
					.toXML("000000000000001", movimento);
			
			System.out.println("Trim:"+consultaExtratoToXML.trim());
			
			//String teste = "<BMFDOC><BMFBCMSG><UserInfo><UserID>MDORES</UserID><Password>208CABEI</Password></UserInfo></BMFBCMSG><BMFSISMSG><BBMFConsMovtoConta id=\"000000000000001\"><Movto>   <AgeCtp>0001</AgeCtp>   <CtaCtp>0000012663</CtaCtp>  <TipoCtaCtp>CC</TipoCtaCtp>  <DtLanc>20111216</DtLanc>   <NumMovto>0</NumMovto></Movto></BBMFConsMovtoConta></BMFSISMSG></BMFDOC>"	;		
			String assinaBmf = DllUtils.assinaBmf("BBMFConsMovtoConta", consultaExtratoToXML.trim(), 123);
			
			System.out.println(assinaBmf);
			Assert.assertNotNull(consultaExtratoToXML);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertEquals(true, false);
		}
	}

	@Test
	public void testConsultaResponseNoErrors() {
		try {
				
			String  response = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>"+
			"<BMFDOC>"+
			"<BMFSISMSG>"+
			"<BMFBCMSG>"+
			"<BBMResConsMovtoConta>"+
			"<BBMFSecurity>FBC565A7CC7BF289C85994712FC0A181C91822F6EFD86927A2C416573175</BBMFSecurity> "+
			"<contabmf banco=\"096\" agencia=\"0001\" conta=\"0000012663\" dtSaldoAnt=\"16/12/2011 00:00:00\" dtSaldoAtual=\"16/12/2011 00:00:00\" vlrSaldo=\"100.00\" /> "+
			"<Movto>"+
			"<DtLanc>20111216</DtLanc> "+
			"<NumMovto>900001680</NumMovto> "+
			"<NumDocto>4999217</NumDocto> "+
			"<CodHist>00408</CodHist> "+
			"<DescHist>CREDITO TED - CC</DescHist> "+
			"<VlrLanc>77945.59</VlrLanc> "+
			"<TpDeb_Cred>C</TpDeb_Cred> "+
			"<BcoCtp>237</BcoCtp> "+
			"<AgeCtp>84</AgeCtp> "+
			"<CtaCtp>225444</CtaCtp> "+
			"<TipoCtaCtp>CC</TipoCtaCtp> "+
			"<CnpjCpfCtpTitular1>13565862000103</CnpjCpfCtpTitular1> "+
			"<NomeCtpTitular1>ASIA OPERADORA DE TURISMO</NomeCtpTitular1> "+
			"<TpPessoaCtp>J</TpPessoaCtp> "+
			"</Movto>"+
			"<Movto>"+
			"<DtLanc>20111216</DtLanc> "+
			"<NumMovto>900001681</NumMovto> "+
			"<NumDocto>4999789</NumDocto> "+
			"<CodHist>00408</CodHist> "+
			"<DescHist>CREDITO TED - CC</DescHist> "+
			"<VlrLanc>4123.12</VlrLanc> "+
			"<TpDeb_Cred>C</TpDeb_Cred> "+
			"<BcoCtp>399</BcoCtp> "+
			"<AgeCtp>409</AgeCtp> "+
			"<CtaCtp>4090073978</CtaCtp> "+
			"<TipoCtaCtp>CC</TipoCtaCtp> "+
			"<CnpjCpfCtpTitular1>12111030000154</CnpjCpfCtpTitular1> "+
			"<NomeCtpTitular1>F.A.W.S.P.E EMPREENDIMENT</NomeCtpTitular1> "+
			"<TpPessoaCtp>J</TpPessoaCtp> "+
			"</Movto>"+
			"<Movto>"+
			"<DtLanc>20111216</DtLanc> "+
			"<NumMovto>900001682</NumMovto> "+
			"<NumDocto>5000442</NumDocto> "+
			"<CodHist>00408</CodHist> "+
			"<DescHist>CREDITO TED - CC</DescHist> "+
			"<VlrLanc>97983.50</VlrLanc> "+
			"<TpDeb_Cred>C</TpDeb_Cred> "+
			"<BcoCtp>033</BcoCtp> "+
			"<AgeCtp>2136</AgeCtp> "+
			"<CtaCtp>10061235</CtaCtp> "+
			"<TipoCtaCtp>CC</TipoCtaCtp> "+
			"<CnpjCpfCtpTitular1>399590315</CnpjCpfCtpTitular1> "+
			"<NomeCtpTitular1>JORGE ALBERTO VIEIRA STUD</NomeCtpTitular1> "+
			"</Movto>"+
			"<Movto>"+
			"<DtLanc>20111216</DtLanc> "+
			"<NumMovto>900001683</NumMovto> "+
			"<NumDocto>5000446</NumDocto> "+
			"<CodHist>00408</CodHist> "+
			"<DescHist>CREDITO TED - CC</DescHist> "+
			"<VlrLanc>160634.35</VlrLanc> "+
			"<TpDeb_Cred>C</TpDeb_Cred> "+
			"<BcoCtp>745</BcoCtp> "+
			"<AgeCtp>66</AgeCtp> "+
			"<CtaCtp>66008913</CtaCtp> "+
			"<TipoCtaCtp>CC</TipoCtaCtp> "+
			"<CnpjCpfCtpTitular1>4679722819</CnpjCpfCtpTitular1> "+
			"<NomeCtpTitular1>ERIC ACHER</NomeCtpTitular1> "+
			"<TpPessoaCtp>F</TpPessoaCtp> "+
			"</Movto>"+
			"<Movto>"+
			"<DtLanc>20111216</DtLanc> "+
			"<NumMovto>900001684</NumMovto> "+
			"<NumDocto>5000638</NumDocto> "+
			"<CodHist>00408</CodHist> "+
			"<DescHist>CREDITO TED - CC</DescHist> "+
			"<VlrLanc>247458.71</VlrLanc> "+
			"<TpDeb_Cred>C</TpDeb_Cred> "+
			"<BcoCtp>399</BcoCtp> "+
			"<AgeCtp>409</AgeCtp> "+
			"<CtaCtp>4090008793</CtaCtp> "+
			"<TipoCtaCtp>CC</TipoCtaCtp> "+
			"<CnpjCpfCtpTitular1>00030774691700</CnpjCpfCtpTitular1> "+
			"<NomeCtpTitular1>MARC PAUL FRANS VAN RIEL</NomeCtpTitular1> "+
			"<TpPessoaCtp>F</TpPessoaCtp> "+
			"</Movto>"+
			"<Movto>"+
			"<DtLanc>20111216</DtLanc> "+
			"<NumMovto>900001685</NumMovto> "+
			"<NumDocto>5001093</NumDocto> "+
			"<CodHist>00408</CodHist> "+
			"<DescHist>CREDITO TED - CC</DescHist> "+
			"<VlrLanc>340891.83</VlrLanc> "+
			"<TpDeb_Cred>C</TpDeb_Cred> "+
			"<BcoCtp>341</BcoCtp> "+
			"<AgeCtp>2999</AgeCtp> "+
			"<CtaCtp>52927</CtaCtp> "+
			"<TipoCtaCtp>CC</TipoCtaCtp> "+
			"<CnpjCpfCtpTitular1>5089637000110</CnpjCpfCtpTitular1> "+
			"<NomeCtpTitular1>GRAND CRU IMPORTADORA LTD</NomeCtpTitular1> "+
			"<TpPessoaCtp>J</TpPessoaCtp> "+
			"</Movto>"+
			"<Movto>"+
			"<DtLanc>20111216</DtLanc> "+
			"<NumMovto>900001686</NumMovto> "+
			"<NumDocto>5001207</NumDocto> "+
			"<CodHist>00408</CodHist> "+
			"<DescHist>CREDITO TED - CC</DescHist> "+
			"<VlrLanc>76066.29</VlrLanc> "+
			"<TpDeb_Cred>C</TpDeb_Cred> "+
			"<BcoCtp>237</BcoCtp> "+
			"<AgeCtp>450</AgeCtp> "+
			"<CtaCtp>1116606</CtaCtp> "+
			"<TipoCtaCtp>CC</TipoCtaCtp>"+ 
			"<CnpjCpfCtpTitular1>64529316000239</CnpjCpfCtpTitular1> "+
			"<NomeCtpTitular1>MULTILINK BIO TEC IMP E E</NomeCtpTitular1> "+
			"<TpPessoaCtp>J</TpPessoaCtp> "+
			"</Movto>"+
			"<Movto>"+
			"<DtLanc>20111216</DtLanc> "+
			"<NumMovto>900001687</NumMovto> "+
			"<NumDocto>5002262</NumDocto> "+
			"<CodHist>00408</CodHist> "+
			"<DescHist>CREDITO TED - CC</DescHist> "+
			"<VlrLanc>11052.92</VlrLanc> "+
			"<TpDeb_Cred>C</TpDeb_Cred> "+
			"<BcoCtp>341</BcoCtp> "+
			"<AgeCtp>8137</AgeCtp> "+
			"<CtaCtp>113893</CtaCtp> "+
			"<TipoCtaCtp>CC</TipoCtaCtp> "+
			"<CnpjCpfCtpTitular1>6439746871</CnpjCpfCtpTitular1> "+
			"<NomeCtpTitular1>SILAS PAVAN DE OLIVEIRA</NomeCtpTitular1> "+
			"<TpPessoaCtp>F</TpPessoaCtp> "+
			"</Movto>"+
			"<Movto>"+
			"<DtLanc>20111216</DtLanc> "+
			"<NumMovto>900001688</NumMovto> "+
			"<NumDocto>5002626</NumDocto> "+
			"<CodHist>00407</CodHist> "+
			"<DescHist>TRANSF STR MESMA TITULARIDADE</DescHist> "+
			"<VlrLanc>1016156.31</VlrLanc> "+
			"<TpDeb_Cred>D</TpDeb_Cred> "+
			"<BcoCtp>341</BcoCtp> "+
			"<AgeCtp>1248</AgeCtp> "+
			"<CtaCtp>0000000092247</CtaCtp> "+
			"<TipoCtaCtp>CC</TipoCtaCtp> "+
			"<CnpjCpfCtpTitular1>13059145000100</CnpjCpfCtpTitular1> "+
			"<NomeCtpTitular1>DIDIER LEVY BANCO DE CAMB</NomeCtpTitular1> "+
			"<TpPessoaCtp>J</TpPessoaCtp> "+
			"</Movto>"+
			"</BBMResConsMovtoConta>"+
			"</BMFBCMSG>"+
			"</BMFSISMSG>"+
			"</BMFDOC>";


			DocPojo fromXML = ConsultaExtratoXmlConverter.fromXML(response);

			Assert.assertNotNull(fromXML);

		} catch (Exception e) {
			Assert.assertEquals(true, false);
		}
	}

	@Test
	public void testConsultaResponseWithErrors() {
		try {
			String response = "<BMFDOC>" +
			"	<BMFSISMSG>" 
			+ "		<ErrorMessage>"
					+ "<NameReq>123</NameReq>"
					+ " <Date>Data Formato String</Date>"
					+ "<ErrorID>234</ErrorID>" 
					+ "		</ErrorMessage>"
					+ "	</BMFSISMSG>" 
					+ "</BMFDOC>";
			
			String response2 = " <BMFDOC>"
				+"<BMFBCMSG>" +
						"<ErrorMessage>" +
						"<Origem>INFRA</Origem>" +
						"<UserID>caiojr</UserID>" +
						"<IdReq>1559615406</IdReq>" +
						"<NameReq>BBMFConsMovtoConta</NameReq>" +
						"<Date>07/12/2011 19:07:44.780</Date>" +
						"<ErrorID>51232250</ErrorID>" +
						"<ErrorNumber>-70011</ErrorNumber>" +
						"<Description>LOGIN BLOQUEADO</Description>" +
						"</ErrorMessage>" +
						"</BMFBCMSG>" +
						"</BMFDOC>";
			
			String response3 = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>" +
					"<BMFDOC>" +
					"<BMFBCMSG>" +
					"<ErrorMessage>" +
					"<Origem>INFRA</Origem>" +
					"<UserID>MDORES</UserID>" +
					"<IdReq>000000000000001</IdReq>" +
					"<NameReq>BBMFConsMovtoConta</NameReq>" +
					"<Date>11/01/2012 23:58:29.270</Date>" +
					"<ErrorID>52598917</ErrorID>" +
					"<ErrorNumber>-70011</ErrorNumber>" +
					"<Description>LOGIN BLOQUEADO</Description>" +
					"</ErrorMessage>" +
					"</BMFBCMSG>" +
					"</BMFDOC>";

			DocPojo fromXML = ConsultaExtratoXmlConverter.fromXML(response);
			Assert.assertNotNull(fromXML);
			
			DocPojo fromXML2 = ConsultaExtratoXmlConverter.fromXML(response2);
			Assert.assertNotNull(fromXML2);
			
			DocPojo fromXML3 = ConsultaExtratoXmlConverter.fromXML(response3);
			Assert.assertNotNull(fromXML3);
			
		} catch (Exception e) {
			Assert.assertEquals(true, false);
		}

	}
}
