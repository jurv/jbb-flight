package fr.cpe.ha.jbbflight.models;

import java.util.Date;

import com.google.appengine.api.datastore.Entity;

/**
 * Represents a User's login session trace.
 * 
 * @author Benjamin Chastanier
 *
 */

public class User_to_Connection {
	
	public final static String USER_TO_CONNECTION="User_to_Connection";
	public final static String USER_TO_CONNECTION_DATE="_utc_date";
	public final static String USER_TO_CONNECTION_ID="utc_id";
	public final static String USER_TO_CONNECTION_IS_DELETED="utc_is_deleted";
	
	

	/**
	 * Unique User's login session trace identifier.
	 */
	String utc_id;
	
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
	 * Contruct an User_to_Connection from a datastore model.
	 * @param utc
	 */
	public User_to_Connection(Entity utc) {
		this.usr_id 		= (Integer)utc.getProperty(User.USER_ID);
		this.utc_date 		= (Date)utc.getProperty(USER_TO_CONNECTION_DATE);
		this.utc_id     	= (String)utc.getProperty(USER_TO_CONNECTION_ID);
		this.utc_is_deleted = (Boolean)utc.getProperty(USER_TO_CONNECTION_IS_DELETED);
	}
	
	/**
	 * Return the User_to_Connection model as a User_to_Connection datastore entity model
	 * @return
	 */
	public Entity toDatastoreEntity() {
		Entity utc = new Entity(USER_TO_CONNECTION, USER_TO_CONNECTION_ID);
		utc.setProperty(USER_TO_CONNECTION_ID, this.utc_id);
		utc.setProperty(User.USER_ID, this.usr_id);
		utc.setProperty(USER_TO_CONNECTION_DATE, this.utc_date);
		utc.setProperty(USER_TO_CONNECTION_IS_DELETED, this.utc_is_deleted);
		
		return utc;
	}

	/**
	 * @return the utc_id
	 */
	public String getUtc_id() {
		return utc_id;
	}

	/**
	 * @param utc_id the utc_id to set
	 */
	public void setUtc_id(String utc_id) {
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
