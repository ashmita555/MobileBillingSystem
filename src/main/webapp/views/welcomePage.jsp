<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<style>
		div {
		 	position: relative;
		 	align: center;
		 }
	</style>
</head>
<body>
	<div style="height:200px; width:100%;">
		<iframe  name="headerFrame" id="frame1" frameborder="0" src="headerPage" style="border-style: none; border-color: inherit; border-width: 0px; height:200px; width:100%;"></iframe>
	</div>
	<br>
	<form action="loginPage" method="post" target="mainFrame">
		<div style="position:absolute; right:40px;"><input type="submit" value="Log Out" align="right"/></div>
	</form>
	<br><br>
	
	<div align="center"><h1>Welcome!</h1></div>
	
	<div align="center">
		<table cellspacing="10" cellpadding="10">
			<tr>
				<%-- <td><a href="depositToAccountPage" target="mainFrame"><img alt="" src="${pageContext.request.contextPath}/resources/ClickHere.png" height="25px" width="25px"></a></td> --%>
				<td><a href="customerController">Your Details</a></td>
			</tr>
			<tr>
				<td><a href="openPostpaidAccount">Open Post Paid Mobile Account</a></td>
			</tr>
			<tr>
				<td><a href="generateBillPage">Generate Monthly Mobile Bill</a></td>
			</tr>
			<tr>
				<td><a href="billDetails">Mobile Bill Details</a></td>
			</tr>
				<tr>
				<td><a href="changeAccountPlan">Change Your Account Plan</a></td>
			</tr>
			<tr>
				<td><a href="plansOfferedController">Plans Offered By Us</a></td>
			</tr>
			<tr>
				<td><a href="getAllPostpaidAccountsController" >Find All Your Post Paid Accounts</a></td>
			</tr>
			<tr>
				<td><a href="deactivatePostpaidAccount">Deactivate A Post Paid Account</a></td>
			</tr>
			
		</table>
	</div>
	
</body>
</html>