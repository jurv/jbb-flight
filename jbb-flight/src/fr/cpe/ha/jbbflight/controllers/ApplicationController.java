package fr.cpe.ha.jbbflight.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.cpe.ha.jbbflight.models.User;

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
		else if("setnewpwd".equals(action))
			this.newpwdView(req, resp);
			
	}

	/**
	 * This function allow to display the dashboard view.
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void dashboardView(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// Get the current user
		HttpSession session = req.getSession();
		
		String usr_id = (String)session.getAttribute(User.USER_ID);
		
		if(usr_id != null && !usr_id.isEmpty()) {
			// That's not the first connection
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/dashboard.jsp");			
			try {
				dispatcher.forward(req,resp);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		} 
		else {
			// It's the first connection, user has to change his password
			newpwdView(req, resp);
		}
			
	}
	
	/**
	 * This function allow to display the new password setter view.
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void newpwdView(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// Redirect to the change password view
		resp.sendRedirect(resp.encodeRedirectURL("/user?action=changepwd"));
	}
}
