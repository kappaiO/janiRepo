package jani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author kappa iO
 *
 */
public class Item {
	//for testing purposes currently, this will be updated to work with queries
	
	private String Itname, Rname, categoryName;
	private int price;
	private boolean veg;
	private static Connection con;
	private static ArrayList<Item> itemsList = new ArrayList<Item>();
	
	public Item(){
		
		Itname = "Item Name";
		Rname = "Restaurant Name";
		price = 50;
		categoryName = "Category";
		veg = false;
	}
	
	public Item(String i, String r, int p, String c, boolean v){
		
		Itname = i;
		Rname = r;
		price = p;
		categoryName = c;
		veg = v;
		
	}
	
	public static ArrayList<Item> itemsList() {
		
		try{
		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Database.getDatabaseName(),"root","admin");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM items");// WHERE veg = (isaksClass.getBoolean) ? true : true || false
			while(rs.next()){//this check MUST be performed
			
				Item i = new Item(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getBoolean(5)); 
				itemsList.add(i);
				
			}	
		}
		catch (SQLException s){
			s.getSQLState();
			s.getErrorCode();
			s.printStackTrace();
			System.out.print("error");
			}
		//to test if the arraylist fills up
		//for (Item i : itemsList){
			
			//System.out.println(i.getItname() + " " + i.getRname() + " " + i.getCategoryName() + " " + i.getPrice() + " " + i.getVeg());
			
			
		//}
		return itemsList;
		
		}
	
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
	public String getItname() {
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
