<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generate Monthly Bill</title>
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
	<br>
	<h2 align="center">Generate Monthly Bill</h2>
	<br><br><br><br>
	<form:form name="GenerateBill" method="post" action="generateBillController" modelAttribute="bill">
		<table align="center" cellpadding="10" class="loginTable">
			<tr>
				<th>Mobile Number</th>
				<td><input type="text" name="mobileNo" size="20" maxlength="10" pattern="[7-9]{1}[0-9]{8}" oninvalid="setCustomValidity('The Mobile Number must contain only numbers eg. 8989898989')" onchange="try{setCustomValidity('')}catch(e){}" required="required"  /></td>
			</tr>
			<tr>
				<th>Billing Month</th>
				<td>
					<form:select path="billMonth" required="required">
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
					</form:select>
					<td><form:errors path="billMonth" cssClass="error"/></td>
				</td>
			</tr>
			<tr>
				<th>Number Of Local Calls</th>
				<td><form:input path="noOfLocalCalls" size="20" maxlength="10" pattern="[0-9]{1,}" oninvalid="setCustomValidity('Enter Valid Number')" onchange="try{setCustomValidity('')}catch(e){}" required="required"  /></td>
				<td><form:errors path="noOfLocalCalls" cssClass="error"/></td>
			</tr>
			<tr>
				<th>Number Of Local SMS</th>
				<td><form:input path="noOfLocalSMS" size="20" maxlength="10" pattern="[0-9]{1,}" oninvalid="setCustomValidity('Enter Valid Number')" onchange="try{setCustomValidity('')}catch(e){}" required="required"  /></td>
				<td><form:errors path="noOfLocalSMS" cssClass="error"/></td>
				</tr>
			<tr>
				<th>Number Of STD Calls</th>
				<td><form:input path="noOfStdCalls" size="20" maxlength="10" pattern="[0-9]{1,}" oninvalid="setCustomValidity('Enter Valid Number')" onchange="try{setCustomValidity('')}catch(e){}" required="required"  /></td>
				<td><form:errors path="noOfStdCalls" cssClass="error"/></td>
			</tr>
			<tr>
				<th>Number Of STD SMS</th>
				<td><form:input path="noOfStdSMS" size="20" maxlength="10" pattern="[0-9]{1,}" oninvalid="setCustomValidity('Enter Valid Number')" onchange="try{setCustomValidity('')}catch(e){}" required="required"  /></td>
				<td><form:errors path="noOfStdSMS" cssClass="error"/></td>
			</tr>
			<tr>
				<th>Internet Data Usage</th>
				<td><form:input path="internetDataUsageUnits" size="20" maxlength="10" pattern="[0-9.]{1,}" oninvalid="setCustomValidity('Enter Valid Number')" onchange="try{setCustomValidity('')}catch(e){}" required="required"  /> MB</td>
				<td><form:errors path="internetDataUsageUnits" cssClass="error"/></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="Calculate Bill" class="submitButton"/></td>
			</tr>
		</table>
	</form:form>
	
	<br>
	<div class="errorMessage">${errorMessage}</div>
	<div class="welcomeHeading">${resultMessage}</div>
	<br>
	
	<form action="welcomePage" method="post">
		<div align="center" class="homeButtonDiv">
			<input type="submit" value="Home Screen" class="homeButton">
		</div>
	</form>
	
</body>
</html>