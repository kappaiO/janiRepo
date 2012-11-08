package jani;

/**
 * @author kappa iO
 *
 */
public class Restaurant {
	
//for testing purposes currently, this will be updated to work with queries
	
	private String Rname, address, phone, openTime, closeTime, description, keywords, picLink;
	private int rating, mapCoord;
	
	/**
	 * These methods will set the fields for an instance of Restaurant
	 */
	
	public void setRname(String s) {
		Rname = s; 
	}
	public void setAddress(String s) {
		address = s; 
	}
	public void setPhone(String s) {
		phone = s; 
	}
	public void setOpenTime(String s) {
		openTime = s; 
	}
	public void setCloseTime(String s) {
		closeTime = s; 
	}
	public void setDescription(String s) {
		description = s; 
	}
	public void setKeywords(String s) {
		keywords = s; 
	}
	public void setPicLink(String s) {
		picLink = s; 
	}
	public void setRating(int i) {
		rating = i; 
	}
	public void setMapCoord(int i) {
		mapCoord = i; 
	}
	
	/**
	 * These methods will return the values in fields of Restaurant
	 */
	public String getRname() {
		return Rname; 
	}
	public String getAddress() {
		return address; 
	}
	public String getPhone() {
		return phone; 
	}
	public String getOpenTime() {
		return openTime; 
	}
	public String getCloseTime() {
		return closeTime; 
	}
	public String getDescription() {
		return description; 
	}
	public String getKeywords() {
		return keywords; 
	}
	public String getPicLink() {
		return picLink; 
	}
	public int getrating() {
		return rating; 
	}
	public int getmapCoord() {
		return mapCoord; 
	}
}
