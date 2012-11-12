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
public class Category {

	//for testing purposes currently, this will be updated to work with queries
	
	private String categoryName, Rname, picLink;
	private static Connection con;
	private static ArrayList<Category> categoryList = new ArrayList<Category>();
	
		public Category(){
		
			categoryName = "Category Name";
			Rname = "Rname";
			picLink = "Picture Link";
		}
	
		public Category(String c, String r, String p){
		
			categoryName = c;
			Rname = r;
			picLink = p;
		
		}
	
		public static ArrayList<Category> categoriesList() {
		
			try{
		
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Database.getDatabaseName(),"root","admin");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT categories.CategoryName, Rname, PicLink FROM categories, items WHERE items.Category = categories.CategoryName");
				
					while(rs.next()){//this check MUST be performed
						
					Category c = new Category(rs.getString(1), rs.getString(2), rs.getString(3)); 
					categoryList.add(c);
				
						}	
			}
			catch (SQLException s){
				s.getSQLState();
				s.getErrorCode();
				s.printStackTrace();
				System.out.print("error");
				}
		//to test if the arraylist fills up
		//for (Category c : categoryList){
			
			//System.out.println(c.getCategoryName() + " " + c.getRname() + " " + c.getPicLink());
			
			
		//}
			return categoryList;
		
			}
	/**
	 * These methods will set the fields for an instance of Category
	 */
	
	public void setCategoryName(String s) {
		categoryName = s; 
	}
	public void setRName(String s) {
		Rname = s; 
	}
	public void setPicture(String s) {
		picLink = s; 
	}
	
	/**
	 * These methods will return values in fields of Category
	 */
	public String getCategoryName() {
		return categoryName; 
	}
	public String getRname() {
		return Rname; 
	}
	public String getPicLink() {
		return picLink; 
	}
}