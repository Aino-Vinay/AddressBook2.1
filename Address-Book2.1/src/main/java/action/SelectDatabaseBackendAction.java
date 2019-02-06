package action;

import java.util.ArrayList;
import java.util.Scanner;

import crud.CreateAction;
import crud.DeleteAction;
import crud.ReadAction;
import crud.UpdateAction;
import domain.Backend;
import domain.DatabaseBackend;
import domain.FileBackend;
import helper.DataBaseBackendHelper;
import helper.FileBackendHelper;
import menu.Menu;
import menu.MenuItem;

public class SelectDatabaseBackendAction implements Action {
	int choice=0;
	
	ArrayList<Backend> temporary;
	
	Menu selectBackendDatabase;
	ManageBackendAction superParent;
	public SelectDatabaseBackendAction(Menu selectBackendDatabase, ManageBackendAction superParent,Menu selectBackendMenu) {
		
	 this.superParent=superParent;
	 this.selectBackendDatabase=selectBackendDatabase;
	 	
		
		temporary=new ArrayList<Backend>();	 	
	 
	 	MenuItem create=new MenuItem(1,"Create");
	 	create.setAction(new CreateAction(superParent));		
	 	selectBackendDatabase.addMenuItemList(create);
		
		MenuItem read=new MenuItem(2,"Read");
	 	read.setAction(new ReadAction(superParent));		
	 	selectBackendDatabase.addMenuItemList(read);
		
		MenuItem update=new MenuItem(3,"Update");
	 	update.setAction(new UpdateAction(superParent));		
	 	selectBackendDatabase.addMenuItemList(update);
		
		MenuItem delete=new MenuItem(4,"Delete");
	 	delete.setAction(new DeleteAction(superParent));		
	 	selectBackendDatabase.addMenuItemList(delete);
		
		MenuItem goBack=new MenuItem(5,"Go Back");
		goBack.setAction(new GoBackAction(selectBackendMenu));		
		selectBackendDatabase.addMenuItemList(goBack);
		
		
		
		MenuItem exit=new MenuItem(6,"Exit");
		exit.setAction(new ExitAction());
		selectBackendDatabase.addMenuItemList(exit);
		
	
	 
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
				if(list instanceof DatabaseBackend)
				{
					System.out.println(++i+". Database : "+list);
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
			superParent.setBackendHelper(new DataBaseBackendHelper(superParent));
			System.out.println("");
			System.out.println("Current Backend Selected................!!!!!!!!!!!!!!!!!!!!!!!!");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
