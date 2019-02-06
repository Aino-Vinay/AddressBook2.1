package action;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import domain.FileBackend;
import menu.Menu;

public class AddBackendFileAction implements Action {

	Scanner scanner;
	String path=null;
	FileOutputStream file=null;
	ObjectOutputStream out=null;
	Menu addBackMenu=null;
	ManageBackendAction superParent=null;
	public AddBackendFileAction(Menu addBackendMenu,ManageBackendAction superParent) {
		scanner=new Scanner(System.in);
		this.superParent=superParent;
	}

	public void perform() {
		addBackend();	
	}


	public void addBackend(){

		System.out.println("Enter The Path : ");
		String path=scanner.next();
		superParent.addFiletoList(new FileBackend(path));

	}

}
