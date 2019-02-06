package helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import address_book.ManageBackend;
import domain.Address;
import domain.Backend;

public class FileBackendHelper implements BackendHelper {
	ManageBackend superParent;
	Backend currentBackend;
	private ArrayList<Address> addressList;
	private FileOutputStream file;
	private ObjectOutputStream out;
	private FileInputStream fileInputStream;
	private ObjectInputStream objectInputStream;
	private BackendHelper backendHelper=null;
	private Address address;
	private Scanner scanner=null;
	public FileBackendHelper(ManageBackend superParent) {

		this.superParent=superParent;
		currentBackend=superParent.getCurrentBackend();
		addressList=new ArrayList<Address>();
		address=new Address();
		scanner=new Scanner(System.in);
		load();
	}

	public void create(){
		System.out.println("Enter The Detaiils To Create Address :");

		Address addressTemp=new Address();

		System.out.println("Enter The Name :");

		addressTemp.setName(scanner.next());
		System.out.println("Enter The Email :");

		addressTemp.setEmail(scanner.next());
		System.out.println("Enter The PhoneNumber :");

		addressTemp.setPhoneNumber(scanner.nextInt());
		addressList.add(addressTemp);
		save();


		System.out.println(" Created Address..........!!!!!!!!!!!!!!");

	}

	public void read(){
		System.out.println("Enter The Detaiils To Read Address :");

		System.out.println("Enter The Name :");
		String name=scanner.next();
		for(Address addressLoop:addressList)
		{
			if(name.equals(addressLoop.getName()))
			{
				System.out.println(addressLoop.getEmail());

				System.out.println(addressLoop.getPhoneNumber());
			}
		}

		System.out.println("Address Read Successfully..........!!!!!!!!!!!!!!");

	}

	public void update(){
		System.out.println("Enter The Details To Update Address :");


		System.out.println("Enter The Name :");

		String name=scanner.next();
		for(Address addressLoop:addressList){
			if(name.equals(addressLoop.getName())){
				System.out.println("Enter The Email :");

				addressLoop.setEmail(scanner.next());
				System.out.println("Enter The PhoneNumber :");

				addressLoop.setPhoneNumber(scanner.nextInt());
			}
		}
		save();

		System.out.println("Address Updated Successfully..........!!!!!!!!!!!!!!");
	}

	public void delete(){

		System.out.println("Enter The Details To Delete Address :");

		System.out.println("Enter The Name :");

		String name=scanner.next();
		Address addressLoopTemp=null;
		for(Address addressLoop:addressList)
		{
			if(name.equals(addressLoop.getName()))
			{
				addressLoopTemp=addressLoop;
			}
		}
		addressList.remove(addressLoopTemp);
		save();
		System.out.println("Address Deleted Successfully..........!!!!!!!!!!!!!!");

	}
	public void load()
	{
		try {
			fileInputStream = new FileInputStream(superParent.getCurrentBackend().toString());
			objectInputStream= new ObjectInputStream(fileInputStream);
			try {
				addressList=(ArrayList<Address>)objectInputStream.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	public void save(){
		try {
			file=new FileOutputStream(superParent.getCurrentBackend().toString());
			out=new ObjectOutputStream(file);
			out.writeObject(addressList);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
