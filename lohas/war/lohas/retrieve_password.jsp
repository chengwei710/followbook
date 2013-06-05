<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/default.css"/>
<title>Forgot Password</title>
</head>
<body>
	<div id="header"><h1>Retrieve Password</h1></div>
	<div id="container">
	<form action="lohas/findPassword" method="post">
		<div class="input_line_style">
			<span>Please Enter Your Email</span>
			<input type="text" name="email" class="txtInput" value=""/>
			<input type="submit" class="buttonInput" value="SUBMIT"/>
		</div>
	</form>
	</div>
</body>
</html>