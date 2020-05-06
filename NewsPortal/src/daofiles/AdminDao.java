package daofiles;

import java.sql.Connection;
import java.sql.ResultSet;

import dba.ConnectionProvider;

public class AdminDao {

	public static boolean validate(String email,String password){  
		  boolean status=false;
	try {	
			Connection conn=ConnectionProvider.getConnection();
			java.sql.PreparedStatement ps=conn.prepareStatement("select * from adminlogin where email=? and password=?");
		    ps.setString(1,email);  
		    ps.setString(2,password);  
		    	         
	        ResultSet rs=ps.executeQuery(); 
	        status=rs.next();
	    	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	return status;
	}
}