<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="icon" type="image/*" href="images/logo.png" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.3.1.slim.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="css/font-awesome.min.css" rel="stylesheet">

<link href="css/main.css" rel="stylesheet">
<script type="text/javascript">
		$(function(){
			$("li.nav-item").click(function(){
				 $('li.nav-item').removeClass('active'); 
				 $(this).addClass('active'); 
			});
		})
	</script>

</head>
<body>
<%
String login=(String)session.getAttribute("login");
%>
	<!-- Content here -->
	<!-- Navigation -->
	<div class="fixed-top">
		<nav
			class="navbar navbar-expand-lg navbar-dark mx-background-top-linear">
			<div class="container">
				<a class="navbar-brand" rel="nofollow" target="_blank"
					href="http://scadonsak.com/7bF"
					style="font-weight: bold; font-variant: small-caps; color: black;">
					Book <span class="ticket">Your</span> Show.COM
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">

					<ul class="navbar-nav ml-auto">

						<li class="nav-item active"><a class="nav-link" href="Index.jsp">Home<span
								class="sr-only">(current)</span></a></li>

						<li class="nav-item"><a class="nav-link" href="MovieServlet?process=allMovies">Movies</a>
						</li>
							<%if(login!=null){ %>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Dropdown </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<%if(login!=null && login.equals("admin")){ %>
								<a class="dropdown-item" href="AddMovie.jsp">Add Movie</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="ShowServlet?process=addShow">Add Show</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="ShowServlet?process=showList">All Show's</a>
								
								<%} %>
							<%if(login!=null && login.equals("customer")){ %>
								<a class="dropdown-item" href="CustomerServlet?process=myProfile">My profile</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="ShowServlet?process=showList">All Show's</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="BookingServlet?process=myBookingHistory">Booking History</a>
								<%} %>
								
							</div></li>
							<%} %>
						<%
						if(login==null){
						%>
						<li class="nav-item"><a class="nav-link" href="Login.jsp">Login</a></li>
						<li class="nav-item"><a class="nav-link" href="AddCustomer.jsp">Register</a></li>
						<%} %>
						<% if(login!=null){ %>
						<li class="nav-item"><a class="nav-link" onclick="return confirm('Are you sure you want to logout?')" href="LoginServlet">logout</a></li>
						<%} %>
						
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Social's </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="https://www.instagram.com/filmatic/">Instagram</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="https://linkedin.com/in/shubham-kadam-3a9043202">LinkedIn</a>
							</div></li>
						<!-- <li class="nav-item"><a class="nav-link" href="#">Profile</a></li> -->
						<li class="nav-item"><a class="nav-link" href="AboutPage.jsp">About</a></li>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
</html>