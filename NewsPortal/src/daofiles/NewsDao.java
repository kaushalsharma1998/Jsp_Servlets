
package daofiles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.NewsBean;

import dba.ConnectionProvider;

public class NewsDao {

	  public static int save( NewsBean ab)
	  {
	  int status=0;  
      try{  
          Connection con=ConnectionProvider.getConnection();   
          java.sql.PreparedStatement ps=con.prepareStatement("insert into news(headline,description,category,rid) values(?,?,?,?)");  
          
          ps.setString(1,ab.getheadline()); 
          ps.setString(2,ab.getDescription());
          ps.setString(3,ab.getCategory());
          ps.setInt(4, ab.getReporterid());
                    status=ps.executeUpdate();  
            
          con.close();  
      }catch(Exception ex)
      {ex.printStackTrace();}  
        
      return status;  
  }  
	
	  public static int update(NewsBean db)
	  {
		  int status=0;  
	      try{  
	          Connection con=ConnectionProvider.getConnection();   
	          java.sql.PreparedStatement ps=con.prepareStatement("update into news(headline,description) values(?,?) where id=?");  
	          
	          ps.setString(1,db.getheadline()); 
	          ps.setString(2,db.getDescription());
	          ps.setInt(3, db.getId());
           status=ps.executeUpdate();  
	            
	          con.close();  
	      }catch(Exception ex)
	      {ex.printStackTrace();}  
	        
	      return status;  
	  }
	  
	  public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=ConnectionProvider.getConnection();  
	            java.sql.PreparedStatement ps=con.prepareStatement("delete from news where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    } 
	  
	  public static ArrayList<NewsBean> getNewsByRid(int rid)
		 {
		 	ArrayList<NewsBean> list=new ArrayList<>();
		
		 	try {
		 		Connection con=ConnectionProvider.getConnection();
		 		java.sql.PreparedStatement ps=con.prepareStatement("select * from news where rid=? order by id");
		 		ps.setInt(1,rid);
		 		ResultSet rs=ps.executeQuery();
		 		while (rs.next()) {
		 			NewsBean app=new NewsBean();
		 				app.setId(rs.getInt(1));
		 			  	app.setHeadline(rs.getString(2));  
		                app.setDescription(rs.getString(3));  
		                app.setCategory(rs.getString(4));
		               
		 			list.add(app);
		 		}
		 	} catch (Exception e) {
		 		e.printStackTrace();
		 	}
		 	return list;
		 }
	  public static ArrayList<NewsBean> getNewsByCategory(String category)
		 {
		 	ArrayList<NewsBean> list=new ArrayList<>();
		 	try {
		 		Connection con=ConnectionProvider.getConnection();
		 		java.sql.PreparedStatement ps=con.prepareStatement("select * from news where  category=? order by id");
		 		ps.setString(1,category);
		 		ResultSet rs=ps.executeQuery();
		 		while (rs.next()) {
		 			NewsBean app=new NewsBean();
		 				app.setId(rs.getInt(1));
		 			  	app.setHeadline(rs.getString(2));  
		                app.setDescription(rs.getString(3));  
		                app.setCategory(rs.getString(4));
		               
		 			list.add(app);
		 		}
		 	} catch (Exception e) {
		 		e.printStackTrace();
		 	}
		 	return list;
		 }
	  public static NewsBean getNewsById(int id)
		 {
		  NewsBean app=new NewsBean();  
          
	        try{  
	            Connection con=ConnectionProvider.getConnection();  
	            java.sql.PreparedStatement ps=con.prepareStatement("select * from news where id=?");  
	            ps.setInt(1,id);  
	            
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	 				app.setId(rs.getInt(1));
	 			  	app.setHeadline(rs.getString(2));  
	                app.setDescription(rs.getString(3));  
	                app.setCategory(rs.getString(4));

	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return app;
		 }	  

}


