package br.com.bexsbanco.xml.converters;

import junit.framework.Assert;

import org.junit.Test;

import br.com.bexsbanco.converters.consulta.lote.xml.ConsultaLoteXmlConverter;
import br.com.bexsbanco.pojos.DocPojo;

public class XmlConsultaLoteTest {

	@Test
	public void testConsultaRequest() {
		try {
			String consultaLoteToXML = ConsultaLoteXmlConverter.toXML("123",
					"0000001");

			Assert.assertNotNull(consultaLoteToXML);

		} catch (Exception e) {
			Assert.assertEquals(true, false);
		}
	}

	@Test
	public void testConsultaResponseNoErrors() {

		try {
			String response = "<BMFDOC>" + "	<BMFSISMSG>"
					+ "		<BBMFResSitTransacao>"
					+ "			<BBMFSecurity>ASDAD4654DD4A6D4A6S4DA</BBMFSecurity>"
					+ "			<LoteTransacao ID='456'>" 
					+ "				<BBMFTransacao>"
					+ "					<CodIdent Situacao=\"F\">1234</CodIdent>"
					+ "					<Erro>" 
					+ "						<CodErro>20</CodErro>"
					+ "					</Erro>" 
					+ "					<Erro>"
					+ "						<CodErro>25</CodErro>" 
					+ "					</Erro>"
					+ "				</BBMFTransacao>" 
					+ "				<BBMFTransacao>"
					+ "					<CodIdent Situacao=\"V\">1235</CodIdent>"
					+ "				</BBMFTransacao>" 
					+ "				<BBMFTransacao>"
					+ "					<CodIdent Situacao=\"I\">1236</CodIdent>"
					+ "				</BBMFTransacao>" 
					+ "			</LoteTransacao>"
					+ "		</BBMFResSitTransacao>" 
					+ "	</BMFSISMSG>"
					+ "</BMFDOC>";

			DocPojo fromXML = ConsultaLoteXmlConverter.fromXML(response);

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

			DocPojo fromXML = ConsultaLoteXmlConverter.fromXML(response);

			Assert.assertNotNull(fromXML);

		} catch (Exception e) {
			Assert.assertEquals(true, false);
		}

	}
}
