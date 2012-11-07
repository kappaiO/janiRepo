package jani;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.*;

public class Database {
	
	
	private Connection con = null;
	private Statement st;
	private String dbname = "project", tableRestaurants = "restaurants", tableItems = "items", delimiter = "#";
	private BufferedReader reader;
	
	public void CreateDbAndTables() {
		
		try{
	
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
														"PicLink CHAR(80));");
		
			st = con.createStatement();
			st.executeUpdate("CREATE TABLE IF NOT EXISTS "  + tableItems +
														"(Itname CHAR(80), " +
														"Rname CHAR(80), " +
														"price INT," +
														"Category CHAR(40)," +
														"Veg BOOLEAN," +
														"PRIMARY KEY (Itname, Rname)," +
														"FOREIGN KEY (Rname) REFERENCES " + tableRestaurants + "(Rname));");
														
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
						st.executeUpdate("INSERT IGNORE INTO " + tableRestaurants + " VALUES('" + tokens[0] + "','" + tokens[1] + "','" + tokens[2] + "','" + tokens[3] + "','" + tokens[4] + "','" + tokens[5] + "');");
						}
					catch (SQLException s){
						System.out.println("SQL statement is not executed1!");
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
						System.out.println("dddd");
					}
					catch (SQLException s){
						System.out.println("SQL statement is not executed2!");
						}
				  
					line = reader.readLine();
			}
		
			reader.close();
			
}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
