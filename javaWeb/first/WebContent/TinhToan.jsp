<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="TinhToan" method="POST">
		<input type="text" name="input1" placeholder="Enter number1"> </br></br>
		<input type="text" name="input2" placeholder="Enter number2"> </br></br>
		<input type="text" name="input3" placeholder="Enter number3"> </br></br>
		
		<input type="radio" name="pheptinh" value="Cong"> +  
		<input type="radio" name="pheptinh" value="Tru"> -   
		<input type="radio" name="pheptinh" value="Nhan">*
		<input type="radio" name="pheptinh" value="Chia">/  <br><br>		
		<input type="submit" value="ketqua">
		
		<%
		Double ketqua1 = (Double)request.getAttribute("ketqua");
		%>
			<br/>
		ket qua   : <%=ketqua1%>
	</form>
</body>
</html>