package jani;

public class dbInit {
	
	public static void main (String[] args){

		Database db = new Database();
		db.CreateDbAndTables();
		db.readFromFilesRest();
		db.readFromFilesItem();
		}

}
