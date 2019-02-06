package menu;

import java.util.ArrayList;
import java.util.Scanner;

import action.Action;
import action.AddBackendAction;
import action.SelectBackendAction;
import action.SelectBackendFileAction;
import action.SelectDatabaseBackendAction;

public class Menu extends MenuItem implements Action{

	private ArrayList<MenuItem> menuItemsList=null;
	private Scanner scanner=null;
	private int choice=-1;
	private String title;
	private Action action;
	public Action getAction() {
		return action;
	}





	public void setAction(Action action) {
		this.action = action;
	}





	public Menu(Action action) {
		super(action);
		this.title=name;
		menuItemsList=new ArrayList<MenuItem>();
		scanner=new Scanner(System.in);
		this.action=action;
	}





	public Menu(int i, String string) {
		super(i, string);
		this.title=name;
		menuItemsList=new ArrayList<MenuItem>();
		scanner=new Scanner(System.in);
	}





	@Override
	public void perform() {
		try {
			
			if(action instanceof SelectBackendFileAction || action instanceof SelectDatabaseBackendAction  ) {
				action.perform();
				do
				{
					displayTitleAndMenuItems();
					getInput();
					handleEvent();
				}while(true);
			}
				
			while(true){
			
			displayTitleAndMenuItems();

			getInput();

			handleEvent();
		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void displayTitleAndMenuItems(){
		try {
			System.out.println(title);
			for(int i=0;i<menuItemsList.size();i++)
			{
				System.out.println(menuItemsList.get(i));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getInput(){
		try {
			System.out.println("");

			System.out.println("Please Enter Your Choice :");
			choice=scanner.nextInt();
			System.out.println("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void handleEvent(){
		try {
			if(choice<1 || choice>menuItemsList.size()){
				System.out.println("");
				System.out.println("Invalid Choice....!!!!!!!!!!!!!");
				
			}
			
			for(int i=0;i<menuItemsList.size();i++){
				if(choice==menuItemsList.get(i).getId()){
					menuItemsList.get(i).perform();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	public void addMenuItemList(MenuItem menuItem){
		try {
			menuItemsList.add(menuItem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	


}
