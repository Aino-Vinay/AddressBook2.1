package crud;

import action.Action;
import action.ManageBackendAction;
import menu.MenuItem;

public class CreateAction implements Action {

	
	ManageBackendAction superParent;
	public CreateAction(ManageBackendAction superParent) {
		this.superParent=superParent;
	}

	public void perform() {
		superParent.getBackendHelper().create();
	}

}
