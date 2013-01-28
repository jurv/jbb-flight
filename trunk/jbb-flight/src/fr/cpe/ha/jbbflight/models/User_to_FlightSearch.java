package fr.cpe.ha.jbbflight.models;

import java.util.Date;


/**
 * Keep tracks of flights researches done by a user
 * @author Julien Rouvier
 */
public class User_to_FlightSearch {

	/**
	 * Id of the search
	 */
	private int utf_id;
	
	/**
	 * Date of the search
	 */
	private Date utf_date;
	
	/**
	 * City from where the plane will leave
	 */
	private int utf_leaving_from;
	
	/**
	 * City where the plain is flying to
	 */
	private int utf_going_to;
	
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
	 * @return the utf_id
	 */
	public int getUtf_id() {
		return utf_id;
	}

	/**
	 * @param utf_id the utf_id to set
	 */
	public void setUtf_id(int utf_id) {
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
	public int getUtf_leaving_from() {
		return utf_leaving_from;
	}

	/**
	 * @param utf_leaving_from the utf_leaving_from to set
	 */
	public void setUtf_leaving_from(int utf_leaving_from) {
		this.utf_leaving_from = utf_leaving_from;
	}

	/**
	 * @return the utf_going_to
	 */
	public int getUtf_going_to() {
		return utf_going_to;
	}

	/**
	 * @param utf_going_to the utf_going_to to set
	 */
	public void setUtf_going_to(int utf_going_to) {
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
