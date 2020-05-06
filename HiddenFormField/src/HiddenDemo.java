

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HiddenDemo
 */
@WebServlet("/HiddenDemo")
public class HiddenDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HiddenDemo() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	response.setContentType("text/html");
	PrintWriter out =response.getWriter();
	String name = request.getParameter("uname");
	//out.print(name); 
	out.print("<form action='View_Data' method='post'>");  
     out.print("<input type='hidden' name='pname' value='"+name+"'>");  
     out.print("<input type='submit' value='go'>");  
     out.print("</form>");  	
	
	}

}
