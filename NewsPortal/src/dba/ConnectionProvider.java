package dba;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	public static Connection getConnection()
	{
		Connection con=null;
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/appoint","root","tanvi@123");
		System.out.print("connected");
	}
	catch (Exception e)
	{
		System.out.println("Error"+e);
	}
	return con;
	
	}
public static void main(String args[])
{getConnection();}
}
