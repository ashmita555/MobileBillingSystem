<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Successful!</title>
<style>
	div {
	 	background-color: #ffc107;
        text-align: center;
	 	font-size: 36px;
	 	color: white;
	 }
	p {
	 	text-align:center;
	 	font-size: 22px;
	 }
    .button{
		padding: 5px;
		font-size: 12px;
		width: 125px;
		border-radius: 5px;
	}
</style>
</head>
<body>
<div style="height:auto; width:100%;background-color: white">
		<iframe  name="headerFrame" id="frame1" frameborder="0" src="headerPage" style="border-style: none; border-color: inherit; border-width: 0px; height:200px; width:100%;"></iframe>
	</div>
	<div style="margin-top: 20px">Welcome ${customer.firstName} ${customer.lastName}</div>
	<p> Your details have been successfully registered with mobile number ${sessionScope.mobileNo} !</p>
	<p>${customer.customerID}</p>
	<div align="center">
	<form  action="loginPage">
		<button type="submit" value="LogIn">Login</button>
	</form></div>
</body>
</html>