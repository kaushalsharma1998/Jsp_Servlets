package dao;

import java.sql.*;


import dbconfig.DBconnection;

public class Logindao {


public static boolean validate(String name,String password)
{   
	boolean status=false;
	{
			try
	{
		Connection con= DBconnection.getConn();
		java.sql.PreparedStatement stmt=con.prepareStatement("select * from accinfo where npass=? and nname=?");
		stmt.setString(1,password);
		stmt.setString(2,name);
	 ResultSet rs= stmt.executeQuery();
	 status= rs.next();
	}
	 catch (Exception e)
	{ System.err.println(e);}
} 
 return status;
}
}