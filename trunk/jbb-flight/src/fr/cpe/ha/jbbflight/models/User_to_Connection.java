package fr.cpe.ha.jbbflight.models;

import java.util.Date;

/**
 * Represents a User's login session trace.
 * 
 * @author Benjamin Chastanier
 *
 */
public class User_to_Connection {

	/**
	 * Unique User's login session trace identifier.
	 */
	int utc_id;
	
	/**
	 * User's identifier
	 */
	int usr_id;
	
	/**
	 * True if the User's login session trace is deleted
	 */
	boolean utc_is_deleted;
	
	/**
	 * User's login session trace date.
	 */
	Date utc_date;

	/**
	 * @return the utc_id
	 */
	public int getUtc_id() {
		return utc_id;
	}

	/**
	 * @param utc_id the utc_id to set
	 */
	public void setUtc_id(int utc_id) {
		this.utc_id = utc_id;
	}

	/**
	 * @return the usr_id
	 */
	public int getUsr_id() {
		return usr_id;
	}

	/**
	 * @param usr_id the usr_id to set
	 */
	public void setUsr_id(int usr_id) {
		this.usr_id = usr_id;
	}

	/**
	 * @return the utc_is_deleted
	 */
	public boolean isUtc_is_deleted() {
		return utc_is_deleted;
	}

	/**
	 * @param utc_is_deleted the utc_is_deleted to set
	 */
	public void setUtc_is_deleted(boolean utc_is_deleted) {
		this.utc_is_deleted = utc_is_deleted;
	}

	/**
	 * @return the utc_date
	 */
	public Date getUtc_date() {
		return utc_date;
	}

	/**
	 * @param utc_date the utc_date to set
	 */
	public void setUtc_date(Date utc_date) {
		this.utc_date = utc_date;
	}
}
