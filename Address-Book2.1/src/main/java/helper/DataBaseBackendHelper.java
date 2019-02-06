package helper;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import action.ManageBackendAction;
import domain.Address;
import domain.Backend;

public class DataBaseBackendHelper implements BackendHelper {
	ManageBackendAction superParent;
	Backend currentBackend;
	Connection connectionObject=null;
	Statement statementObject=null;
	ResultSet resultSetObject=null;
	private BackendHelper backendHelper=null;
	private Address address;
	private Scanner scanner=null;
	public DataBaseBackendHelper(ManageBackendAction superParent) {

		this.superParent=superParent;
		currentBackend=superParent.getCurrentBackend();
		address=new Address();
		scanner=new Scanner(System.in);

		String configuration[]=getConfiguration();
		String url="jdbc:mysql://"+configuration[0]+":"+configuration[1]+"/"+configuration[2];
		String userName=configuration[3];
		String password=configuration[4];
		try{
			Class.forName("com.mysql.jdbc.Driver");

			connectionObject=DriverManager.getConnection(url,userName,password);
			statementObject=connectionObject.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}




	}

	public void create(){
		try {
			System.out.println("Enter The Detaiils To Create Address :");

			Address addressTemp=new Address();

			System.out.println("Enter The Name :");

			addressTemp.setName(scanner.next());
			System.out.println("Enter The Email :");

			addressTemp.setEmail(scanner.next());
			System.out.println("Enter The PhoneNumber :");

			addressTemp.setPhoneNumber(scanner.nextInt());



			statementObject.executeUpdate("insert into address_new values('"+addressTemp.getName()+"','"+addressTemp.getEmail()+"','"+addressTemp.getPhoneNumber()+"')");



			System.out.println(" Created Address..........!!!!!!!!!!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void read(){
		System.out.println("Enter The Details To Read Address :");
		System.out.println("Enter The Name To Read Details :");
		String name=scanner.next();
		Address addressObject=new Address();
		try {

			resultSetObject=statementObject.executeQuery("SELECT * FROM address_new WHERE name='"+name+"'");

			if(resultSetObject.next()){

				addressObject.setEmail(resultSetObject.getString("email"));

				addressObject.setPhoneNumber(resultSetObject.getInt("phone"));

			}//if
		} catch (SQLException e) {

			e.printStackTrace();
		}
		displayDetails(addressObject);
		System.out.println("Address Read Successfully..........!!!!!!!!!!!!!!");

	}

	public void displayDetails(Address addressTemp)
	{
		System.out.println("The Details are : ");

		System.out.println("The Email Is :"+addressTemp.getEmail());

		System.out.println("The PhoneNumber Is :"+addressTemp.getPhoneNumber());
	}



	public void update(){
		try {
			System.out.println("Enter The Details To Update Address :");


			Address addressTemp=new Address();

			System.out.println("Enter The Name :");

			addressTemp.setName(scanner.next());
			System.out.println("Enter The Email :");

			addressTemp.setEmail(scanner.next());
			System.out.println("Enter The PhoneNumber :");

			addressTemp.setPhoneNumber(scanner.nextInt());


			statementObject.executeUpdate(" update address_new set  email  ='"+addressTemp.getEmail()+"',phone='"+addressTemp.getPhoneNumber()+"' where name='"+addressTemp.getName()+"'");

			System.out.println("Address Updated Successfully..........!!!!!!!!!!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(){

		try {
			System.out.println("Enter The Details To Delete Address :");

			Address addressTemp=new Address();

			System.out.println("Enter The Name :");


			String name=scanner.next();

			statementObject.executeUpdate("DELETE FROM address_new where name='"+name+"'");

			System.out.println("Address Deleted Successfully..........!!!!!!!!!!!!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String[] getConfiguration(){
		String temp[]=currentBackend.toString().split(" ");
		System.out.println("Configurations Set Successfully");
		return temp;
	}



}
