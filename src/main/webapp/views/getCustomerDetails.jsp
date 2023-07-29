<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<h1 align="center">Customer Details</h1>
				<table align="center" cellpadding="10" class="table">
					<caption><h3>Customer</h3></caption>
					<tr>
						<th><b>Customer ID</b></th>
						<td>${customer.customerID}</td>
					</tr>
					<tr>
						<th><b>First name</b></th>
						<td>${customer.firstName}</td>
					</tr>
					<tr>
						<th><b>Last Name</b></th>
						<td>${customer.lastName}</td>
					</tr>
					<tr>
						<th><b>Email Id</b></th>
						<td>${customer.emailID}</td>
					</tr>
					<tr>
						<th><b>Date Of Birth</b></th>
						<td>${customer.dateOfBirth}</td>
					</tr>
					<tr>
						<th><b>City</b></th>
						<td>${customer.address.city}</td>
					</tr>
					<tr>
						<th><b>State</b></th>
						<td>${customer.address.state}</td>
					</tr>
					<tr>
						<th><b>Pincode</b></th>
						<td>${customer.address.pinCode}</td>
					</tr>
				</table>
				<div><h1>${message}</h1></div>
		<form action="welcomePage" method="post">
		<div align="center" style="bottom:20px;"><input type="submit" value="Home Screen"></div>
	</form>

</body>
</html>