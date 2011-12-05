package br.com.bexsbanco.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimuladorServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

String xml = (String)request.getParameter("XML");
		
		System.out.println("POST "+xml);
		
		PrintWriter writer = response.getWriter();
		
		writer.print("<BMFDOC>"+
		"	<BMFSISMSG>"+
		"	<BBMFResSitTransacao>"+
		"<BBMFSecurity>ASDAD4654DD4A6D4A6S4DA</BBMFSecurity>"+
		"<LoteTransacao ID='456'>		"+
		"<BBMFTransacao>"+
		"		<CodIdent Situacao=\"F\">1234</CodIdent>"+
		"			<Erro>"+
		"				<CodErro>20</CodErro>"+
		"			</Erro>"+
		"			<Erro>"+
		"				<CodErro>25</CodErro>"+
		"			</Erro>"+
		"		</BBMFTransacao>"+
		"<BBMFTransacao>"+
		"		<CodIdent Situacao=\"V\">1235</CodIdent>"+
		"		</BBMFTransacao>"+
		"<BBMFTransacao>"+
		"		<CodIdent Situacao=\"I\">1236</CodIdent>"+
		"		</BBMFTransacao>"+
		"	</LoteTransacao>"+
		"	</BBMFResSitTransacao>"+
		"	</BMFSISMSG>"+
		"</BMFDOC>");

		
		
	}
}
