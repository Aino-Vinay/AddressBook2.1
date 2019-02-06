package action;

import menu.MenuItem;

public class ListBackendAction implements Action {
	
	
	ManageBackendAction superParent=null;
	public ListBackendAction(ManageBackendAction manageBackendAction) {
		superParent=manageBackendAction;
	}

	public void perform() {
		list();
	}
	public void list()
	{
		System.out.println("The List Of Backends Is:");

		System.out.println("");
		superParent.displayList();
		
		System.out.println("********************************************");
	}
}
