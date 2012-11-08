package jani;

/**
 * @author kappa iO
 *
 */
public class Category {

	//for testing purposes currently, this will be updated to work with queries
	
	private String categoryName, picLink;
	
	/**
	 * These methods will set the fields for an instance of Category
	 */
	
	public void setCategoryName(String s) {
		categoryName = s; 
	}
	public void setPicture(String s) {
		picLink = s; 
	}
	
	/**
	 * These methods will return values in fields of Category
	 */
	public String setCategoryName() {
		return categoryName; 
	}
	public String getPicLink() {
		return picLink; 
	}
}