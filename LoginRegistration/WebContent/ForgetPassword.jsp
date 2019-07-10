<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forget password </title>
</head>
<body>
<form action="ForgetPasswordController" method="post">
<table>
<th>Forget password </th>
<tr>
<td>Enter your EmailId</td>
<td><input type="text" name="email" required/></td>
</tr>
<tr>
<td><input type="submit" name ="submit"/></td>
</tr>
</table>
</form>
</body>
</html>