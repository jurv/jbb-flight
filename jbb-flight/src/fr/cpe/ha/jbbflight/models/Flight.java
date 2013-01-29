package fr.cpe.ha.jbbflight.models;

import java.util.Date;
import com.google.appengine.api.datastore.Entity;


/**
 * 
 * @author Julien Rouvier
 */
public class Flight {

	/**
	 * Definitions of model's attributes
	 */
	public final static String FLIGHT                 = "Flight";
	public final static String FLIGHT_ID              = "fgt_id" ;
	public final static String FLIGHT_LEAVING_FROM_ID = "fgt_leaving_from_id" ;
	public final static String FLIGHT_GOING_TO_ID     = "fgt_going_to_id" ;
	public final static String FLIGHT_DATE_DEPARTURE  = "fgt_date_departure" ;
	public final static String FLIGHT_DATE_ARRIVAL    = "fgt_date_arrival" ;
	public final static String FLIGHT_PRICE           = "fgt_price" ;
	public final static String FLIGHT_TOTAL_SEATS     = "fgt_total_seats" ;
	public final static String FLIGHT_RESERVED_SEATS  = "fgt_reserved_seats" ;
	public final static String FLIGHT_IS_DELETED      = "fgt_is_deleted" ;
	
	/**
	 * Id of the flight
	 */
	private String fgt_id;

	/**
	 * City from where the plane will leave
	 */
	private String fgt_leaving_from_id;
	
	/**
	 * City where the plain is flying to
	 */
	private String fgt_going_to_id;
	
	/**
	 * Departure date of the flight
	 */
	private Date fgt_date_departure;
	
	/**
	 * Arrival date of the flight
	 */
	private Date fgt_date_arrival;
	
	/**
	 * Price for a seat in the plane
	 */
	private double fgt_price;
	
	/**
	 * Number of seats in the plane
	 */
	private long fgt_total_seats;
	
	/**
	 * Number of seats already reserved on the plane
	 */
	private long fgt_reserved_seats;
	
	/**
	 * Has this flight been deleted
	 */
	private boolean fgt_is_deleted;

	
	public Flight() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Construct a Flight object from a datastore entity flight
	 */
	public Flight(Entity fgt) {
		this.fgt_id              = (String)fgt.getKey().toString();
		this.fgt_date_arrival    = (Date)fgt.getProperty(FLIGHT_DATE_ARRIVAL);
		this.fgt_date_departure  = (Date)fgt.getProperty(FLIGHT_DATE_DEPARTURE);
		this.fgt_going_to_id     = (String)fgt.getProperty(FLIGHT_GOING_TO_ID);
		this.fgt_leaving_from_id = (String)fgt.getProperty(FLIGHT_LEAVING_FROM_ID);
		this.fgt_price           = (Double)fgt.getProperty(FLIGHT_PRICE);
		this.fgt_reserved_seats  = (Long)fgt.getProperty(FLIGHT_RESERVED_SEATS);
		this.fgt_total_seats     = (Long)fgt.getProperty(FLIGHT_TOTAL_SEATS);
		this.fgt_is_deleted      = (Boolean)fgt.getProperty(FLIGHT_IS_DELETED);
	}
	
	/**
	 * Return the Flight model as a Flight datastore entity model
	 * @return
	 */
	public Entity toDatastoreEntity() {
		
		Entity flight = new Entity(FLIGHT);
		
		flight.setProperty(FLIGHT_DATE_ARRIVAL, this.fgt_date_arrival);
		flight.setProperty(FLIGHT_DATE_DEPARTURE, this.fgt_date_departure);
		flight.setProperty(FLIGHT_LEAVING_FROM_ID, this.fgt_leaving_from_id);
		flight.setProperty(FLIGHT_GOING_TO_ID, this.fgt_going_to_id);
		flight.setProperty(FLIGHT_PRICE, this.fgt_price);
		flight.setProperty(FLIGHT_TOTAL_SEATS, this.fgt_total_seats);
		flight.setProperty(FLIGHT_RESERVED_SEATS, this.fgt_reserved_seats);
		flight.setProperty(FLIGHT_IS_DELETED, this.fgt_is_deleted);
		
		return flight;
	}
	
	/**
	 * @return the fgt_id
	 */
	public String getFgt_id() {
		return fgt_id;
	}

	/**
	 * @param fgt_id the fgt_id to set
	 */
	public void setFgt_id(String fgt_id) {
		this.fgt_id = fgt_id;
	}

	/**
	 * @return the fgt_leaving_from_id
	 */
	public String getFgt_leaving_from_id() {
		return fgt_leaving_from_id;
	}

	/**
	 * @param fgt_leaving_from_id the fgt_leaving_from_id to set
	 */
	public void setFgt_leaving_from_id(String fgt_leaving_from_id) {
		this.fgt_leaving_from_id = fgt_leaving_from_id;
	}

	/**
	 * @return the fgt_going_to_id
	 */
	public String getFgt_going_to_id() {
		return fgt_going_to_id;
	}

	/**
	 * @param fgt_going_to_id the fgt_going_to_id to set
	 */
	public void setFgt_going_to_id(String fgt_going_to_id) {
		this.fgt_going_to_id = fgt_going_to_id;
	}

	/**
	 * @return the fgt_date_departure
	 */
	public Date getFgt_date_departure() {
		return fgt_date_departure;
	}

	/**
	 * @param fgt_date_departure the fgt_date_departure to set
	 */
	public void setFgt_date_departure(Date fgt_date_departure) {
		this.fgt_date_departure = fgt_date_departure;
	}

	/**
	 * @return the fgt_date_arrival
	 */
	public Date getFgt_date_arrival() {
		return fgt_date_arrival;
	}

	/**
	 * @param fgt_date_arrival the fgt_date_arrival to set
	 */
	public void setFgt_date_arrival(Date fgt_date_arrival) {
		this.fgt_date_arrival = fgt_date_arrival;
	}

	/**
	 * @return the fgt_price
	 */
	public double getFgt_price() {
		return fgt_price;
	}

	/**
	 * @param fgt_price the fgt_price to set
	 */
	public void setFgt_price(float fgt_price) {
		this.fgt_price = fgt_price;
	}

	/**
	 * @return the fgt_total_seats
	 */
	public long getFgt_total_seats() {
		return fgt_total_seats;
	}

	/**
	 * @param fgt_total_seats the fgt_total_seats to set
	 */
	public void setFgt_total_seats(long fgt_total_seats) {
		this.fgt_total_seats = fgt_total_seats;
	}

	/**
	 * @return the fgt_reserved_seats
	 */
	public long getFgt_reserved_seats() {
		return fgt_reserved_seats;
	}

	/**
	 * @param fgt_reserved_seats the fgt_reserved_seats to set
	 */
	public void setFgt_reserved_seats(long fgt_reserved_seats) {
		this.fgt_reserved_seats = fgt_reserved_seats;
	}

	/**
	 * @return the fgt_is_deleted
	 */
	public boolean isFgt_is_deleted() {
		return fgt_is_deleted;
	}

	/**
	 * @param fgt_is_deleted the fgt_is_deleted to set
	 */
	public void setFgt_is_deleted(boolean fgt_is_deleted) {
		this.fgt_is_deleted = fgt_is_deleted;
	}	
}
