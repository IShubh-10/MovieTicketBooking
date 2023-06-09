<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<!-- main Content if any -->
	<section class="py-5">
	<div class="container bg-white">
		<div class="moviecontainer">
		<div class="container">
		<jsp:include page="Message.jsp"></jsp:include>
		
		<table style="text-align: center;" class="table table-success">
		<tr>
		<th>Movie name</th>
		<th>Cast</th>
		<th>Theatre name</th>
		<th>Screen name</th>
		<th>Show Date</th>
		<th>Timings</th>
		<th>Ticket price</th>
		<th colspan="2">Action</th>
		</tr>
		<c:forEach var="s" items="${slist }">
		<tr>
		<td>${s.m.movieName }</td>
		<td>${s.m.cast }</td>
		<td>${s.theatre_Location }</td>
		<td>${s.screenName }</td>
		<td>
		<fmt:parseDate value="${s.showDate }" pattern="yyyy-MM-dd" var="d"></fmt:parseDate>
		<fmt:formatDate value="${d }" type="date" dateStyle="long"/>
		</td>
		<td>From : ${s.startTime }<br>To : ${s.endTime }</td>
		<td>${s.ticketPrice }</td>
		
		<c:if test="${login.equals('admin') }">
		<td><a class="btn btn-outline-success" href="ShowServlet?process=updateShow&showId=${s.showId }">Update</a></td>
		<td><a class="btn btn-outline-danger" onclick="return confirm('Are yoy sure you want to delete ?')" href="ShowServlet?process=deleteShow&showId=${s.showId }">Delete</a></td>
		</c:if>
		
		<c:if test="${login.equals('customer') }">
		<td><a class="btn btn-outline-warning" href="BookingServlet?process=bookMyShow&showId=${s.showId }">Book show</a></td>
		</c:if>
		
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