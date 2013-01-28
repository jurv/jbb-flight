package fr.cpe.ha.jbbflight.models;

import java.util.Date;


/**
 * 
 * @author Julien Rouvier
 */
public class Flight {

	/**
	 * Id of the flight
	 */
	private int fgt_id;

	/**
	 * City from where the plane will leave
	 */
	private int fgt_leaving_from_id;
	
	/**
	 * City where the plain is flying to
	 */
	private int fgt_going_to_id;
	
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
	private float fgt_price;
	
	/**
	 * Number of seats in the plane
	 */
	private int fgt_total_seats;
	
	/**
	 * Number of seats already reserved on the plane
	 */
	private int fgt_reserved_seats;
	
	/**
	 * Has this flight been deleted
	 */
	private boolean fgt_is_deleted;

	/**
	 * @return the fgt_id
	 */
	public int getFgt_id() {
		return fgt_id;
	}

	/**
	 * @param fgt_id the fgt_id to set
	 */
	public void setFgt_id(int fgt_id) {
		this.fgt_id = fgt_id;
	}

	/**
	 * @return the fgt_leaving_from_id
	 */
	public int getFgt_leaving_from_id() {
		return fgt_leaving_from_id;
	}

	/**
	 * @param fgt_leaving_from_id the fgt_leaving_from_id to set
	 */
	public void setFgt_leaving_from_id(int fgt_leaving_from_id) {
		this.fgt_leaving_from_id = fgt_leaving_from_id;
	}

	/**
	 * @return the fgt_going_to_id
	 */
	public int getFgt_going_to_id() {
		return fgt_going_to_id;
	}

	/**
	 * @param fgt_going_to_id the fgt_going_to_id to set
	 */
	public void setFgt_going_to_id(int fgt_going_to_id) {
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
	public float getFgt_price() {
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
	public int getFgt_total_seats() {
		return fgt_total_seats;
	}

	/**
	 * @param fgt_total_seats the fgt_total_seats to set
	 */
	public void setFgt_total_seats(int fgt_total_seats) {
		this.fgt_total_seats = fgt_total_seats;
	}

	/**
	 * @return the fgt_reserved_seats
	 */
	public int getFgt_reserved_seats() {
		return fgt_reserved_seats;
	}

	/**
	 * @param fgt_reserved_seats the fgt_reserved_seats to set
	 */
	public void setFgt_reserved_seats(int fgt_reserved_seats) {
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
