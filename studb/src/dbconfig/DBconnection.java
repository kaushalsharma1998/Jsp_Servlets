package dbconfig;

import java.sql.*;

public class DBconnection {
	static Connection conn;
	public static Connection getConn()
	{
		try
		{
	    Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","tanvi@123");
		System.out.println("Connected..");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
     	}
	
	
}