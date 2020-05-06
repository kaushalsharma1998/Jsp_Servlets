

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Logindao;

@WebServlet("/Loginctrl")
public class Loginctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String name=request.getParameter("uname");
	String password=request.getParameter("upass");
 boolean check=Logindao.validate(name, password);
		 if(check==true)
		 {
			 out.print("Welcome "+name);
			 HttpSession session =request.getSession();
			 session.setAttribute("username",name);
			  out.print("<a href='Add_detail.html'>add details</a> ");
			 out.print("<a href='View_Detail'>view details</a> ");
			 out.print("<a href='Update_details.html'>update details</a> ");
		 }
		 else
		 {
			 out.print("Exit "+name);
		 }
		 			
		
	}
}
  

