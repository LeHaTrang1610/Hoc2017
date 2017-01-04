

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloCheckbox
 */
public class HelloCheckbox extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		 PrintWriter out = response.getWriter();
		String title = "Reading checkbox Data";
		out.println("<h1>" +  title + "</h1>" + 
		"<ul>/n" +
		"<li><b> Maths Flag : </b>:"
		+ request.getParameter("maths")+ "\n"+
		" <li><b>Physics Flag : </b>: "
		+request.getParameter("physics")+ "\n"+
		" <li><b>Chemistry Flag : </b>: "
		+request.getParameter("chemistry")+ "\n" +
				"<ul>/n" +
				"</body></html>");
			
						
	
		
		
		
	}

}
