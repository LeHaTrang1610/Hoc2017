

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionExample
 */
public class SessionExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Create a session object if it is already not created
		HttpSession session = request.getSession(true);
		// Get session creation time.
		Date createTime = new Date(session.getCreationTime());
		//Get last access time of this web page
		Date lastAccessTime = new Date(session.getLastAccessedTime());
		
		String title = "Welcome back to my website";
		
		// cHECK IF THIS IS NEW COMER ON YOUR WEB PAGE.
		session.setAttribute("userID","ABC");
		session.setAttribute("FirstName","Trang");
		session.setAttribute("LastName","Nguyen");
		
		//Set respone content type
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		out.println("<h1>" + "title" + "</h1>\n" +
					"<h2>Session userID: " + session.getAttribute("userID") + "</h2>\n" +
					"<h2>Session FirstName: " + session.getAttribute("FirstName") + "</h2>\n" +
					"<h2>Session LastName: " + session.getAttribute("LastName") + "</h2>\n" +
					"<h2>Session time: " +createTime + "</h2>\n" +
					"<h2>Time of Last Access: " + lastAccessTime +"</h2>\n"
		);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		session.invalidate();
	}

}
