package action;

import menu.Menu;

public class GoBackAction implements Action {
	Menu menuObject;
	ManageBackendAction superParent;
	public GoBackAction(Menu menuObject) {
		this.menuObject=menuObject;
	}

	public void perform() {
		menuObject.perform();
	}

}
