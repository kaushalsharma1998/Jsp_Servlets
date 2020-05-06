

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

@WebServlet("/Add_Detail")
public class Add_Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		long id=Long.parseLong(request.getParameter("id"));
		long phn= Long.parseLong(request.getParameter("contactno"));
		 int rs = 0;
		 HttpSession session=request.getSession(false);
		 String user=(String)session.getAttribute("username");
		 session.setAttribute("pname",name);
		 session.setAttribute("pgender",gender);
		 session.setAttribute("pphn",phn);
		 out.println(user);
		 try
		 {
		
			 Connection con= DBconnection.getConn();
			 java.sql.PreparedStatement stmt=con.prepareStatement("Insert into student values (?,?,?,?,?)" );
		 
		stmt.setLong(1,id);
		stmt.setString(2,name);
		stmt.setString(3,gender);
		stmt.setLong(4, phn);
		stmt.setString(5,user);
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
