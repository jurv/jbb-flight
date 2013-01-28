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
		
		/*RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");			
		try {
			dispatcher.forward(req,resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}*/
		
		resp.getWriter().print("Bienvenue sur la servlet user !");
	}
	
	/**
	 * Return all users
	 * @return List<User> All users registered in the datastore
	 */
	public List<User> getUsers(){
		DALUser dalUser = DALUser.getInstance();
		return dalUser.GetAllUsers();
	}
	
	/**
	 * Return a user
	 * @param idUser The id of the user
	 * @return User The user
	 */
	public User getUser(int idUser){
		DALUser dalUser = DALUser.getInstance();
		return dalUser.GetUserById(idUser);
	}
}
