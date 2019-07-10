<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body >
<form action="LoginController" method="get">

<table style="background-color:wheat;border="1";width="50%">
<tr>
<td>
User Name :
</td>
<td>
<input type ="text" name = "UserName">
</td>

</tr>
<tr>
<td>
Password:
</td>
<td>
<input type ="password" name = "password">
</td>

</tr>
<tr>
<td>
<input type="submit" value="Login"/>
</td></tr>
<tr>
<td colspan="2">Yet Not Registered!! <a href="Registration.jsp">Register Here</a></td>
 </tr>
 <tr>
<td colspan="2">Forget password <a href="ForgetPassword.jsp">Click Here</a></td>
 </tr>
</table>
</form>
</body>
</html>