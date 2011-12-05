package br.com.bexsbanco.xml.converters;

import junit.framework.Assert;

import org.junit.Test;

import br.com.bexsbanco.converters.consulta.lote.xml.ConsultaExtratoXmlConverter;
import br.com.bexsbanco.pojos.DocPojo;
import br.com.bexsbanco.pojos.consulta.extrato.Movimento;

public class XmlConsultaExtratoTest {

	@Test
	public void testConsultaRequest() {
		try {
			
			Movimento movimento = new Movimento();
			movimento.setAgencia("agencia");
			movimento.setConta("conta");
			movimento.setTipo("tipo");
			movimento.setNumMotivo("numMotivo");
			
			String consultaExtratoToXML = ConsultaExtratoXmlConverter
					.toXML("123", movimento);
			System.out.println(consultaExtratoToXML);
			Assert.assertNotNull(consultaExtratoToXML);

		} catch (Exception e) {
			Assert.assertEquals(true, false);
		}
	}

	@Test
	public void testConsultaResponseNoErrors() {
		try {
				
			String  response = "<BMFDOC>"+
				"<BMFBCMSG>"+
					"<BBMResConsMovtoConta>"+
						"<contabmf banco=\"096\" agencia=\"0001\" conta=\"0000001815\" dtSaldoAnt=\"03/08/2005 00:00:00\" dtSaldoAtual=\"03/08/2005 00:00:00\" vlrSaldo=\"4364517.22\" />"+
						"<Movto>     "+ 
							"<DtLanc>20050803</DtLanc>"+      
							"<NumMovto>900000248</NumMovto>     "+ 
							"<NumDocto>0001025</NumDocto>      "+
							"<CodHist>00103</CodHist>      "+
							"<DescHist>TRANSF A DEB MESMA TITUL</DescHist>"+      
							"<VlrLanc>1500.00</VlrLanc>      "+
							"<TpDeb_Cred>D</TpDeb_Cred>      "+
							"<BcoCtp>096</BcoCtp>      "+
							"<AgeCtp>0001</AgeCtp>      "+
							"<CtaCtp>0000001025</CtaCtp>  "+    
							"<TipoCtaCtp>CC</TipoCtaCtp>    "+
							"<CnpjCpfCtpTitular1>00336036000140</CnpjCpfCtpTitular1>  "+
							"<NomeCtpTitular1>COINVALORES CCVM LTDA</NomeCtpTitular1> " +
							"<TpPessoaCtp>J</TpPessoaCtp>      "+
							"<CodIdent>1884</CodIdent>    "+
						"</Movto>  "+
					"</BBMResConsMovtoConta>"+
				"</BMFBCMSG>"+
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
			String response = "<BMFDOC>" + "	<BMFSISMSG>" + "		<ErrorMessage>"
					+ "<BBMFSecurity>ASD6545ASDA6545AS7</BBMFSecurity>"
					+ "<NameReq>123</NameReq>"
					+ " <Date>Data Formato String</Date>"
					+ "<ErrorID>234</ErrorID>" + "		</ErrorMessage>"
					+ "	</BMFSISMSG>" + "</BMFDOC>";

			DocPojo fromXML = ConsultaExtratoXmlConverter.fromXML(response);

			Assert.assertNotNull(fromXML);
		} catch (Exception e) {
			Assert.assertEquals(true, false);
		}

	}
}
