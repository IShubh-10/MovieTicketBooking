<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String login=(String)session.getAttribute("login");
if(login==null){
	request.setAttribute("errorMsg", "Please login to have a better experience!!");
}
%>
<jsp:include page="Header.jsp"></jsp:include>

<!-- main Content if any -->
	<section class="py-5">
	<div class="container bg-white">
		<div class="moviecontainer">
		<div class="container" style="padding: 30px">
		<jsp:include page="Message.jsp"></jsp:include>
		
		<form action="MovieServlet">
		<input type="hidden" name="process" value="searchMovie">
		</form>
		
		<table style="text-align: center;" class="table table-success">
		<tr>
		<th>Name</th>
		<th>Director</th>
		<th>Cast</th>
		<%if(login!=null){ %>
		<th colspan="2"></th>
		<%} %>
		</tr>
		
		<c:forEach items="${mlist }" var="m">
		<tr>
		<td><c:out value="${m.movieName }"></c:out> </td>
		<td><c:out value="${m.director }"></c:out> </td>
		<td><c:out value="${m.cast }"></c:out> </td>
		
		<%if(login!=null && login.equals("admin")){ %>
		<td><a class="btn btn-outline-success" href="MovieServlet?process=updateMovie&movieId=${m.movieId }">Update</a></td>
		<td><a class="btn btn-outline-danger" onclick="return confirm('Are yoy sure you want to delete ?')" href="MovieServlet?process=deleteMovie&movieId=${m.movieId }">Delete</a></td>
		<%} %>
		
		<%if(login!=null && login.equals("customer")){ %>
		<td><a class="btn btn-outline-success" href="ShowServlet?process=showDetails&movieId=${m.movieId }">Shows</a></td>
		<%} %>
		</tr>
		</c:forEach>
		</table>
		
		</div>
		</div>
		</div>
		</section>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>