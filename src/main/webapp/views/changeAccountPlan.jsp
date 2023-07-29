<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<br>
	<h1 align="center">Change Your Plan</h1>
	<br><br>
	<form name="OpenAccountForm" method="post" action="changeAccountPlanController">
		<table align="center" cellpadding="10" class="openAccountTable">
		<tr>
		<td>Enter Your Mobile No.</td>
		<td><input type="number" name="mobileNo" pattern="[1-9]{1}[0-9]{8}"/></td>
		</tr>
			<tr>
				<td><b>Choose Your New Plan</b></td>
				<td>
					<select name="planID" required>
						<option value="5001">Silver Plan</option>
						<option value="5002">Golden Plan</option>
						<option value="5003">Platinum Plan</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit"  value="Chane Your Plan" class="button"/></td>
			</tr>
		</table>
	</form>
	<div align="center"><h1>${message}</h1></div>
		<form action="welcomePage" method="post">
		<div align="center" style="bottom:20px;"><input type="submit" value="Home Screen"></div>
	</form>
</body>
</html>