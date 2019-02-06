package crud;

import action.Action;
import action.ManageBackendAction;
import menu.MenuItem;

public class DeleteAction implements Action {

	
	ManageBackendAction superParent;
	public DeleteAction(ManageBackendAction superParent) {
		this.superParent=superParent;
	}

	public void perform() {
		superParent.getBackendHelper().delete();
	}

}
