package jani;

public class User {

	//for testing purposes currently, this will be updated to work with queries
	
	private String userName, type, password;
	
	/**
	 * These methods will set the fields for an instance of Item
	 */
	
	public void setUserName(String s) {
		userName = s; 
	}
	public void setType(String s) {
		type = s; 
	}
	
	public void setPassword(String s) {//the modifier for this might have to change, access to password should be limited
		password = s; 
	}
	
	/**
	 * These methods will return values in fields of Category
	 */
	public String setUserName() {
		return userName; 
	}
	public String getType() {
		return type; 
	}
	public String getPassword() {//the modifier for this might have to change, access to password should be limited
		return password; 
	}
}
