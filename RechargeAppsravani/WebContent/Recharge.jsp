<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CheckBalControl">
	<table align="center" border="2" bgcolor="skyblue">
	<tr>
		<td>Mobile No</td>
		<td><input type="number" placeholder="Enter Number" name="mob" title="Enter your Mobile Number" required>
	</tr>
	<tr>
		<td>Service Provider</td>
		<td><select name="S">
			<option value="tyep of services" selected="selected" disabled="disabled">Type of Services</option>
			<option value="AIRTEL" >AIRTEL</option>
			<option value="BSNL" >BSNL</option>
			<option value="IDEA" >IDEA</option>
			<option value="JIO" >JIO</option>	
			<option value="VODAFONE" >VODAFONE</option>
			</select></td>
	<tr>
		<td>Amount</td>
		<td><input type="number" placeholder="Enter Ammount" name="amnt" title="Enter your Amount" required></td>
	</tr>
	<tr rowspan="2">
		<td><input type="submit" value="proceed"></td>
	</tr>
	</table>
</form>

</body>
</html>