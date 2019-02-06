package action;

import menu.Menu;
import menu.MenuItem;

public class AddBackendAction implements Action{
	Menu addBackendMenu=null;
	public AddBackendAction(Menu addBackendMenu,ManageBackendAction superParent,Menu menuobjectBack) {
		this.addBackendMenu=addBackendMenu;
		
		
		
		MenuItem addBackendFileSystem=new MenuItem(1,"File System");
		addBackendFileSystem.setAction(new AddBackendFileAction(addBackendMenu,superParent));		
		addBackendMenu.addMenuItemList(addBackendFileSystem);
		
		
		MenuItem addBackendDatabase=new MenuItem(2,"Database Backend");
		addBackendDatabase.setAction(new AddBackendDatabaseAction(addBackendMenu,superParent));		
		addBackendMenu.addMenuItemList(addBackendDatabase);
		
		MenuItem goBack=new MenuItem(3,"Go Back");
		goBack.setAction(new GoBackAction(menuobjectBack));		
		addBackendMenu.addMenuItemList(goBack);
		
		
		
		MenuItem exit=new MenuItem(4,"Exit");
		exit.setAction(new ExitAction());
		addBackendMenu.addMenuItemList(exit);
		



	}
	public void perform() {
		
	}
}
