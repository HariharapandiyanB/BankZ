<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Occured</title>
</head>
<body>
	<p>An Error has been Occured!</p>
	
	<p><%=request.getAttribute("message") %></p>
	
</body>
</html>