package fr.cpe.ha.jbbflight.models;

import java.util.Date;

import com.google.appengine.api.datastore.Entity;


/**
 * Keep tracks of flights researches done by a user
 * @author Julien Rouvier
 */
public class User_to_FlightSearch {
	
	public final static String USER_TO_FLIGHTSEARCH = "User_to_FlightSearch";
	public final static String USER_TO_FLIGHTSEARCH_ID = "utf_id";
	public final static String USER_TO_FLIGHTSEARCH_DATE = "utf_date";
	public final static String USER_TO_FLIGHTSEARCH_LEAVING_FROM = "utf_leaving_from";
	public final static String USER_TO_FLIGHTSEARCH_GOING_TO = "utf_going_to";
	public final static String USER_TO_FLIGHTSEARCH_DATE_DEPARTURE = "utf_date_departure";
	public final static String USER_TO_FLIGHTSEARCH_IS_DELETED = "utf_is_deleted";
	public final static String USER_TO_FLIGHTSEARCH_RESPONSES_COUNT = "utf_responses_count";
	
	/**
	 * Id of the search
	 */
	private String utf_id;
	
	/**
	 * Date of the search
	 */
	private Date utf_date;
	
	/**
	 * City from where the plane will leave
	 */
	private String utf_leaving_from;
	
	/**
	 * City where the plain is flying to
	 */
	private String utf_going_to;
	
	/**
	 * Departure date of the flight
	 */
	private Date utf_date_departure;
	
	/**
	 * Has this search been deleted ?
	 */
	private boolean utf_is_deleted;
	
	/**
	 * Number of response returned for this search
	 */
	private int utf_responses_count;

	/**
	 * Construct a User_to_FlightSearch object from a datastore entity User_to_FlightSearch
	 */
	public User_to_FlightSearch(Entity utf) {
		this.utf_date            = (Date)utf.getProperty(USER_TO_FLIGHTSEARCH_DATE);
		this.utf_date_departure  = (Date)utf.getProperty(USER_TO_FLIGHTSEARCH_DATE_DEPARTURE);
		this.utf_going_to        = (String)utf.getProperty(USER_TO_FLIGHTSEARCH_GOING_TO);
		this.utf_id              = (String)utf.getProperty(USER_TO_FLIGHTSEARCH_ID);
		this.utf_is_deleted      = (Boolean)utf.getProperty(USER_TO_FLIGHTSEARCH_IS_DELETED);
		this.utf_leaving_from    = (String)utf.getProperty(USER_TO_FLIGHTSEARCH_LEAVING_FROM);
		this.utf_responses_count = (Integer)utf.getProperty(USER_TO_FLIGHTSEARCH_RESPONSES_COUNT);
	}
	
	/**
	 * Return the User_to_FlightSearch model as a User_to_FlightSearch datastore entity model
	 * @return
	 */
	public Entity toDatastoreEntity() {
		
		Entity user_to_flightSearch = new Entity(USER_TO_FLIGHTSEARCH, USER_TO_FLIGHTSEARCH_ID);
		
		user_to_flightSearch.setProperty(USER_TO_FLIGHTSEARCH_DATE, this.utf_date);
		user_to_flightSearch.setProperty(USER_TO_FLIGHTSEARCH_DATE_DEPARTURE, this.utf_date_departure);
		user_to_flightSearch.setProperty(USER_TO_FLIGHTSEARCH_GOING_TO, this.utf_going_to);
		user_to_flightSearch.setProperty(USER_TO_FLIGHTSEARCH_ID, this.utf_id);
		user_to_flightSearch.setProperty(USER_TO_FLIGHTSEARCH_IS_DELETED, this.utf_is_deleted);
		user_to_flightSearch.setProperty(USER_TO_FLIGHTSEARCH_LEAVING_FROM, this.utf_leaving_from);
		user_to_flightSearch.setProperty(USER_TO_FLIGHTSEARCH_RESPONSES_COUNT, this.utf_responses_count);
		
		return user_to_flightSearch;
	}
	
	/**
	 * @return the utf_id
	 */
	public String getUtf_id() {
		return utf_id;
	}

	/**
	 * @param utf_id the utf_id to set
	 */
	public void setUtf_id(String utf_id) {
		this.utf_id = utf_id;
	}

	/**
	 * @return the utf_date
	 */
	public Date getUtf_date() {
		return utf_date;
	}

	/**
	 * @param utf_date the utf_date to set
	 */
	public void setUtf_date(Date utf_date) {
		this.utf_date = utf_date;
	}

	/**
	 * @return the utf_leaving_from
	 */
	public String getUtf_leaving_from() {
		return utf_leaving_from;
	}

	/**
	 * @param utf_leaving_from the utf_leaving_from to set
	 */
	public void setUtf_leaving_from(String utf_leaving_from) {
		this.utf_leaving_from = utf_leaving_from;
	}

	/**
	 * @return the utf_going_to
	 */
	public String getUtf_going_to() {
		return utf_going_to;
	}

	/**
	 * @param utf_going_to the utf_going_to to set
	 */
	public void setUtf_going_to(String utf_going_to) {
		this.utf_going_to = utf_going_to;
	}

	/**
	 * @return the utf_date_departure
	 */
	public Date getUtf_date_departure() {
		return utf_date_departure;
	}

	/**
	 * @param utf_date_departure the utf_date_departure to set
	 */
	public void setUtf_date_departure(Date utf_date_departure) {
		this.utf_date_departure = utf_date_departure;
	}

	/**
	 * @return the utf_is_deleted
	 */
	public boolean isUtf_is_deleted() {
		return utf_is_deleted;
	}

	/**
	 * @param utf_is_deleted the utf_is_deleted to set
	 */
	public void setUtf_is_deleted(boolean utf_is_deleted) {
		this.utf_is_deleted = utf_is_deleted;
	}

	/**
	 * @return the utf_responses_count
	 */
	public int getUtf_responses_count() {
		return utf_responses_count;
	}

	/**
	 * @param utf_responses_count the utf_responses_count to set
	 */
	public void setUtf_responses_count(int utf_responses_count) {
		this.utf_responses_count = utf_responses_count;
	}
}
