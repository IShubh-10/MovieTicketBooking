<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String msg=(String)request.getAttribute("msg");
String errorMsg=(String)request.getAttribute("errorMsg");
%>

<% if(msg!=null){ %>
<h3 style="color: lime; text-align: center;"><%= msg %></h3>
<%}else if(errorMsg!=null){ %>
<h3 style="color: red; text-align: center;"><%= errorMsg %></h3>
<%} %>
</body>
</html>