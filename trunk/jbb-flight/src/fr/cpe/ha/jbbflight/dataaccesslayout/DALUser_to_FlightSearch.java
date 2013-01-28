package fr.cpe.ha.jbbflight.dataaccesslayout;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

import fr.cpe.ha.jbbflight.models.User_to_FlightSearch;

public class DALUser_to_FlightSearch {

	/**
	 * Singleton
	 */
	private static DALUser_to_FlightSearch instance = null;
	
	/**
	 * Get datastore instance.
	 */
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	private DALUser_to_FlightSearch(){}
	
	/**
	 * Get the singleton instance.
	 * 
	 * @return singleton instance
	 */
	public static DALUser_to_FlightSearch getInstance() {
		if(instance == null)
			instance = new DALUser_to_FlightSearch();
		return instance;
	}
	
	/**
	 * Get all undeleted User_to_FlightSearchs from the datastore.
	 * @return
	 */
	public List<User_to_FlightSearch> GetAllUser_to_FlightSearchs() {
		
		Query q = new Query("User_to_FlightSearch")
			.setFilter(new FilterPredicate("utf_is_deleted", FilterOperator.NOT_EQUAL, false));
		
		PreparedQuery pq = datastore.prepare(q);
		
		ArrayList<User_to_FlightSearch> retUser_to_FlightSearchs = new ArrayList<User_to_FlightSearch>();
		for(Entity user_to_FlightSearch : pq.asList(FetchOptions.Builder.withDefaults())){
			retUser_to_FlightSearchs.add(new User_to_FlightSearch(user_to_FlightSearch));
		}
		
		return retUser_to_FlightSearchs;
	}
	
	/**
	 * Get the User_to_FlightSearch corresponding with the identifier.
	 * 
	 * @param id User_to_FlightSearch's Unique identifier
	 * @return
	 */
	public User_to_FlightSearch GetUser_to_FlightSearchById(int id) {
		
		Query q =  new Query("User_to_FlightSearch")
        	.setFilter(new FilterPredicate(
        					Entity.KEY_RESERVED_PROPERTY,
        					Query.FilterOperator.EQUAL, 
        					id)
                       );
		PreparedQuery pq = datastore.prepare(q);

		return new User_to_FlightSearch(pq.asSingleEntity());
	}
	
	/**
	 * Add the user_to_FlightSearch in the datastore.
	 * 
	 * @param utf
	 * @return
	 */
	public boolean AddUser_to_FlightSearch(User_to_FlightSearch utf) {
		datastore.put(utf.toDatastoreEntity());
		return true;
	}
	
	/**
	 * Update the user_to_FlightSearch values in the datastore.
	 * 
	 * @param utf
	 * @return
	 */
	public boolean UpdateUser_to_FlightSearch(User_to_FlightSearch utf) {
		return AddUser_to_FlightSearch(utf);
	}
	
	/**
	 * Logical remove the user_to_FlightSearch in the datastore. 
	 * 
	 * @param utf
	 * @return
	 */
	public boolean RemoveUser_to_FlightSearch(User_to_FlightSearch utf) {
		
		utf.setUtf_is_deleted(true);
		UpdateUser_to_FlightSearch(utf);
		
		return true;
	}
	
}
