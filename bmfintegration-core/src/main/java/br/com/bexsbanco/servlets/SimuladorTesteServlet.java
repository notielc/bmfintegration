package br.com.bexsbanco.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bexsbanco.pojos.consulta.extrato.Movimento;
import br.com.bexsbanco.pojos.consulta.lote.CodIdent;
import br.com.bexsbanco.pojos.consulta.transacao.Transacao;
import br.com.bexsbanco.services.ConsultaExtratoService;
import br.com.bexsbanco.services.ConsultaTransacaoService;

public class SimuladorTesteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String tipoConsulta = req.getParameter("tipo_consulta");

		if (tipoConsulta.equalsIgnoreCase("extrato")) {
			Movimento movimento = new Movimento();
			movimento.setAgencia(req.getParameter("agencia_extrato"));
			movimento.setConta(req.getParameter("conta_extrato"));
			movimento.setTipo(req.getParameter("tipo_conta_extrato"));
			movimento.setDtLancamento(req.getParameter("data_extrato"));
			movimento.setNumMotivo(req.getParameter("numero_extrato"));
			
			ConsultaExtratoService consultaExtratoService = new ConsultaExtratoService();
			
			String bmfResult = consultaExtratoService.consultaExtratoSimulador(movimento);
			
			PrintWriter printWriter = resp.getWriter();
			printWriter.print(bmfResult);
			
		} else {

			Transacao transacao = new Transacao();
			transacao.setAgencia(req.getParameter("agencia_transacao"));
			transacao.setConta(req.getParameter("conta_transacao"));			
			transacao.setMovimento(req.getParameter("data_transacao"));
			transacao.setTipo(req.getParameter("tipo_conta_transacao"));
			
			CodIdent codIdent = new CodIdent();
			codIdent.setValue(req.getParameter("codident_transacao"));
			transacao.setCodIdent(codIdent);
			
			ConsultaTransacaoService consultaTransacaoService = new ConsultaTransacaoService();
			String bmfResult = consultaTransacaoService.consultaTransacao(transacao);
			
			PrintWriter printWriter = resp.getWriter();
			printWriter.print(bmfResult);
		}

	}
}
