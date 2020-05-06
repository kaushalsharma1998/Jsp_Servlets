

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconfig.DBconnection;

@WebServlet("/Adduser")
public class Adduser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("nname");
		String password=request.getParameter("npass");
		 
		 int rs = 0;
		Connection con= DBconnection.getConn();
		 try
		 {
		
			 java.sql.PreparedStatement stmt=con.prepareStatement("Insert into accinfo values (?,?)" );
		 
		stmt.setString(1,name);
		stmt.setString(2,password);
		
		rs = stmt.executeUpdate();
		 

		 }  catch (Exception e)
			{ System.err.println(e);}
		if(rs>0)
		 {   out.print("User successfully added ");
			 out.print("Welcome"+" "+name);
			
		 }
		 else
		 {
			 out.print("exit"+" "+name);
		 }
		
		}

		
		
}	
		
		