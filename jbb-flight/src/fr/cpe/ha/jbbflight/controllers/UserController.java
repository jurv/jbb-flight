package fr.cpe.ha.jbbflight.controllers;

import java.util.List;

import fr.cpe.ha.jbbflight.dataaccesslayout.DALUser;
import fr.cpe.ha.jbbflight.models.User;

/**
 * Users' Controller
 * @author Julien Rouvier
 */
public class UserController {

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
