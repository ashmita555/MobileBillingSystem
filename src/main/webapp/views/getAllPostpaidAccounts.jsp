<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.table {
	border-collapse: separate;
	border: solid black 1px;
	border-radius: 12px;
	border-spacing: 20px;
}

th{
	text-align:center;
	color:red;
}

td {
	text-align:center;
}

.button {
	padding: 10px;
	font-size: 12px;
	width: 200px;
	border-radius: 5px;
}

.div1 {
	color: blue;
	text-align: center;
	font-size: 14px;
}

.div2 {
	color: red;
	text-align: center;
	font-size: 14px;
}
</style>
</head>
<body>
	<div style="height:200px; width:100%;">
		<iframe  name="headerFrame" id="frame1" frameborder="0" src="headerPage" style="border-style: none; border-color: inherit; border-width: 0px; height:200px; width:100%;"></iframe>
	</div>
	<br>
	<h1 align="center">All Post Paid Accounts Registered With Customer Id ${sessionScope.customerID}</h1>
				<table align="center" cellpadding="10" class="table">
						<tr>
							<th>Mobile No</th>
							<th>Plan Name</th>
						</tr>
						<c:forEach var="postpaidAccount" items="${postpaidAccounts}">
							<tr>
								<td>${postpaidAccount.mobileNo}</td>
								<td>${postpaidAccount.plan.planName}</td>
							</tr>
						</c:forEach>
				</table>
				<div><h1>${message}</h1></div>
		<form action="welcomePage" method="post">
		<div align="center" style="bottom:20px;"><input type="submit" value="Home Screen"></div>
	</form>
</body>
</html>