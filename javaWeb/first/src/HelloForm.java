import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloForm
 */
public class HelloForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String title = "Using GET mothod to Read Form Data";
		out.println("<h1>" + title + "</h1>" + "<h2>First Name: "
				+ request.getParameter("first_name") + "</h2>\n"
				+ "<h2>Last Name: " + request.getParameter("last_name")
				+ "</h2>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		 String title = "Using POST Method to Read Form Data";
	      out.println("<h1>"+title+"</h1>"
	      		+ "<h2>Name: "+ request.getParameter("car_name") + "</h2>\n" 
	    		+ "<h2>Price: "+ request.getParameter("car_price") + "</h2>");

	}
}
