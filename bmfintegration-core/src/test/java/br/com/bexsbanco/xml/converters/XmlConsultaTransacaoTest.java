package br.com.bexsbanco.xml.converters;

import junit.framework.Assert;

import org.junit.Test;

import br.com.bexsbanco.converters.consulta.lote.xml.ConsultaLoteXmlConverter;
import br.com.bexsbanco.converters.consulta.lote.xml.ConsultaTransacaoXmlConverter;
import br.com.bexsbanco.pojos.DocPojo;
import br.com.bexsbanco.pojos.consulta.lote.CodIdent;
import br.com.bexsbanco.pojos.consulta.transacao.Transacao;
import br.com.bexsbanco.util.DllUtils;
import br.com.bexsbanco.util.PropertiesUtil;

public class XmlConsultaTransacaoTest {

	@Test
	public void testConsultaRequest() {
		try {
			Transacao transacao = new Transacao();
			transacao.setAgencia("0001");
			transacao.setConta("0000012663");
			CodIdent codIdent = new CodIdent();
			codIdent.setValue("12");
			transacao.setCodIdent(codIdent);
			transacao.setMovimento("20111215");
			transacao.setTipo("CC");

			String consultaTransacaoToXML = ConsultaTransacaoXmlConverter
					.toXML("000000000000001", transacao);
			
			String assinaBmf = DllUtils.assinaBmf("BBMFReqTransacaoSit", consultaTransacaoToXML, 123);
			
			Assert.assertNotNull(consultaTransacaoToXML);

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
					+ "			<LoteTransacao ID='456'>" + "		<BBMFTransacao>"
					+ "			<CodIdent Situacao=\"F\">1234</CodIdent>"
					+ "				<Erro>" + "					<CodErro>20</CodErro>"
					+ "				</Erro>" + "				<Erro>"
					+ "					<CodErro>25</CodErro>" + "				</Erro>"
					+ "			</BBMFTransacao>" + "	<BBMFTransacao>"
					+ "			<CodIdent Situacao=\"V\">1235</CodIdent>"
					+ "	</BBMFTransacao>" + "	<BBMFTransacao>"
					+ "			<CodIdent Situacao=\"I\">1236</CodIdent>"
					+ "	</BBMFTransacao>" + "			</LoteTransacao>"
					+ "		</BBMFResSitTransacao>" + "	</BMFSISMSG>"
					+ "</BMFDOC>";

			DocPojo fromXML = ConsultaTransacaoXmlConverter.fromXML(response);

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
