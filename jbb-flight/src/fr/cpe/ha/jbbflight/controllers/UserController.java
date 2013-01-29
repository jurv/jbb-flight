package fr.cpe.ha.jbbflight.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	private void loginUserAction(HttpServletRequest req, HttpServletResponse resp) {
		
		
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
		
		User usr = new User();
		usr.setUsr_birthdate(Utils.getDateFromString(req.getParameter(User.USER_BIRTHDATE), ""));
		usr.setUsr_email(req.getParameter(User.USER_EMAIL));
		usr.setUsr_firstname(req.getParameter(User.USER_FIRSTNAME));
		usr.setUsr_lastname(req.getParameter(User.USER_LASTNAME));
		usr.setUsr_login(req.getParameter(User.USER_LOGIN));
		usr.setUsr_password(req.getParameter(User.USER_IS_PASSWORD_CONFIRMED));
		
		DALUser dalUser = DALUser.getInstance();
		dalUser.AddUser(usr);
		
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
	 */
	private void changePasswdUserAction(HttpServletRequest req, HttpServletResponse resp) {
		
		javax.servlet.http.HttpSession session = req.getSession();
		
		// Get the user key from the session
		String usr_id = (String)session.getAttribute("usr_id");
		
		// Get the params from the form
		String passwd1 = req.getParameter("usr_password");
		String passwd2 = req.getParameter("usr_re_password");
		if(passwd1.equals(passwd2) && !passwd1.isEmpty() && !usr_id.isEmpty()) {
			// Get the current user
			User usr = DALUser.getInstance().GetUserById(usr_id);
			usr.setUsr_password(passwd1);
			usr.setUsr_is_password_confirmed(true);
		}
		else if( usr_id.isEmpty() ) {
			req.setAttribute("error-message", "Error : There is a problem with your session ! ");
		}
		else {
			req.setAttribute("error-message", "The two passwords are differents !");
		}
		
	}
	
}
