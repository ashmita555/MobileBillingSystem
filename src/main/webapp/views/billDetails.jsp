<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="height:200px; width:100%;">
		<iframe  name="headerFrame" id="frame1" frameborder="0" src="headerPage" style="border-style: none; border-color: inherit; border-width: 0px; height:200px; width:100%;"></iframe>
	</div>
	<br>
	<div>
		<form:form name="getBillDetails" method="post" action="getBillDetailsController">
		<table align="center" cellpadding="10" class="loginTable">
			<tr>
				<th>Mobile Number</th>
				<td><input type="text" name="mobileNo" size="20" maxlength="10" pattern="[7-9]{1}[0-9]{8}" oninvalid="setCustomValidity('The Mobile Number must contain only numbers eg. 8989898989')" onchange="try{setCustomValidity('')}catch(e){}" required="required"  /></td>
			</tr>
			<tr>
				<th>Billing Month</th>
				<td>
					<select name="billMonth" required>
						<option value="" disabled selected hidden>Select from dropdown</option>
						<option value="JANUARY">January</option>
						<option value="FEBRUARY">February</option>
						<option value="MARCH">March</option>
						<option value="APRIL">April</option>
						<option value="MAY">May</option>
						<option value="JUNE">June</option>
						<option value="JULY">July</option>
						<option value="AUGUST">August</option>
						<option value="SEPTEMBER">September</option>
						<option value="OCTOBER">October</option>
						<option value="NOVEMBER">November</option>
						<option value="DECEMBER">December</option>
					</select></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="Get Bill Details" class="submitButton"/></td>
			</tr>
		</table>
	</form:form>
	</div>
	
	<c:if test="${sessionScope.check2=='1' }">
	<div>
		<h1 align="center">Bill Details</h1>
				<table align="center" cellpadding="10" class="table">
					<tr>
						<th><b>Bill ID</b></th>
						<td>${bill.billID}</td>
					</tr>
					<tr>
						<th><b>noOfLocalSMS</b></th>
						<td>${bill.noOfLocalSMS}</td>
					</tr>
					<tr>
						<th><b>noOfStdSMS</b></th>
						<td>${bill.noOfStdSMS}</td>
					</tr>
					<tr>
						<th><b>noOfLocalCalls</b></th>
						<td>${bill.noOfLocalCalls}</td>
					</tr>
					<tr>
						<th><b>noOfStdCalls</b></th>
						<td>${bill.noOfStdCalls}</td>
					</tr>
					<tr>
						<th><b>internetDataUsageUnits</b></th>
						<td>${bill.internetDataUsageUnits}</td>
					</tr>
					<tr>
						<th><b>billMonth</b></th>
						<td>${bill.billMonth}</td>
					</tr>
					<tr>
						<th><b>totalBillAmount</b></th>
						<td>${bill.totalBillAmount}</td>
					</tr>
					<tr>
						<th><b>localSMSAmount</b></th>
						<td>${bill.localSMSAmount}</td>
					</tr>
					<tr>
						<th><b>stdSMSAmount</b></th>
						<td>${bill.stdSMSAmount}</td>
					</tr>
					<tr>
						<th><b>localCallAmount</b></th>
						<td>${bill.localCallAmount}</td>
					</tr>
					<tr>
						<th><b>stdCallAmount</b></th>
						<td>${bill.stdCallAmount}</td>
					</tr>
					<tr>
						<th><b> internetDataUsageAmount</b></th>
						<td>${bill.internetDataUsageAmount}</td>
					</tr>
					<tr>
						<th><b>totalBillAmount</b></th>
						<td>${bill.totalBillAmount}</td>
					</tr>
					<tr>
						<th><b>servicesTax</b></th>
						<td>${bill.servicesTax}</td>
					</tr>
					<tr>
						<th><b>vat</b></th>
						<td>${bill.vat}</td>
					</tr>
				</table>
	</div></c:if>
	<br>
	<div class="errorMessage">${message}</div>
	<br>
	
	<form action="welcomePage" method="post">
		<div align="center" class="homeButtonDiv">
			<input type="submit" value="Home Screen" class="homeButton">
		</div>
	</form>
	
</body>
</html>