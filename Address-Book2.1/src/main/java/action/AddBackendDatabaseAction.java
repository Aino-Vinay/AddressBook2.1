package action;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import domain.DatabaseBackend;
import menu.Menu;

public class AddBackendDatabaseAction implements Action {

	Menu addBackendMenu;
	ManageBackendAction superParent;
	Scanner scanner;
	String path=null;
	FileOutputStream file=null;
	ObjectOutputStream out=null;

	public AddBackendDatabaseAction(Menu addBackendMenu, ManageBackendAction superParent) {
		this.addBackendMenu=addBackendMenu;
		this.superParent=superParent;
		scanner=new Scanner(System.in);
		
		
	}

	public void perform() {
		addBackend();

	}
	
	public void addBackend(){
	
		System.out.println("Enter The IP Address : ");
		String ip=scanner.next();
		
		System.out.println("Enter The Port Number : ");
		String portNumber=scanner.next();
		
		System.out.println("Enter The Database Name dataBaseName : ");
		String dbName=scanner.next();
		
		System.out.println("Enter The User Name : ");
		String userName=scanner.next();
		
		System.out.println("Enter Password : ");
		String password=scanner.next();
		
		
		superParent.addFiletoList(new DatabaseBackend(ip,portNumber,dbName,userName,password));
	}
	
	
	
	
	
	
	

}
