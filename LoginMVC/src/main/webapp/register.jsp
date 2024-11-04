<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<h2>
<% String error = (String) session.getAttribute("error");
if(error!=null){
	out.print(error);
	session.setAttribute("error", null);
	
}
%>
</h2>
<form method="post" action="registerServlet">
FirstName:<input type="text" name="firstname"><br>
LastName:<input type="text" name="lastname"><br>
UserName:<input type="text" name="username"><br>
Password:<input type="password" name="password"><br>
<input type="submit">
</form>
</body>
</html>