<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center" >
<form action="UpdatePasswordServlet" method="post">

login id:<input type="text" name="loginId" id="loginId"><br><br>

Old Password:<input type="password" name="oldPassword" id="oldPassword"><br><br>

New Password:<input type="password" name="newPassword" id="newPassword"><br><br>

<input type="submit" name="submit" >

</form>
</body>
</html>