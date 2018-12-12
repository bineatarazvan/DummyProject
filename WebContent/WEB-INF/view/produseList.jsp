<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users List</title>
</head>
<body>
<pre>
Products : 
Denumirea produsului si pretul
</pre> 
<table>
<c:forEach var="produs" items="${produse}">
<tr>
	<td>${produs.getDen_produs()}</td>
	<td>${produs.getPret_produs()}</td>
	<a href="./<td>${produs.getLink()}</td>"> link to image</a></br>
	
</tr>
</c:forEach>
</table>
</body>
</html>