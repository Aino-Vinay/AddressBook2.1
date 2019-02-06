package action;

import java.util.Scanner;

public class RemoveBackendAction implements Action {

	ManageBackendAction superParent;
	int choice=-1;
	public RemoveBackendAction(ManageBackendAction manageBackendAction) {
		superParent=manageBackendAction;
	}

	public void perform() {
		superParent.displayList();
		takeChoice();
		removeBackend();
	}
	
	public void takeChoice(){
		try {
			System.out.println("");
			System.out.println("Enter The Backend Number To be Removed");

			Scanner scanner=new Scanner(System.in);
			choice=scanner.nextInt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void removeBackend(){
		superParent.removeBackend(--choice);
	
	}

}
