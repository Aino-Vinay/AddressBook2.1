package action;

public class ExitAction implements Action {

	public void perform() {
		System.out.println(" ");

		System.out.println("Closing The Application.................!!!!!!!!!!!!!!!!!!");
		
		System.out.println("Application Closed");

		System.exit(0);
	}

}
