package fr.cpe.ha.jbbflight.dataaccesslayout;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.PreparedQuery;

import fr.cpe.ha.jbbflight.models.City;
import fr.cpe.ha.jbbflight.models.Flight;

/**
 * Handle data access for the Flight Object Model.
 * 
 * @author Benjamin Chastanier
 *
 */
public class DALFlight {

	/**
	 * Singleton
	 */
	private static DALFlight instance = null;
	
	/**
	 * Get datastore instance.
	 */
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	private DALFlight(){}
	
	/**
	 * Get the singleton instance.
	 * 
	 * @return singleton instance
	 */
	public static DALFlight getInstance() {
		if(instance == null)
			instance = new DALFlight();
		return instance;
	}
	
	/**
	 * Get all undeleted Flights from the datastore.
	 * @return
	 */
	public List<Flight> GetAllFlights() {
		
		Query q = new Query("Flight")
			.setFilter(new FilterPredicate("fgt_is_deleted", FilterOperator.EQUAL, false));
		
		PreparedQuery pq = datastore.prepare(q);
		
		ArrayList<Flight> retFlights = new ArrayList<Flight>();
		for(Entity flight : pq.asList(FetchOptions.Builder.withDefaults())){
			retFlights.add(new Flight(flight));
		}
		
		return retFlights;
	}
	
	/**
	 * Get all Flight with specified parameters.
	 * 
	 * @param filters
	 * @return
	 */
	public List<Flight> GetFlightWithParams(List<FilterPredicate> filters){
		
		Query q = new Query("Flight");
		
		for(FilterPredicate filter : filters)
			q.setFilter(filter);
	
		PreparedQuery pq = datastore.prepare(q);
	
		ArrayList<Flight> retFlights = new ArrayList<Flight>();
		for(Entity Flight : pq.asList(FetchOptions.Builder.withDefaults())){
			retFlights.add(new Flight(Flight));
		}
	
		return retFlights;
	}
	
	/**
	 * Get the Flight corresponding with the identifier.
	 * 
	 * @param id Flight's Unique identifier
	 * @return
	 */
	public Flight GetFlightById(String id) {
		
		Query q =  new Query("Flight")
        	.setFilter(new FilterPredicate(
        					Entity.KEY_RESERVED_PROPERTY,
        					Query.FilterOperator.EQUAL, 
        					id)
                       );
		PreparedQuery pq = datastore.prepare(q);

		return new Flight(pq.asSingleEntity());
	}
	
	/**
	 * Add the flight in the datastore.
	 * 
	 * @param fgt
	 * @return
	 */
	public boolean AddFlight(Flight fgt) {
		datastore.put(fgt.toDatastoreEntity());
		return true;
	}
	
	/**
	 * Update the flight values in the datastore.
	 * 
	 * @param fgt
	 * @return
	 */
	public boolean UpdateFlight(Flight fgt) {
		return AddFlight(fgt);
	}
	
	/**
	 * Logical remove the flight in the datastore. 
	 * 
	 * @param fgt
	 * @return
	 */
	public boolean RemoveFlight(Flight fgt) {
		
		fgt.setFgt_is_deleted(true);
		UpdateFlight(fgt);
		
		return true;
	}
}
