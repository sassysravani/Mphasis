<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Opening</title>
</head>
<body>
<form action="AccountController">
 
<table border="1" align="center" width="400" bgcolor="skyblue" >
 
<caption><h1>Account opening</h1></caption>
 
<tr>
<hr>
<th>Enter your mobile</th>
 
<td><input type="number" name="mobileno"/></td>
 
</tr>
<tr> 
<th>Enter your password</th>
 
<td><input type="password" name="pass"/></td>
 
</tr>
<tr> 
<th>Username</th>
 
<td><input type="text" name="uname"/></td>
 
</tr>
<th>Type
 of account</th>
 
<td>
 
<select name="type_accno">
 
<option value=" Type of account" selected="selected" disabled="disabled">Type of account</option>
 
<option value="Saving">Savings</option>
 
<option value="Current">Current</option>
 
</select>
 
<tr>
<th>Amount</th>
 
<td><input type="number" name="amt"/></td>
 
</tr>
 
 
</td>
 
</tr>
 

 
<td colspan="2" align="center"><input type="submit" value="Save My Data"/>
 
<input type="reset" value="Reset Data"/>
 
</td>
 
</tr>
 
</table>
 
</form>
 
</body>
 
</html>
</body>
</html>