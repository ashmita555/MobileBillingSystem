<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
	<style>
		.loginTable {
		    border-collapse:separate;
		    border:solid black 1px;
		    border-radius:12px;
		    border-spacing:20px;
		}
		.button{
			padding: 10px;
			font-size: 12px;
			width: 200px;
			border-radius: 5px;
		}
		.div1{
			color: blue;
			text-align: center;
			font-size: 14px;
		}
		.div2{
			color: red;
			text-align: center;
			font-size: 14px;
		}
	</style>

<body>
	<div style="height:200px; width:100%;">
		<iframe  name="headerFrame" id="frame1" frameborder="0" src="headerPage" style="border-style: none; border-color: inherit; border-width: 0px; height:200px; width:100%;"></iframe>
	</div>
	
	<h1 align="center">Login To Check Details</h1>
	<br><br><br><br>
	<form name="loginForm" method="post" action="LoginController" >
		<table align="center" cellpadding="10" class="loginTable">
			<tr>
				<td>Your Customer Id:</td>
				<td><input name="customerID" pattern="[1-9]{1}[0-9]{2}" required /></td>
			</tr>
			<tr>
			<td align="center" colspan="2"><input type="submit" id="loginButton" value="Login" class="button"/></td>
			</tr>
		</table>
	</form>
	
 	<br>
	<div class="div2" name="errorMessage">${message}</div>
	<br>
	<div class="div1">
		<table align="center">
			<tr>
				<td><img alt="" src="images/ClickHere.png" height="25px" width="25px" class="rotate90"></td>
				<td><a href="accountOpeningPage">New User? Get Your Own Mobile No.</a></td>
			</tr>
		</table>
	</div>
	<br>
</body>
</html>