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
		<div class="container" style="padding: 30px">
		<jsp:include page="Message.jsp"></jsp:include>
		
<table style="text-align: center;" class="table table-success">
<tr>
<th>BookingNumber</th>
<th>showDate</th>
<th>Timings :</th>
<th>screenName</th>
<th>TotalBill</th>
<th colspan="1">Status</th>

</tr>
<c:forEach var="b" items="${blist }">
<tr>
<td> ${b.bookingId }</td>
<td> 
<fmt:parseDate type="date" var="d" pattern="yyyy-MM-dd" value="${b.s.showDate }"></fmt:parseDate> 
<fmt:formatDate value="${d }" type="date" dateStyle="long"></fmt:formatDate>
</td>
<td>${b.s.startTime } to ${b.s.endTime}</td>
<td>${b.s.screenName }</td>
<td>${b.totalBill }</td>
<td> ${b.status }</td>
<c:if test="${b.status.equals('Confirmed') }">
<td><a class="btn btn-outline-danger"  href="BookingServlet?process=cancelBooking&bookId=${b.bookingId }">Cancel Booking</a></td>
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