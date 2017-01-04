

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName = request.getParameter("txtName");
		String password = request.getParameter("txtPassword");
	
		HttpSession session = request.getSession(true);
			String message  = "User name or password is invalid";
			String userID   = "No Id in there" ;
			boolean isLogined = false;
			
			if(userName.equals("admin") && password.equals("123")){
				isLogined = true;
				message = "Login thanh cong";
				userID =userID +"01";
			}
			
			request.setAttribute("message", message);
			session.setAttribute("isLogined", isLogined);
			request.setAttribute("userId", userID);
			request.getRequestDispatcher("Login.jps").forward(request, response);
			
		
	}

}
