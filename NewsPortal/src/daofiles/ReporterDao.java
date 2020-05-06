package daofiles;

import java.sql.*;
import java.util.*;

import beans.ReporterBean;
import dba.ConnectionProvider;

public class ReporterDao {

	public static boolean validate(String email,String password){  
		  boolean status=false;
	try {	
			Connection conn= ConnectionProvider.getConnection();
			java.sql.PreparedStatement ps=conn.prepareStatement("select * from reporters where email=? and password=?");
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
	
	 public static int save(ReporterBean db){  
	        int status=0;  
	        try{  
	            Connection con=ConnectionProvider.getConnection();  
	            java.sql.PreparedStatement ps=con.prepareStatement(  
	                         "insert into reporters(name,age,email,password,address,contact) values(?,?,?,?,?,?)");  
	            
	            ps.setString(1,db.getName()); 
	            ps.setInt(2,db.getAge());
	            ps.setString(3,db.getEmail());              
	            ps.setString(4,db.getPassword()); 
	            ps.setString(5,db.getAddress());
	            ps.setString(6,db.getContact());
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex)
	        {ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int update(ReporterBean db){  
	        int status=0;  
	        try{  
	            Connection con=ConnectionProvider.getConnection();  
	            java.sql.PreparedStatement ps=con.prepareStatement(  
	                         "update reporters set name=?,age=?,email=?,password=?,address=?,contact=? where id=?");  
	            ps.setString(1,db.getName());
	            ps.setInt(2,db.getAge());
	            ps.setString(3,db.getEmail());              
	            ps.setString(4,db.getPassword()); 
	            ps.setString(4,db.getAddress());
	            ps.setString(5,db.getContact());
	            ps.setInt(7,db.getId());  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=ConnectionProvider.getConnection();  
	            java.sql.PreparedStatement ps=con.prepareStatement("delete from reporters where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static ReporterBean getReporterById(int id){  
	        ReporterBean dbe=new ReporterBean();  
	          
	        try{  
	            Connection con=ConnectionProvider.getConnection();  
	            java.sql.PreparedStatement ps=con.prepareStatement("select * from reporters where id=?");  
	            ps.setInt(1,id);  
	            
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                dbe.setId(rs.getInt(1));  
	                dbe.setName(rs.getString(2));
	                dbe.setAge(rs.getInt(3));
	                dbe.setEmail(rs.getString(4));  
	                dbe.setPassword(rs.getString(5));
	                dbe.setAddress(rs.getString(6));  
	                dbe.setContact(rs.getString(7));
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return dbe;  
	    }  
	    public static List<ReporterBean> getAllReporters(){  
	        List<ReporterBean> list=new ArrayList<ReporterBean>();  
	          
	        try{  
	            Connection con=ConnectionProvider.getConnection();  
	            java.sql.PreparedStatement ps=con.prepareStatement("select * from reporters ORDER BY id");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                ReporterBean db=new ReporterBean();  
	                db.setId(rs.getInt(1));  
	                db.setName(rs.getString(2));
	                db.setAge(rs.getInt(3));
 	                db.setEmail(rs.getString(4));
   			        db.setPassword(rs.getString(5)); 	
	                db.setAddress(rs.getString(6));
    				db.setContact(rs.getString(7)); 	
	                list.add(db);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
	    
	    public static ReporterBean getReporterByEmail(String email){  
	        ReporterBean dbe=new ReporterBean();  
	          
	        try{  
	            Connection con=ConnectionProvider.getConnection();  
	            java.sql.PreparedStatement ps=con.prepareStatement("select * from reporters where email=?");  
	            ps.setString(1,email);  
	            
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                dbe.setId(rs.getInt(1));  
	                dbe.setName(rs.getString(2));
	                dbe.setAge(rs.getInt(3));
	                dbe.setEmail(rs.getString(4));  
	                dbe.setPassword(rs.getString(5));
	                dbe.setAddress(rs.getString(6));  
	                dbe.setContact(rs.getString(7));
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return dbe;  
	        
	    }  
	    
	    
	    
}
