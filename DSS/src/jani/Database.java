package jani;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;

/**
 * @author kappa iO
 *
 */
public class Database {
	
	
	private Connection con = null;
	private Statement st;
	private static String dbname = "", tableRestaurants = "restaurants", tableItems = "items",tableCategories = "Categories", tableUsers = "Users", delimiter = "#";
	private BufferedReader reader;
	private static ArrayList<Restaurant> restaurantTmp =  new ArrayList<Restaurant>();
	private static ArrayList<Item> itemTmp =  new ArrayList<Item>();
	private static ArrayList<Category> categoryTmp =  new ArrayList<Category>();
	private String userName, password, tmp1, tmp2 = "";
	
	public void CreateDbAndTables() {
		
		System.out.println("Please specify database.");
		
		
		
		try{
			
			reader = new BufferedReader (new InputStreamReader(System.in));
			dbname = reader.readLine();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","admin");
		
			st = con.createStatement();
			st.executeUpdate("CREATE DATABASE IF NOT EXISTS "  + dbname);//database creation
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname,"root","admin");
			st = con.createStatement();
			//tables creation
			st.executeUpdate("CREATE TABLE IF NOT EXISTS "  + tableRestaurants + 
														"(Rname CHAR(80) PRIMARY KEY," +
														"Address CHAR(80)," +
														"Phone CHAR(80)," +
														"Open TIME," +
														"Close TIME," +
														"PicLink CHAR(80)," +
														"Description CHAR(120)," +
														"Keywords CHAR(80)," +
														"Rating INT," +
														"Mapcoord INT" +
														");");
			st = con.createStatement();
			st.executeUpdate("CREATE TABLE IF NOT EXISTS "  + tableCategories +
														"(CategoryName CHAR(40) PRIMARY KEY, " +
														"PicLink CHAR(80) " +
														");");
			
			
			st = con.createStatement();
			st.executeUpdate("CREATE TABLE IF NOT EXISTS "  + tableItems +
														"(Itname CHAR(80), " +
														"Rname CHAR(80), " +
														"price INT," +
														"Category CHAR(40)," +
														"Veg BOOLEAN," +
														"PRIMARY KEY (Itname, Rname)," +
														"FOREIGN KEY (Rname) REFERENCES " + tableRestaurants + "(Rname)," +
														"FOREIGN KEY (Category) REFERENCES " + tableCategories + "(CategoryName)" +
														");");
			st = con.createStatement();
			st.executeUpdate("CREATE TABLE IF NOT EXISTS "  + tableUsers +
														"(UserName CHAR(40) PRIMARY KEY, " +
														"UserType CHAR(40), " +
														"UserPassword CHAR(40) " + 	//perhaps provide a way to hide the information here as well(as the class)
														");");
			
			
		}
		
		
		catch (SQLException s){
			  System.out.println("SQL statement is not executed!");
			  }
		catch (Exception e){// for classNotFoundException when looking for driver
				e.printStackTrace();  
			}
	}
	
	public void readFromFilesRest() {
		
		try {
		
		reader = new BufferedReader(new FileReader("restaurants.txt"));//this reads from the restaurants.txt and assigns values into the relation
		String line = reader.readLine();
		
		while (line != null) {
			
				String[] tokens = line.split(delimiter);
				
			
					try {
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname,"root","admin");
						Statement st = con.createStatement();
						st.executeUpdate("INSERT IGNORE INTO " + tableRestaurants + " VALUES('" + tokens[0] + "','" + tokens[1] + "','" + tokens[2] + "','" + tokens[3] + "','" + tokens[4] + "','" + tokens[5]  + "','" + tokens[6] + "','" + tokens[7] + "'," + tokens[8]+ "," + tokens[9]  + ");");
						}
					catch (SQLException s){
						System.out.println("SQL statement is not executed restaurant!");
						}
					  
				line = reader.readLine();
			}
		reader.close();
		

		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void readFromFilesItem() {
		
		try {
			
		reader = new BufferedReader(new FileReader("items.txt"));//this reads from the items.txt and assigns values into the relation
		String line = reader.readLine();
			while (line != null) {
			
				String[] tokens = line.split(delimiter);
			
		
					try {
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname,"root","admin");
						Statement st = con.createStatement();
						st.executeUpdate("INSERT IGNORE INTO " + tableItems + " VALUES('" + tokens[0] + "','" + tokens[1] + "'," + tokens[2] + ",'" + tokens[3] + "'," + tokens[4] + ");");
						
					}
					catch (SQLException s){
						System.out.println("SQL statement is not executed item!");
						}
				  
					line = reader.readLine();
			}
		
			reader.close();
			
}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readFromFilesCat(){
		
		try {
			
		reader = new BufferedReader(new FileReader("categories.txt"));//this reads from the items.txt and assigns values into the relation
		String line = reader.readLine();
			while (line != null) {
			
				String[] tokens = line.split(delimiter);
			
		
					try {
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname,"root","admin");
						Statement st = con.createStatement();
						st.executeUpdate("INSERT IGNORE INTO " + tableCategories + " VALUES('" + tokens[0] + "','" + tokens[1] + "');");
		
					}
					catch (SQLException s){
						System.out.println("SQL statement is not executed cat!");
						}
					
				  
					line = reader.readLine();
			}
		
			reader.close();
			
}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
public void readFromFilesUser(){
		
		try {
			
		reader = new BufferedReader(new FileReader("users.txt"));//this reads from the items.txt and assigns values into the relation
		String line = reader.readLine();
			while (line != null) {
			
				String[] tokens = line.split(delimiter);
			
		
					try {
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname,"root","admin");
						Statement st = con.createStatement();
						st.executeUpdate("INSERT IGNORE INTO " + tableUsers + " VALUES('" + tokens[0] + "','" + tokens[1] + "','" + tokens[2] + "');");
		
					}
					catch (SQLException s){
						System.out.println("SQL statement is not executed user!");
						}
				  
					line = reader.readLine();
			}
		
			reader.close();
			
}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}


