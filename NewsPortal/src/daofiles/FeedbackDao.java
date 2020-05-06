package daofiles;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.FeedbackBean;
import dba.ConnectionProvider;
	
public class FeedbackDao {

	 public static int save(FeedbackBean fb){  
	        int status=0;  
	        try{  
	            Connection con=ConnectionProvider.getConnection();  
	            java.sql.PreparedStatement ps=con.prepareStatement("insert into feedback(name,email,contact,suggestion,rating) values(?,?,?,?,?)");  
	            
	            ps.setString(1,fb.getName()); 
	            ps.setString(2,fb.getEmail());
	            ps.setString(3,fb.getContact());     
	            ps.setString(4,fb.getSuggestion());  
	            
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex)
	        	{
	        	ex.printStackTrace();
	        	}  
	          
	        return status;  
	    }  
	 
	  public static List<FeedbackBean> getfeedback(){  
	        List<FeedbackBean> list=new ArrayList<FeedbackBean>();  
	          
	        try{  
	            Connection con=ConnectionProvider.getConnection();  
	            java.sql.PreparedStatement ps=con.prepareStatement("select * from feedback ORDER BY name");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	            	FeedbackBean fb=new FeedbackBean();  
	                fb.setName(rs.getString(1));  
	                fb.setEmail(rs.getString(2));
 			        fb.setContact(rs.getString(3));
 			        fb.setSuggestion(rs.getString(4));
 			        fb.setRating(rs.getString(5));
	                list.add(fb);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  

}