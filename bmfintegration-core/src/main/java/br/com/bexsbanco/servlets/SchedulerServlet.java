package br.com.bexsbanco.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bexsbanco.scheduler.BmfScheduler;

public class SchedulerServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(!BmfScheduler.status) {
			BmfScheduler.startScheduler();
		} else {
			BmfScheduler.shutdownScheduler();
		}
		
		resp.sendRedirect("index.jsp");
	}
}
