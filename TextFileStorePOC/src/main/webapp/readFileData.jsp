<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<label>Fill below form for your data:</label>
	<form action="RetriveFile" method="post" enctype="multipart/form-data">
		<label>Username</label><br>
		<input type="text" name="username"><br>
		<label>Password</label><br>
		<input type="password" name="password"><br>
		<button type="submit">Submit</button>
		</form>
</body>
</html>