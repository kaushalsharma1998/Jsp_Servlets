

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconfig.DBconnection;


@WebServlet("/View_Detail")
public class View_Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Connection con= DBconnection.getConn();
		
		 java.sql.PreparedStatement stmt=con.prepareStatement("select * from student where " );
		 
		 ResultSet rs= stmt.executeQuery();
		 out.println("<table border='1px'>"
		 		+ "<thead>"
		 		+ "<tr> "
		 		+ "<th width=50>ID</th> <th width=50>Name</th> <th width=50>Gender</th> <th width=50>Contact Number</th><th width=50>User Name</th>"
		 		+ "</tr>"
		 		+ "</thead>");
		 while(rs.next())
		 { 
		
		 out.println("<tbody>"+"<tr>"
          		+ "<td>"+rs.getLong(1)+"</td>"
		 		+ "<td>"+rs.getString(2)+"</td>"
		 		+ "<td>"+rs.getString(3)+"</td>"
		 		+ "<td>"+rs.getLong(4)+"</td>"
		 		+ "<td>"+rs.getString(5)+"</td>"
		 		+ "</tr>"
		 		+ "</tbody>"
		 		+ "</table>"
		 		);
		 }	        		 

			 }  catch (Exception e)
				{ System.err.println(e);}

	}

}
