<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<th>Booking Id</th>
		<td>${b1.bookingId }</td>
		</tr>
		<tr>
		<th>Email</th>
		<td>${b1.email }</td>
		</tr>
		<tr>
		<th>Show Date</th>
		<td>${b1.s.showDate }</td>
		</tr>
		<tr>
		<th>Movie</th>
		<td>${b1.s.m.movieName }</td>
		</tr>
		<tr>
		<th>Timmings</th>
		<td>From : ${b1.s.startTime }<br>To : ${b1.s.endTime }</td>
		</tr>
		<tr>
		<th>Theatre Location</th>
		<td>${s.theatre_Location }</td>
		</tr>
		<tr>
		<th>Screen Name</th>
		<td>${b1.s.screenName }</td>
		</tr>
		<tr>
		<th>Seats</th>
		<td>${b1.seats }</td>
		</tr>
		<tr>
		<th>Total Bill</th>
		<td>${b1.totalBill }</td>
		</tr>
		<tr>
		<th>Status</th>
		<td>${b1.status }</td>
		</tr>
		
		</table>
		
		</div>
		</div>
		</div>
		</section>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>