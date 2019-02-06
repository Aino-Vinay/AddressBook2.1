package action;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;

import domain.*;
import helper.BackendHelper;
import menu.Menu;
import menu.MenuItem;

import java.io.*;
public class ManageBackendAction implements Action  {

	public Menu menuObjectBack=null;
	private FileOutputStream file;
	private ObjectOutputStream out;
	private FileInputStream fileInputStream;
	private ObjectInputStream objectInputStream;
	 private Backend currentBackend=null;
	 private BackendHelper backendHelper=null;
	private ArrayList<Backend> backendList=new ArrayList<Backend>();
	public ArrayList<Backend> getBackendList() {
		return backendList;
	}

	public void setBackendList(ArrayList<Backend> backendList) {
		this.backendList = backendList;
	}

	Menu manageBackendMenu=null;
	public Menu getManageBackendMenu() {
		return manageBackendMenu;
	}



	public void setManageBackendMenu(Menu manageBackendMenu) {
		this.manageBackendMenu = manageBackendMenu;
	}



	public ManageBackendAction(Menu menuObject) {
		this.menuObjectBack=menuObject;
		load();

		Menu addBackendMenu=new Menu(1,"Add Backend");
		addBackendMenu.setAction(new AddBackendAction(addBackendMenu,this,this.menuObjectBack));
		menuObject.addMenuItemList(addBackendMenu);


		Menu selectBackendMenu=new Menu(2,"Select Backend");
		selectBackendMenu.setAction(new SelectBackendAction(selectBackendMenu,this,this.menuObjectBack));
		menuObject.addMenuItemList(selectBackendMenu);


		MenuItem listBackend=new MenuItem(3,"List Backend");
		listBackend.setAction(new ListBackendAction(this));
		menuObject.addMenuItemList(listBackend);


		MenuItem removeBackend=new MenuItem(4,"Remove Backend");
		removeBackend.setAction(new RemoveBackendAction(this));
		menuObject.addMenuItemList(removeBackend);

		MenuItem exit=new MenuItem(5,"Exit");
		exit.setAction(new ExitAction());
		menuObject.addMenuItemList(exit);
		
		
	}

	public void addFiletoList(Backend backend)	{
		backendList.add(backend);
		save();
	}

	public void save(){
		try {
			file=new FileOutputStream("/home/intern1/Desktop/serialize1.ser");
			out=new ObjectOutputStream(file);
			out.writeObject(getBackendList());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void load()
	{
		try {
			fileInputStream = new FileInputStream("/home/intern1/Desktop/serialize1.ser");
			objectInputStream= new ObjectInputStream(fileInputStream);

			setBackendList((ArrayList<Backend>) objectInputStream.readObject());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {

			try {
				objectInputStream.close();
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}





	public void perform() {
		
		
	}


	public void displayList(){
		int i=1;

		for(Backend list : getBackendList()){
			if(list instanceof FileBackend ){
				System.out.println(i+". File Backend : "+list);
			}
				else if(list instanceof DatabaseBackend){

					System.out.println(i+". Database Backend : "+list);
				}
			i++;
		}

	}
	
	public void removeBackend(int choice){
		backendList.remove(choice);
		save();
			System.out.println("Backend Removed Successfully..............!!!!!!!!!!!!!!!!!!!");
	}

	public Backend getCurrentBackend() {
		return currentBackend;
	}

	public void setCurrentBackend(Backend currentBackend) {
		this.currentBackend = currentBackend;
	}

	public BackendHelper getBackendHelper() {
		return backendHelper;
	}

	public void setBackendHelper(BackendHelper backendHelper) {
		this.backendHelper = backendHelper;
	}
	
}
