package jani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author kappa iO
 *
 */
public class User {

	//for testing purposes currently, this will be updated to work with queries
	
	private String userName, type, password;
	private static ArrayList<User> userList = new ArrayList<User>();
	private static Connection con;
	private static Scanner input;
	private static String tmp = "";
	public User(){
		
		userName = "User Name";
		type = "Type";
		password = "password";
	}


	public User(String u, String t, String p){
	
		userName = u;
		type = t;
		password = p;
	
	}

	public static ArrayList<User> usersList() {
	
		try{
	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + Database.getDatabaseName(),"root","admin");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM users");
			
				while(rs.next()){//this check MUST be performed
					
				User u = new User(rs.getString(1), rs.getString(2), rs.getString(3)); 
				userList.add(u);
			
					}	
		}
		catch (SQLException s){
			s.getSQLState();
			s.getErrorCode();
			s.printStackTrace();
			System.out.print("error");
			}
	//to test if the arraylist fills up
	//for (User c : userList){
		
	//	System.out.println(c.getUserName() + " " + c.getType() + " " + c.getPassword());
		
		
	//}
		return userList;
	
		}
	
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
	public String getUserName() {
		return userName; 
	}
	public String getType() {
		return type; 
	}
	public String getPassword() {//the modifier for this might have to change, access to password should be limited
		return password; 
	}
	
	public static void verifyUser(){
		//perhaps set a flag to signify user access
		input = new Scanner(System.in);
		System.out.println("Please enter username:");
		String un = input.nextLine();
		System.out.println("Please enter password:");
		String pw = input.nextLine();
		
		for (User usr : usersList()){
			
			if (usr.getUserName().equals(un)){
				
				if (usr.getPassword().equals(pw)){
					tmp = "Welcome, " + usr.getUserName();
					System.out.println(tmp);
				}
				
			}
			
		}
		
			if (tmp.equals("")){
				System.out.println("Invalid User Name or Password. Please try again.");
				verifyUser();
			}
			
		
		
		input.close();
		
	}
}
