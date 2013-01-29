package fr.cpe.ha.jbbflight.controllers;

import java.io.Console;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import static com.google.appengine.api.taskqueue.TaskOptions.Builder.*;

import utils.Utils;
import fr.cpe.ha.jbbflight.dataaccesslayout.DALUser;
import fr.cpe.ha.jbbflight.models.User;

/**
 * Users' Controller
 * @author Julien Rouvier
 */
@SuppressWarnings("serial")
public class UserController extends HttpServlet
{
	/**
	 * 
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/html");
		
		// Get the action and redirect to the correct action
		String action = req.getParameter("action");
		
		if("new".equals(action)){
			this.newUserView(req, resp);
		}else if("view".equals(action)){
			this.viewUserView(req, resp);
		}else if("edit".equals(action)){
			this.editUserView(req, resp);
		}else if("list".equals(action)){
			this.listUserView(req, resp);
		}else if("login".equals(action)){
			this.loginUserView(req, resp);
		}else if("changepwd".equals(action)){
			this.changePasswdUserView(req, resp);
		}else {
			resp.sendRedirect("/user?action=login");
			this.loginUserView(req, resp);
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/html");
		
		// Get the action and redirect to the correct action
		String action = req.getParameter("action");
		
		if("new".equals(action)){
			this.newUserAction(req, resp);
		}else if("edit".equals(action)){
			this.editUserAction(req, resp);
		}else if("changepwd".equals(action)){
			this.changePasswdUserAction(req, resp);
		}else if("login".equals(action)){
			this.loginUserAction(req, resp);
		}
	}

	private void loginUserView(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/userlogin.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}		
	}
	
	private void loginUserAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String login = req.getParameter("usr_login");
		String passwd = req.getParameter("usr_password");
		javax.servlet.http.HttpSession session = req.getSession();
		
		DALUser dalUser = DALUser.getInstance();
		User user = dalUser.DoLogin(login, passwd);
		if ( user != null){
			session.setAttribute(User.USER_ID, user.getUsr_id());
			resp.sendRedirect(resp.encodeRedirectURL("/app?action=dashboard"));
		}
		else {
			req.setAttribute("error-message", "No User find with this login / password :(");
			this.loginUserView(req, resp);
		}
			
	}

	/**
	 * Diplay the new User Form view.
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void newUserView(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/usernew.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Function used to add the user passed in params in the datastore.
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void newUserAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// Using the newUser queue to put the new user in the datastore.
		Queue queue = QueueFactory.getQueue("addUser");
		queue.add(withUrl("/system_user")
				.param("action", "new")
				.param(User.USER_BIRTHDATE, req.getParameter(User.USER_BIRTHDATE))
				.param(User.USER_EMAIL, req.getParameter(User.USER_EMAIL))
				.param(User.USER_FIRSTNAME, req.getParameter(User.USER_FIRSTNAME))
				.param(User.USER_LASTNAME, req.getParameter(User.USER_LASTNAME))
				.param(User.USER_LOGIN, req.getParameter(User.USER_LOGIN))
				.param(User.USER_PASSWORD, req.getParameter(User.USER_PASSWORD))
				);
		
		// Set the message for the new User
		req.setAttribute("message", "Check your mails to find your password :) ");
		
		// Redirect to the login form
		this.loginUserView(req, resp);
	}
	
	/**
	 * Display the details user view.
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void viewUserView(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/userview.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Display the user edit form view.
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void editUserView(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/useredit.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Function used to update the user passed in params in the datastore.
	 * 
	 * @param req
	 * @param resp
	 */
	private void editUserAction(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Display the list users view.
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void listUserView(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/userlist.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Function used to show the change password form.
	 * 
	 * @param req
	 * @param resp
	 */
	public void changePasswdUserView(HttpServletRequest req, HttpServletResponse resp) {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/userchangepwd.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Function used to update the new password of the User.
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void changePasswdUserAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		javax.servlet.http.HttpSession session = req.getSession(true);
		
		// Get the user key from the session
		Key usr_id = (Key)session.getAttribute("usr_id");
		
		// Get the params from the form
		String passwd1 = req.getParameter("usr_password");
		String passwd2 = req.getParameter("usr_re_password");
		if(passwd1.equals(passwd2) && !passwd1.isEmpty() && usr_id!= null) {
			// Get the current user
			User usr = DALUser.getInstance().GetUserById(usr_id);
			usr.setUsr_password(passwd1);
			usr.setUsr_is_password_confirmed(true);
			DALUser.getInstance().UpdateUser(usr);
			
			// Redirect to the dashboard
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/dashboard.jsp");			
			try {
				dispatcher.forward(req,resp);
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		else if(!passwd1.equals(passwd2)) {
			req.setAttribute("error-message", "Error : The two passwords are differents ! ");
			this.changePasswdUserView(req, resp);
		}
		else if( usr_id == null || usr_id != null ) {
			req.setAttribute("error-message", "Error : There is a problem with your session ! ");
			this.changePasswdUserView(req, resp);
		}
		else {
			req.setAttribute("error-message", "Unknown error !");
			this.changePasswdUserView(req, resp);
		}
	}
	
}
