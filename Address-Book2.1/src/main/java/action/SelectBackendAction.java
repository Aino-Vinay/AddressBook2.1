package action;

import java.util.Scanner;

import menu.Menu;
import menu.MenuItem;

public class SelectBackendAction implements Action {

	Menu selectBackendMenu;
	ManageBackendAction superParent;;
	public SelectBackendAction(Menu selectBackendMenu, ManageBackendAction manageBackendAction, Menu menuObject) {
		this.selectBackendMenu=selectBackendMenu;
		superParent=manageBackendAction;
		
		Menu selectBackendFileSystem=new Menu(1,"File System");
		selectBackendFileSystem.setAction(new SelectBackendFileAction(selectBackendFileSystem,superParent,selectBackendMenu));
		selectBackendMenu.addMenuItemList(selectBackendFileSystem);
		
		
		Menu selectBackendDatabase=new Menu(2,"Database Backend");
		selectBackendDatabase.setAction(new  SelectDatabaseBackendAction(selectBackendDatabase,superParent,selectBackendMenu));		
		selectBackendMenu.addMenuItemList(selectBackendDatabase);
		
		MenuItem goBack=new MenuItem(3,"Go Back");
		goBack.setAction(new GoBackAction(menuObject));		
		selectBackendMenu.addMenuItemList(goBack);
		
		MenuItem exit=new MenuItem(4,"Exit");
		exit.setAction(new ExitAction());
		selectBackendMenu.addMenuItemList(exit);
		
		
		
	}

	public void perform() {
		

	}

}
