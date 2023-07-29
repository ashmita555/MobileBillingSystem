<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Open Account</title>
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
		.error{
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
	
	<form:form name="OpenAccountForm" method="post" action="openCustomerAccountController" modelAttribute="customer">
		<table align="center" cellpadding="10" class="openAccountTable">
			<tr>
				<td><b>First Name</b></td>
				<td><form:input path="firstName" placeholder="Enter first name" size="30"/></td>
				<td><form:errors path="firstName" cssClass="error"/></td>
			</tr>
			<tr>
				<td><b>Last Name</b></td>
				<td><form:input path="lastName"  placeholder="Enter last name" size="30"/></td>
				<td><form:errors path="lastName" cssClass="error"/></td>
			</tr>
			<tr>
				<td><b>Email Id</b></td>
				<td><form:input path="emailID"  placeholder="Enter emailID"  size="30"/></td>
				<td><form:errors path="emailID" cssClass="error"/></td>
			</tr>
			
			<tr>
				<td><b>Date Of Birth</b></td>
				<td><form:input path="dateOfBirth"  placeholder="Enter dateOfBirth" size="30"/></td>
				<td><form:errors path="dateOfBirth" cssClass="error"/></td>
			</tr>
			
			<tr>
				<td><b>Enter Your City</b></td>
				<td><form:input path="address.city"  placeholder="Enter City"  size="30"/></td>
				<td><form:errors path="address.city" cssClass="error"/></td>
			</tr>
			<tr>
				<td><b>Enter Your State</b></td>
				<td><form:input path="address.state" placeholder="Enter State" size="30"/></td>				
				<td><form:errors path="address.state" cssClass="error"/></td>
			</tr>
			<tr>
				<td><b>Enter Your Pin Code</b></td>
				<td><form:input path="address.pinCode" placeholder="Enter pin code" size="30"/></td>
				<td><form:errors path="address.pinCode" cssClass="error"/></td>
			</tr>
			<tr>
				<td><b>Choose Your Plan</b></td>
				<td>
					<select name="planID" >
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
	</form:form>
	<%-- <div class="div2">${requestScope.errorMessage}</div> --%>
	</body>
</html>