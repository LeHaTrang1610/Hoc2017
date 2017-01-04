<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->
<!-- <%@ page session="true" %> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="POST">
		<input type="text" name="txtName" placeholder="Username"></br>
		<input type="password" name="txtPassword"></br>
		<input type="submit" value="Login">
	</form>
	
	<h1>Using pure jsp</h1>
	<h3>Hello 
		<%
			String message = (String) request.getAttribute("message");
			Boolean isLogined = (Boolean) session.getAttribute("isLogined");
			String userIdKey = (String) session.getAttribute("userID");
		%>
		<%=message%>
		<br/>
		User login: <%= isLogined %>
		<br/>
		User id: <%=userIdKey%>
	</h3>
	
	<!-- <h1>Using jstl</h1>
	<h3>User name: <c:out value="${message}"/></h3>
	<h3>Session User: <c:out value="${sessionScope.userID}"></c:out> </h3>
	<h3>Session Visted: <c:out value="${sessionScope.visitCount}"></c:out> </h3> -->
</body>
</html>