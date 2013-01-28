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
	 * Get all undeleted Citys from the datastore.
	 * @return
	 */
	public List<City> GetAllCitys() {
		
		Query q = new Query("City")
			.setFilter(new FilterPredicate("cty_is_deleted", FilterOperator.NOT_EQUAL, false));
		
		PreparedQuery pq = datastore.prepare(q);
		
		ArrayList<City> retCitys = new ArrayList<City>();
		for(Entity City : pq.asList(FetchOptions.Builder.withDefaults())){
			retCitys.add(new City(City));
		}
		
		return retCitys;
	}
	
	/**
	 * Get the City corresponding with the identifier.
	 * 
	 * @param id City's Unique identifier
	 * @return
	 */
	public City GetCityById(int id) {
		
		Query q =  new Query("City")
        	.setFilter(new FilterPredicate(
        					Entity.KEY_RESERVED_PROPERTY,
        					Query.FilterOperator.EQUAL, 
        					id)
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
		
		datastore.put(cty.toDatastoreEntity());
		
		return true;
	}
	
	/**
	 * Update the City values in the datastore.
	 * 
	 * @param usr
	 * @return
	 */
	public boolean UpdateCity(City usr) {
		
		return AddCity(usr);
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
