package com.vitech.servlettutorial.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create a session object if it is already not created.
	      HttpSession session = request.getSession(true);
	      // Get session creation time.
	      Date createTime = new Date(session.getCreationTime());
	      // Get last access time of this web page.
	      Date lastAccessTime = new Date(session.getLastAccessedTime());

	      String title = "Welcome Back to my website";
	      Integer visitCount = new Integer(0);
	      String visitCountKey = new String("visitCount");
	      String userIDKey = new String("userID");
	      String userID = new String("ABCD");

	      // Check if this is new comer on your web page.
	      if (session.isNew()){
	         title = "Welcome to my website";
	         session.setAttribute(userIDKey, userID);
	      } else {
	         visitCount = (Integer)session.getAttribute(visitCountKey);
	         visitCount = visitCount + 1;
	         userID = (String)session.getAttribute(userIDKey);
	      }
	      session.setAttribute(visitCountKey,  visitCount);

	      // Set response content type
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();

	      out.println("<h1>" + title + "</h1>\n" +
	                "<h2>Session id: " + session.getId() + "</h2>\n" +
	                "<h2>Created time:" + createTime + "</h2>\n" +
	                "<h2>Time of Last Access: "+lastAccessTime+"</h2>\n" +
	                "<h2>User ID: "+userID+"</h2>\n" +
	                "<h2>Number of visits: "+visitCount+"</h2>\n");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.invalidate();
	}
}
