package fr.cpe.ha.jbbflight.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This controller handles the application navigation.
 * 
 * @author Benjamin Chastanier
 *
 */
public class ApplicationController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		String action = req.getParameter("action");
		
		if("dashboard".equals(action))
			this.dashboardView(req, resp);
	}

	/**
	 * This function allow to display the dashboard view.
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void dashboardView(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/dashboard.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