public void query(){
	
	try {
		
		System.out.println("What/Where do you want to eat?");
		reader = new BufferedReader (new InputStreamReader(System.in));
		String line = reader.readLine();
		restaurantTmp = Restaurant.restaurantsList();
		itemTmp = Item.itemsList();
		categoryTmp = Category.categoriesList();
		
			if (line != null) {
			
				
				String[] tokens = line.split("\\s");
				//System.out.println(Arrays.asList(tokens));
				int i = 0; 
				
				while(i < tokens.length){
				
					for (Restaurant r : restaurantTmp){
						
						if (r.getRname().equals(tokens[i]) || tokens[i].toLowerCase().startsWith(r.getRname().substring(0,4))){
							
							System.out.println("You want to eat at " + r.getRname() + "! That's a good choice! You can find the restaurant at " + r.getAddress());
							//create arrayList in which to place the results
						}//straight to the menu page
					
					}
					
					for (Item it : itemTmp){
						
						if (it.getItname().equals(tokens[i]) || tokens[i].toLowerCase().startsWith(it.getItname().substring(0,3))){
							
							System.out.println("You want to eat " + it.getItname() + "! That's a good choice! You can find " + it.getItname() + " in the restaurant " + it.getRname());
							//create arrayList in which to place the results
						}//to the catalogue of the restaurants(with the map)
					
					}
					
					for (Category c : categoryTmp){
						
						if (c.getCategoryName().equals(tokens[i]) || tokens[i].toLowerCase().startsWith(c.getCategoryName().substring(0,3))){
							
							tmp1 = "You want to eat " + c.getCategoryName() + "! That's a good choice! You can find " + c.getCategoryName() + " in the restaurant " + c.getRname();
							System.out.println((tmp1.equals(tmp2)) ? "" : tmp1);
							tmp2 = "You want to eat " + c.getCategoryName() + "! That's a good choice! You can find " + c.getCategoryName() + " in the restaurant " + c.getRname();
							
							//create arrayList in which to place the results
						}//to the catalogue of the restaurants(with the map)
					
					}
					
					
					i++;
				}
			}
		
			reader.close();
			
}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

public static String getDatabaseName(){
	return dbname;
}

}
