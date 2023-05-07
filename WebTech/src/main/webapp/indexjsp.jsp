<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>

	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learn Learn</title>
<link href="css/HomeCSS.css" rel="stylesheet"></link>
</head>
<body class="bd" background="photosImg/elearning.jpg">
<div align="center" class="loginbox" >
	<h1>Login Here</h1>
	<form action="Login" method="POST">
	<p> User Name   :<input type="text" name="user_name" placeholder="Enter Your Name"> </p>
	<p> Password     :<input type="password" name="pass_word" placeholder="Enter Password"></p>
	<p><input type="submit" id="submit" value="submit" name="submit"></p>
	</form>
</div>
</body>
</html>