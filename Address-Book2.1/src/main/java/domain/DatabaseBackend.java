package domain;

public class DatabaseBackend implements Backend {

	String ipAddress;
	String portNumber;
	String databaseName;
	String userName;
	String password;
	
	public DatabaseBackend(String ipAddress,String portNumber,String databaseName,String userName,String password)
	{
		this.ipAddress=ipAddress;
		this.portNumber=portNumber;
		this.databaseName=databaseName;
		this.userName=userName;
		this.password=password;
	}
	
	
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}
	public String getDatabaseName() {
		return databaseName;
	}
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String toString(){
		return ipAddress+" "+portNumber+" "+databaseName+" "+userName+" "+password;
	}
}
