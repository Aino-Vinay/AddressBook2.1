package crud;

import action.Action;
import action.ManageBackendAction;
import menu.MenuItem;

public class UpdateAction implements Action {

	
	ManageBackendAction superParent;
	public UpdateAction(ManageBackendAction superParent) {
		this.superParent=superParent;
	}

	public void perform() {
		superParent.getBackendHelper().update();
	}

}
