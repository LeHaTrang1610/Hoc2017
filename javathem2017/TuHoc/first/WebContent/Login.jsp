<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		<input type="text" name="txtName" placehoder="UserName"> </br>
		<input type="password" name="txtPassword"></br>
		<input type="submit" value="Login">
	</form>
	<% 
	String message = (String)request.getAttribute("message");
	boolean isLogined =(Boolean)session.getAttribute("isLogined");
	String userIdkey =(String)request.getAttribute("userID");
	%>
	
	<%=message %>
	<br/>
	User login : <%=isLogined %>
	<br/>
	User id : 	<%=userIdkey %>
		<h3>User name: <c:out value="${message}"/></h3>
	<h3>Session User: <c:out value="${sessionScope.userID}"></c:out> </h3>
	<h3>Session Visted: <c:out value="${sessionScope.visitCount}"></c:out> </h3>
	</body>
	
	