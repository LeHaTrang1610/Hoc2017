

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("txtName");
		String password = request.getParameter("txtPassword");

		HttpSession session = request.getSession(true);// tao mot session

		String message = "User name or password is invalid";
		String userID ="No ID in there";
		boolean isLogined = false;

		if (userName.equals("admin") && password.equals("123")) {
			isLogined = true;
			message = "Login thanh cong";
			userID=userName +"01";

		}
		request.setAttribute("message", message);
		session.setAttribute("isLogined", isLogined);
		request.setAttribute("userID", userID);
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

}
