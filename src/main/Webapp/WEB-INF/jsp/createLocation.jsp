<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Location</title>
</head>
<body>
<form method="POST" background="blue" action="saveLoc">
<pre>
id: <input name="id" type="text">
code: <input name="code" type="text">
Name:<input name="name" type="text">
Type: urban <input type="radio" name="type" value="urban">
Rural <input type="radio" name="type" value="rural">
<input type="submit" name="" value="save">
</pre>
</form>

<div>${msg}</div>

<a href="displayLocations">ViewAll</a>
</body>
</html>