package br.com.bexsbanco.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimuladorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String xml = (String) request.getParameter("XML");

		System.out.println("POST " + xml);

		PrintWriter writer = response.getWriter();

		if(xml.indexOf("BBMFReqTransacaoSit ") > 0){
			writer.print("<BMFDOC>" 
					+ "<BMFSISMSG>" 
					+ "<BBMFResSitTransacao>"
					+ "<BBMFSecurity>ASDAD4654DD4A6D4A6S4DA</BBMFSecurity>"
					+ "<LoteTransacao ID='456'>		" 
					+ "<BBMFTransacao>"
					+ "		<CodIdent Situacao=\"F\">1234</CodIdent>" 
					+ "			<Erro>"
					+ "				<CodErro>20</CodErro>" 
					+ "			</Erro>" 
					+ "			<Erro>"
					+ "				<CodErro>25</CodErro>" 
					+ "			</Erro>"
					+ "	</BBMFTransacao>" 
					+ "<BBMFTransacao>"
					+ "		<CodIdent Situacao=\"V\">1235</CodIdent>"
					+ "	</BBMFTransacao>" 
					+ "<BBMFTransacao>"
					+ "		<CodIdent Situacao=\"I\">1236</CodIdent>"
					+ "	</BBMFTransacao>" 
					+ "	</LoteTransacao>"
					+ "	</BBMFResSitTransacao>" 
					+ "	</BMFSISMSG>" + "</BMFDOC>");
		} else {
			writer.print("<BMFDOC>"
					+"<BMFBCMSG>"
					+"<BBMResConsMovtoConta>"
					+"<contabmf banco=\"096\" agencia=\"0001\" conta=\"0000001815\" dtSaldoAnt=\"03/08/2005 00:00:00\" dtSaldoAtual=\"03/08/2005 00:00:00\" vlrSaldo=\"4364517.22\" />"
					+"<Movto>      "
					+"<DtLanc>20050803</DtLanc>"      
					+"<NumMovto>900000248</NumMovto>"      
					+"<NumDocto>0001025</NumDocto>   "   
					+"<CodHist>00103</CodHist>      "
					+"<DescHist>TRANSF A DEB MESMA TITUL</DescHist>"      
					+"<VlrLanc>1500.00</VlrLanc>      "
					+"<TpDeb_Cred>D</TpDeb_Cred>      "
					+"<BcoCtp>096</BcoCtp>     " 
					+"<AgeCtp>0001</AgeCtp>     " 
					+"<CtaCtp>0000001025</CtaCtp>"      
					+"<TipoCtaCtp>CC</TipoCtaCtp> "
					+"<CnpjCpfCtpTitular1>00336036000140</CnpjCpfCtpTitular1> "
					+"<NomeCtpTitular1>COINVALORES CCVM LTDA</NomeCtpTitular1> "
					+"<TpPessoaCtp>J</TpPessoaCtp>      "
					+"<CodIdent>1884</CodIdent>    "
					+"</Movto>  "
					+"</BBMResConsMovtoConta>"
					+"</BMFBCMSG>"
					+"</BMFDOC>");
		}
	}
}
