package fr.cpe.ha.jbbflight.dataaccesslayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.PreparedQuery;

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
	
	/**
	 * Get datastore instance.
	 */
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
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
	
	/**
	 * Get all undeleted Users from the datastore.
	 * @return
	 */
	public List<User> GetAllUsers() {
		
		Query q = new Query("User")
			.setFilter(new FilterPredicate("usr_is_deleted", FilterOperator.NOT_EQUAL, false));
		
		PreparedQuery pq = datastore.prepare(q);
		
		ArrayList<User> retUsers = new ArrayList<User>();
		for(Entity user : pq.asList(FetchOptions.Builder.withDefaults())){
			retUsers.add(new User(user));
		}
		
		return retUsers;
	}
	
	/**
	 * Get the User corresponding with the identifier.
	 * 
	 * @param id User's Unique identifier
	 * @return
	 */
	public User GetUserById(int id) {
		
	}
	
	public boolean AddUser(User usr) {
		
	}
	
	public boolean UpdateUser(User usr) {
		
	}
	
	public boolean RemoveUser(User usr) {
		
	}
}
