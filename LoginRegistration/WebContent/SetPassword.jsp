<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="PasswordChange" method="post">
<div>
			<table style="width: 50%">
			<tr>
					<td>EmailId</td>
					<td><input type="email" name="email"  required/></td>
				</tr>
			
				<tr>
					<td>NewPassword</td>
					<td><input type="password" name="password" pattern="((?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})"
					title="must be 8 alphabet with special symbol" required/></td>
				</tr>
				
				<tr>
					<td>ConfirmPassword</td>
					<td><input type="password" name="confirmpassword" pattern="((?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})"
					title="must be 8 alphabet including special symbol" required /></td>
				</tr>
				
				
				</table>
			<input type="submit" value="Submit" />
			</div>
			</form>
</body>
</html>