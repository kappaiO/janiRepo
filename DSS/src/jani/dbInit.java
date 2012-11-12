package jani;

/**
 * @author kappa iO
 *
 */
public class dbInit {
	
	public static void main (String[] args){

		Database db = new Database();
		db.CreateDbAndTables();
		db.readFromFilesRest();//the calling to the table insertion has to occur in the correct sequence. This is because of foreign keys
		db.readFromFilesCat();
		db.readFromFilesItem();
		db.readFromFilesUser();
		//Restaurant.restaurantsList();tests
		//Item.itemsList();
		//Category.categoriesList();
		//User.usersList();
		//User.verifyUser();
		db.query();


		}
	
}
