<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
<form action="RegistrationController1" method="get">
 <h1>Registration Page</h1>
 <div>
 <table style="background-color:wheat;border="1">
 <thead>Registration Form</thead>
 <tr>
 <td>
First Name :
 </td>
  <td>
 <input type ="text" name ="FirstName" required/>
 </td>
 </tr>
 <tr>
 <td>
Last Name :
 </td>
  <td>
 <input type ="text" name ="LastName" required/>
 </td>
 </tr>
 
 <tr>
 <td>
User Name :
 </td>
  <td>
 <input type ="text" name ="UserName" required/>
 </td>
 </tr>
 <tr>
 <td>
EmailId :
 </td>
  <td>
 <input type ="email" name ="EmailId"   required/>
 </td>
 </tr>
 <tr>
 <td>
Password :
 </td>
  <td>
 <input type ="password" name = "password" pattern="((?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})"title="must be 8 alphabet with special symbol"  required/>
 </td>
 </tr>
 
  <tr>
 <td>

 <tr>
  <td>
 <input type="submit" name="submit"/>
 </td>
 </tr>
 <tr>
 <td colspan="2">Yet are Registered!! <a href="Login.jsp">Login Here</a>
 </td>
 </tr>
 </table>
 
 </div>
 </form>
</body>
</html>