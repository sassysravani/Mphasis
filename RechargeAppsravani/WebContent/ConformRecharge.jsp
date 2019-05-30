<%@page import="com.model.Transaction"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<form action="CheckBalControl">
	<center>
	<!--  <input type="submit"  value ="Transaction Details" >-->
    </center>
	</form>
	   <%!List<Transaction> lst=null;

	    %>

	<%
		if (!session.isNew())
		{
			lst=(List)session.getAttribute("data");	
	%>
	
	<table border="2" background="blue">
	<%
	for(Transaction r:lst){
	%>
	
		<tr>
			<td><%=r.getTid()%></td>
			<td><%=r.getMobno()%></td>
			<td><%=r.getMoney()%></td>
			<td><%=r.getServicenam()%></td>
		</tr>
	
	<%
	}}
		session.invalidate();
	%>
</table>

</body>
</html>