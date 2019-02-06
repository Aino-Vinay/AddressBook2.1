package action;

import java.util.ArrayList;
import java.util.Scanner;

import crud.CreateAction;
import crud.DeleteAction;
import crud.ReadAction;
import crud.UpdateAction;
import domain.Backend;
import domain.FileBackend;
import helper.FileBackendHelper;
import menu.Menu;
import menu.MenuItem;

public class SelectBackendFileAction implements Action {
	int choice=0;
	
	ArrayList<Backend> temporary;
	
	Menu selectBackendFileSystem;
	ManageBackendAction superParent;
	public SelectBackendFileAction(Menu selectBackendFileSystem, ManageBackendAction superParent,Menu selectBackendMenu) {
		
	 this.superParent=superParent;
	 this.selectBackendFileSystem=selectBackendFileSystem;
	 	
		
		temporary=new ArrayList<Backend>();	 	
	 
	 	MenuItem create=new MenuItem(1,"Create");
	 	create.setAction(new CreateAction(superParent));		
		selectBackendFileSystem.addMenuItemList(create);
		
		MenuItem read=new MenuItem(2,"Read");
	 	read.setAction(new ReadAction(superParent));		
		selectBackendFileSystem.addMenuItemList(read);
		
		MenuItem update=new MenuItem(3,"Update");
	 	update.setAction(new UpdateAction(superParent));		
		selectBackendFileSystem.addMenuItemList(update);
		
		MenuItem delete=new MenuItem(4,"Delete");
	 	delete.setAction(new DeleteAction(superParent));		
		selectBackendFileSystem.addMenuItemList(delete);
		
		MenuItem goBack=new MenuItem(5,"Go Back");
		goBack.setAction(new GoBackAction(selectBackendMenu));		
		selectBackendFileSystem.addMenuItemList(goBack);
		
		
		
		MenuItem exit=new MenuItem(6,"Exit");
		exit.setAction(new ExitAction());
		selectBackendFileSystem.addMenuItemList(exit);
		
	
	 
	}


	public void perform() {
		try {
			displayFileBackendList();
			takeChoice();
			setCurrentBackend();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	


	public void displayFileBackendList(){
		try {
			int i=0;
			for(Backend list : superParent.getBackendList()){
				if(list instanceof FileBackend)
				{
					System.out.println(++i+". FileBackend : "+list);
					temporary.add(list);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void takeChoice(){
		try {
			System.out.println("");
			System.out.println("Enter The Backend Number To be Selected");

			Scanner scanner=new Scanner(System.in);
			choice=scanner.nextInt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setCurrentBackend(){

		try {
			Backend currentBackend=temporary.get(--choice);
			superParent.setCurrentBackend(currentBackend);
			superParent.setBackendHelper(new FileBackendHelper(superParent));
			System.out.println("");
			System.out.println("Current Backend Selected................!!!!!!!!!!!!!!!!!!!!!!!!");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
