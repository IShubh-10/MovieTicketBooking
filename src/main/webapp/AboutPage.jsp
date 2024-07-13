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
	<div class="card mb-3">
		<img src="images/AboutPage.jpg" style="height: 400px; width: 100%;"
			class="card-img-top" alt="...">
		<div class="card-body">
			<h3 class="card-title">INTRODUCTION</h3>
			<p class="card-text">
				Welcome to newly designed website movie ticket booking is a faster,
				cleaner and a tad more personal website, specially designed to make
				your booking experience better. Log on, navigate and find out for
				yourselves and if time permits leave your valuable feedback. <br>
				<br> Customers may view the contents of any movie show at any
				time and may book any movie ticket as needed. The program
				automatically calculates the subtotal and grand total. When a
				visitor decides to finally book the ticket, the order information
				including the buyer's name, address and billing instruction is
				stored in the database securely and payment has been made. The combo
				booking is also provided at the time of booking the ticket and
				there's a wonderful facility of delivering the combos at your seat
				when you are watching the movie. <br> <br> You need to
				register a new user whenever you have first visited or site then for
				future it will be stored in our database permanently and you can
				book you movie ticket at any time you want with this username and
				password
			</p>
			<h3 class="card-title">FUTURE SCOPE ?</h3>
			- In future our job management system will have extra facilities and
			more companies for more employees.<br> - It will grant more easy
			access.<br> - We are going to include recommendation system to
			this project so it will be helpfull for the user to search and apply
			for jobs as they wish.
			<p class="card-text">
				<small class="text-body-secondary">Last updated 3 weeks ago</small>
			</p>
		</div>
	</div>
	
		</div>
		</div>
		</div>
		</section>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>