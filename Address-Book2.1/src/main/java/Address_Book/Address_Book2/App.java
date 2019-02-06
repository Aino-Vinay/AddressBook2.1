package Address_Book.Address_Book2;

import action.ManageBackendAction;
import menu.Menu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Application Starts........!!!!!!!!!!!!!!!");
    	System.out.println("Welcome to Address Book 2.1");
    	System.out.println();
    	Menu manageBackendMenu=new Menu(-1,"Manage Backend");
    	manageBackendMenu.setAction(new ManageBackendAction(manageBackendMenu));
    	
    	manageBackendMenu.perform();
    }
}
