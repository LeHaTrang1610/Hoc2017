<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="TinhTong" method="POST">
		<input type="text" name="input" placeholder="Enter number"> </br></br>
		<input type="submit" value="TinhToan">
	</form>
	<%
		Double ketqua1 = (Double)request.getAttribute("ketqua");
	%>
	<br/>
		ket qua   : <%=ketqua1%>
</body>
</html>