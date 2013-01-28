package fr.cpe.ha.jbbflight.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cpe.ha.jbbflight.dataaccesslayout.DALUser;
import fr.cpe.ha.jbbflight.models.User;

/**
 * Users' Controller
 * @author Julien Rouvier
 */
@SuppressWarnings("serial")
public class UserController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		String action = req.getParameter("action");
		
		if("new".equals(action)){
			this.newUser(req, resp);
		}else if("view".equals(action)){
			this.viewUser(req, resp);
		}else if("edit".equals(action)){
			this.editUser(req, resp);
		}else if("list".equals(action)){
			this.listUser(req, resp);
		}else if ("login".equals(action)){
			this.loginUser(req, resp);
		}
	}


	public void newUser(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/usernew.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	public void viewUser(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/userview.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	public void editUser(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/useredit.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	public void listUser(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/userlist.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	public void loginUser(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/newcheck.jsp");
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
