package jani;


import java.sql.*;
import java.util.*;

/**
 * @author kappa iO
 *
 */

public class Restaurant {
	
//for testing purposes currently, this will be updated to work with queries
	
	private String Rname, address, phone, openTime, closeTime, description, keywords, picLink;
	private int rating, mapCoord;
	//private Scanner input;
	private static Connection con;
	private static ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
	
	//provide a constructor with default values
	public Restaurant(){
		Rname = "Restaurant Name";
		address = "Address 123";
		phone = "123456789";
		openTime = "10:00:00";
		closeTime = "22:00:00";
		description = "description";
		keywords = "warm, loud";
		picLink = "pic.link";
		rating = 4;
		mapCoord = 1234;
	}
	
	public Restaurant(String n, String a, String p, String oT, String cT, String d, String kW, String pL, int r, int mC){
		
		Rname = n;
		address = a;
		phone = p;
		openTime = oT;
		closeTime = cT;
		description = d;
		keywords = kW;
		picLink = pL;
		rating = r;
		mapCoord = mC;
		
	}
	
	public static ArrayList<Restaurant> restaurantsList() {
		
		try{
		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Database.getDatabaseName(),"root","admin");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM restaurants");
			while(rs.next()){//this check MUST be performed
			
				Restaurant b = new Restaurant(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10)); 
				restaurantList.add(b);
				
			}	
		}
		catch (SQLException s){
			s.getSQLState();
			s.getErrorCode();
			s.printStackTrace();
			System.out.print("error");
			}
		//to test if the arraylist fills up
		//for (Restaurant r : restaurantList){
			
			//System.out.println(r.getRname() + " " + r.getAddress() + " " + r.getPhone() + " " + r.getOpenTime() + " " + r.getCloseTime() + " "
				//+	r.getDescription() + " " + r.getKeywords() + " " + r.getDescription() + " " + r.getRating() + " " + r.getMapCoord());
			
			
	//	}
		return restaurantList;
		
		}
	
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
	public int getRating() {
		return rating; 
	}
	public int getMapCoord() {
		return mapCoord; 
	}
}
