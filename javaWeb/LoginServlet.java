package com.vitech.servlettutorial.login;

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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("txtName");
		String password = request.getParameter("txtPassword");
		
		HttpSession session = request.getSession(true);
		
		String message = "User name or password is invalid";
		boolean isLogined = false;
		
		if(userName.equals("nhut") && password.equals("123")){			
			isLogined = true;
			message = "Nguyen Cao Minh Nhut";
		}
		request.setAttribute("message", message);
		session.setAttribute("isLogined", isLogined);
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

}
