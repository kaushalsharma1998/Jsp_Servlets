

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbconfig.DBconnection;

/**
 * Servlet implementation class Update_Detail
 */
@WebServlet("/Update_Detail")
public class Update_Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		long id=Long.parseLong(request.getParameter("id"));
		long phn= 0;
		 
		int rs = 0;
		 HttpSession session=request.getSession(false);
		 String user=(String)session.getAttribute("username");
		 out.println(user);
		 if (name==null)
		 {name=(String)session.getAttribute("pname");}
		 if (gender==null) 
				 {  gender=(String)session.getAttribute("pgender");}
				 
		 if ((request.getParameter("contactno"))==null) 
		 {  phn=(long)session.getAttribute("pphn");}
		 else
		 { phn= Long.parseLong(request.getParameter("contactno"));}
		 try
		 {
		
			 Connection con= DBconnection.getConn();
			 java.sql.PreparedStatement stmt=con.prepareStatement("Update  student set  sname=? , gender =? , contact=? where id=? and username=?" );
		 
		 stmt.setLong(4,id);
		stmt.setString(1,name);
		stmt.setString(2,gender);
		stmt.setLong(3, phn);
		stmt.setString(5, user);
		rs = stmt.executeUpdate();
		 

		 }  catch (Exception e)
			{ System.err.println(e);}

		
		 if(rs>0)
		 {   out.print("info successfully added ");
			 out.print("thanks"+" "+name);
		 }
		 else
		 {
			 out.print("failed  , sorry "+"   "+name);
		 }
		
		
		
	}

	

}
