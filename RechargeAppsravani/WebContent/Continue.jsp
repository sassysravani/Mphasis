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
	<table align="center" border="2" bgcolor="gray">
	<tr>
		<td>Mobile No</td>
		<td><input type="tel" placeholder="Enter Number" name="mob" title="Enter your Mobile Number" required>
	</tr>
	<tr>
		<td>Service Provider</td>
		<td><select name="s">
			<option value="tyep of services" selected="selected" disabled="disabled"/>
			<option value="B" >BSNL</option>
			<option value="J" >JIO</option>
			<option value="I" >IDEA</option>
			<option value="A" >AIRTEL</option>
			<option value="b" >VODAFONE</option>
			</select></td>
	<tr>
		<td>Amount</td>
		<td><input type="text" placeholder="Enter Ammount" name="amnt" title="Enter your Amount" required></td>
	</tr>
	<tr>
		<td>Submit</td>
		<td><input type="submit" value="Submit" required>
	</tr>
	</table>
</form>


</body>
</html>