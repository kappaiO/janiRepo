package jani;

/**
 * @author kappa iO
 *
 */
public class Item {
	//for testing purposes currently, this will be updated to work with queries
	
	private String Itname, Rname, categoryName;
	private int price;
	private boolean veg;
	
	/**
	 * These methods will set the fields for an instance of Item
	 */
	
	public void setItname(String s) {
		Itname = s; 
	}
	public void setRname(String s) {
		Rname = s; 
	}
	
	public void setCategoryName(String s) {
		categoryName = s; 
	}
	
	/**
	 * These methods will return values in fields of Item
	 */
	public String setItname() {
		return Itname; 
	}
	public String getRname() {
		return Rname; 
	}
	
	public String getCategoryName() {
		return categoryName; 
	}
	public int getPrice() {
		return price; 
	}
	public boolean getVeg() {
		return veg; 
	}
}
