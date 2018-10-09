<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update Location</title>
</head>
<body>
<form method="POST" background="blue" action="updateLoc">
<pre>
id: <input name="id" type="text" value="${location.id}" readonly >
code: <input name="code" type="text" value="${location.code}" >
Name:<input name="name" type="text" value="${location.name}" >
Type: urban <input type="radio" name="type" value="urban" "${location.type=='urban'?'checked':''}" >
Rural <input type="radio" name="type" value="rural"  "${location.type=='rural'?'checked':''}"  >
<input type="submit" name="" value="save">
</pre>
</form>


</body>
</html>