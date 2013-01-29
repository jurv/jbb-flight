package fr.cpe.ha.jbbflight.dataaccesslayout;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.PreparedQuery;

import fr.cpe.ha.jbbflight.models.City;

/**
 * Handle data access for the City Object Model.
 * 
 * @author Benjamin Chastanier
 *
 */
public class DALCity {

	/**
	 * Singleton
	 */
	private static DALCity instance = null;
	
	/**
	 * Get datastore instance.
	 */
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	private DALCity(){}
	
	/**
	 * Get the singleton instance.
	 * 
	 * @return singleton instance
	 */
	public static DALCity getInstance() {
		if(instance == null)
			instance = new DALCity();
		return instance;
	}
	
	/**
	 * Get all undeleted Cities from the datastore.
	 * @return
	 */
	public List<City> GetAllCities() {
		
		Query q = new Query("City")
			.setFilter(new FilterPredicate("cty_is_deleted", FilterOperator.EQUAL, false));
		
		PreparedQuery pq = datastore.prepare(q);
		
		ArrayList<City> retCities = new ArrayList<City>();
		for(Entity City : pq.asList(FetchOptions.Builder.withDefaults())){
			retCities.add(new City(City));
		}
		
		return retCities;
	}
	
	/**
	 * Get all Cities with specified parameters.
	 * 
	 * @param filters
	 * @return
	 */
	public List<City> GetCitiesWithParams(List<FilterPredicate> filters){
		
		Query q = new Query("City");
		
		for(FilterPredicate filter : filters)
			q.setFilter(filter);
	
		PreparedQuery pq = datastore.prepare(q);
	
		ArrayList<City> retCities = new ArrayList<City>();
		for(Entity City : pq.asList(FetchOptions.Builder.withDefaults())){
			retCities.add(new City(City));
		}
	
		return retCities;
	}
	
	/**
	 * Get the City corresponding with the identifier.
	 * 
	 * @param id City's Unique identifier
	 * @return
	 */
	public City GetCityById(long id) {
		
		Query q =  new Query("City")
        	.setFilter(new FilterPredicate(
        					Entity.KEY_RESERVED_PROPERTY,
        					Query.FilterOperator.EQUAL, 
        					KeyFactory.createKey("City", id))
                       );
		PreparedQuery pq = datastore.prepare(q);

		return new City(pq.asSingleEntity());
	}
	
	/**
	 * Add the City in the datastore.
	 * 
	 * @param usr
	 * @return
	 */
	public boolean AddCity(City cty) {
		Key key = datastore.put(cty.toDatastoreEntity());
		cty.setCty_id(key.getId());
		return true;
	}
	
	/**
	 * Update the City values in the datastore.
	 * 
	 * @param usr
	 * @return
	 */
	public City UpdateCity(City cty) {
		datastore.delete(KeyFactory.createKey("City", cty.getCty_id()));
		Key key = datastore.put(cty.toDatastoreEntity());
		cty.setCty_id(key.getId());
		return cty;
	}
	
	/**
	 * Logical remove the City in the datastore. 
	 * 
	 * @param usr
	 * @return
	 */
	public boolean RemoveCity(City cty) {
		
		cty.setCty_is_deleted(true);
		UpdateCity(cty);
		
		return true;
	}
}
