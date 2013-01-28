package fr.cpe.ha.jbbflight.dataaccesslayout;

import java.util.List;

import fr.cpe.ha.jbbflight.models.User;

/**
 * Handle data access for the User Object Model.
 * 
 * @author Benjamin Chastanier
 *
 */
public class DALUser {

	/**
	 * Singleton
	 */
	private DALUser instance = null;
	
	private DALUser(){}
	
	/**
	 * Get the singleton instance.
	 * 
	 * @return singleton instance
	 */
	public DALUser getInstance() {
		if(instance == null)
			instance = new DALUser();
		return instance;
	}
	
	public List<User> GetAllUsers() {
		
	}
	
	public User GetUserById(int id) {
		
	}
	
	public boolean AddUser(User usr) {
		
	}
	
	public boolean UpdateUser(User usr) {
		
	}
	
	public boolean RemoveUser(User usr) {
		
	}
}
