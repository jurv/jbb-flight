package fr.cpe.ha.jbbflight.models;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

/**
 * 
 * @author baptiste.gaujal
 *
 */

public class City {
	
	public final static String CITY = "City";
	public final static String CITY_ID = "cty_id";
	public final static String CITY_LABEL = "cty_label";
	public final static String CITY_IS_DELETED = "cty_is_deleted";
	
	/*
	 * Unique identifier of city
	 */
	private Key cty_id;
	
	/*
	 * Name of the city
	 */
	String cty_label;
	
	/*
	 * Logical state of the city
	 */
	boolean cty_is_deleted;
	
	
	public City() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Construct a City from a datastore entity city
	 * 
	 * @param cty
	 */
	public City (Entity cty) {
		this.cty_id 		= cty.getKey();
		this.cty_is_deleted = (Boolean)cty.getProperty(CITY_IS_DELETED);
		this.cty_label      = (String)cty.getProperty(CITY_LABEL);
	}
	
	/**
	 * Return the City model as a City datastore entity model
	 * @return
	 */
	public Entity toDatastoreEntity() {
		Entity city = new Entity(CITY);
		city.setProperty(CITY_ID, this.getCty_id());
		city.setProperty(CITY_IS_DELETED, this.cty_is_deleted);
		city.setProperty(CITY_LABEL, this.cty_label);
		
		return city;
	}

	/**
	 * @return the cty_id
	 */
	public Key getCty_id() {
		return cty_id;
	}

	/**
	 * @param cty_id the cty_id to set
	 */
	public void setCty_id(Key cty_id) {
		this.cty_id = cty_id;
	}

	/**
	 * @return the cty_label
	 */
	public String getCty_label() {
		return cty_label;
	}

	/**
	 * @param cty_label the cty_label to set
	 */
	public void setCty_label(String cty_label) {
		this.cty_label = cty_label;
	}

	/**
	 * @return the cty_is_deleted
	 */
	public boolean isCty_is_deleted() {
		return cty_is_deleted;
	}

	/**
	 * @param cty_is_deleted the cty_is_deleted to set
	 */
	public void setCty_is_deleted(boolean cty_is_deleted) {
		this.cty_is_deleted = cty_is_deleted;
	}


}
