<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
		.openAccountTable {
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
		select:invalid { 
			color: gray; 
		}
	</style>
</head>
<body>
	<div style="height:200px; width:100%;">
		<iframe  name="headerFrame" id="frame1" frameborder="0" src="headerPage" style="border-style: none; border-color: inherit; border-width: 0px; height:200px; width:100%;"></iframe>
	</div>
	<h1 align="center">Open Your Postpaid Account</h1>
	<br><br>
	<form name="OpenAccountForm" method="post" action="openPostpaidAccountController">
		<table align="center" cellpadding="10" class="openAccountTable">
			<tr>
				<td><b>Choose Your Plan</b></td>
				<td>
					<select name="planID" required>
						<option value="5001">Silver Plan</option>
						<option value="5002">Golden Plan</option>
						<option value="5003">Platinum Plan</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit"  value="Get Your Mobile Account" class="button"/></td>
			</tr>
		</table>
	</form>
	<div><h1>${message}</h1></div>
	
	<c:if test="${sessionScope.check=='1'}">
	<div align="center"><h1>Your New Mobile Number Registered Is ${mobileNo}</h1></div>
	</c:if>
		<form action="welcomePage" method="post">
		<div align="center" style="bottom:20px;"><input type="submit" value="Home Screen"></div>
	</form>
</body>
</html>