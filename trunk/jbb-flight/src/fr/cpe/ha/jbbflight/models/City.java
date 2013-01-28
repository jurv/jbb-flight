package fr.cpe.ha.jbbflight.models;

/**
 * 
 * @author baptiste.gaujal
 *
 */

public class City {
	/*
	 * Unique identifier of city
	 */
	private int cty_id;
	
	/*
	 * Name of the city
	 */
	String cty_label;
	
	/*
	 * Logical state of the city
	 */
	boolean cty_is_deleted;
	

	/**
	 * @return the cty_id
	 */
	public int getCty_id() {
		return cty_id;
	}

	/**
	 * @param cty_id the cty_id to set
	 */
	public void setCty_id(int cty_id) {
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