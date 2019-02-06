package crud;

import action.Action;
import action.ManageBackendAction;
import menu.MenuItem;

public class ReadAction implements Action {

	
	ManageBackendAction superParent;
	public ReadAction(ManageBackendAction superParent) {
		this.superParent=superParent;
	}

	public void perform() {
		superParent.getBackendHelper().read();
	}

}
