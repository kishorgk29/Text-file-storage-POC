<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="TextFile" method="post" enctype="multipart/form-data">
		<label>Username</label> <br> 
		<input type="text" name="username" required="required"> <br> 
		<label>Password</label> <br>
		<input type="password" name="password" required="required"> <br>
		<label>Textfile</label> <br> 
		<input type="file" name="file"	required="required"> <br>
		<button type="submit">Submit</button>
	</form>
</body>
</html>