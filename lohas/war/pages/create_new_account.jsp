<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/default.css"/>
<title>Sign up</title>
</head>
<body>
	<div id="header"><h1>Welcome To Join Us</h1></div>
	<div id="container">
	<form action="lohas/user" method="post">
		<div>
		<div class="input_style">
			<span>User Name</span>
			<input type="text" name="userName" value="" class="txtInput"/>
		</div>
		<div class="input_style">
			<span>Password</span>
			<input type="password" name="password" value="" class="txtInput"/>
		</div>
		<div class="input_style">
			<span>Password Repeat</span>
			<input type="password" name="rePassword" value="" class="txtInput"/>
		</div>
		<div class="input_style">
			<span>Your Email</span>
			<input type="text" name="email" value="" class="txtInput"/>
		</div>
		<div class="input_style">
			<span>Gender</span>
			<input type="radio" name="gender" id="male" value="Male"/>
			<label for="male">Male</label>&nbsp;
			<input type="radio" name="gender" id="female" value="Famale"/>
			<label for="female">Female</label>
		</div>
		<div class="button_style">
			<input type="submit" class="buttonInput" value="SUBMIT">
			<input type="reset" class="buttonInput" value="RESET">
		</div>
		</div>
	</form>
	</div>
</body>
</html>