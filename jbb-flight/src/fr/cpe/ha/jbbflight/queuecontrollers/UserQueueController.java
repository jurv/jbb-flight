package fr.cpe.ha.jbbflight.queuecontrollers;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.Utils;
import fr.cpe.ha.jbbflight.dataaccesslayout.DALUser;
import fr.cpe.ha.jbbflight.models.User;

/**
 * Controller which handles queue actions for users.
 * 
 * @author Benjamin Chastanier
 *
 */
@SuppressWarnings("serial")
public class UserQueueController extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/html");
		
		// Get the action and redirect to the correct action
		String action = req.getParameter("action");
		
		if("new".equals(action)){
			this.createUser(req, resp);
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		doGet(req, resp);
	}

	/**
	 * Allows to add user in the datastore.
	 * 
	 * @param req
	 * @param resp
	 */
	private void createUser(HttpServletRequest req, HttpServletResponse resp) {
		
		User usr = new User();
		usr.setUsr_birthdate(Utils.getDateFromString(req.getParameter(User.USER_BIRTHDATE), ""));
		usr.setUsr_email(req.getParameter(User.USER_EMAIL));
		usr.setUsr_firstname(req.getParameter(User.USER_FIRSTNAME));
		usr.setUsr_lastname(req.getParameter(User.USER_LASTNAME));
		usr.setUsr_login(req.getParameter(User.USER_LOGIN));
		
		// Generate a password
		String generatedPass = String.valueOf(usr.hashCode());
		usr.setUsr_password(generatedPass);
		
		DALUser dalUser = DALUser.getInstance();
		dalUser.AddUser(usr);
		
		// Send an email with the password to the user
		String sub = "Welcome on VoYage Platform !";
		String from = "benjamin.chastanier@gmail.com";
		String body = "Your password is : " + generatedPass + " ";
		Utils.SendMessage(req.getParameter(User.USER_EMAIL), from, sub, body);
	}
}
