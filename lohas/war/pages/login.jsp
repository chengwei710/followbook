<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
<title>Login</title>
<link href="<s:url value="/css/login.css"/>" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="container">
		<div id="header">
		<s:actionerror escape="false"/>
		<s:fielderror theme="simple" fieldName="userName"/>
		<s:fielderror fieldName="password"/>
		</div>
		<div id="login">
			<form action="home" method="post">
			<div id="login_input">
				<img src="<s:url value="/images/login_username.png"/>"/>
				<input type="text" class="txtInput" name="userName"/><br/>
				<img src="<s:url value="/images/login_password.png"/>"/>
				<input type="password" class="txtInput" name="password"/>
			</div>
			<div id="login_link">
				<ul>
				<li><a href="/lohas/retrieve_password.jsp" ><img src="<s:url value="/images/login_forget.png"/>"/>&nbsp;LOST PASSWORD?</a></li>
				<li><a href="/lohas/create_new_account.jsp"><img src="<s:url value="/images/login_newaccount.png"/>"/>&nbsp;NEW ACCOUNT</a></li>
				<li><a href="/lohas/login_help.jsp"><img src="<s:url value="/images/login_help.png"/>"/>&nbsp;HELP</a></li>
				</ul>
			</div>
			<div id="login_button">
				<input type="checkbox" id="remember" value="0" />
				<label for="remember">Remember Me</label>
				<input type="submit" class="buttonInput" name="login" value="LOGIN"/>
			</div>
			</form>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>
