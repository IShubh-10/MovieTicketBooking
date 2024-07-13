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
<header>
	  <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
	    <ol class="carousel-indicators">
	      <li data-target="#carouselExampleIndicators" data-slide-to="0"></li>
	      <li data-target="#carouselExampleIndicators" data-slide-to="1"  class="active"></li>
	      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	    </ol>
	    <div class="carousel-inner" role="listbox">
	      <!-- Slide Three - Set the background image for this slide in the line below -->
	      <div class="carousel-item" style="background-image: url('images/toy-story.jpg')">
	        <div class="carousel-caption d-none d-md-block">
	        <!--   <h2 class="display-4">Third Slide</h2>
	          <p class="lead">This is a description for the third slide.</p> -->
	        </div>
	      </div>
	      <!-- Slide One - Set the background image for this slide in the line below -->
	      <div class="carousel-item active" style="background-image: url('images/up.jpg')">
	        <div class="carousel-caption d-none d-md-block">
	          <!-- <h2 class="display-4">First Slide</h2>
	          <p class="lead">This is a description for the first slide.</p> -->
	        </div>
	      </div>
	      <!-- Slide Two - Set the background image for this slide in the line below -->
	      <div class="carousel-item" style="background-image: url('images/inside-out.jpg')">
	        <div class="carousel-caption d-none d-md-block">
	          <!-- <h2 class="display-4">Second Slide</h2>
	          <p class="lead">This is a description for the second slide.</p> -->
	        </div>
	      </div>
	    </div>
	    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
	          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	          <span class="sr-only">Previous</span>
	        </a>
	    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
	          <span class="carousel-control-next-icon" aria-hidden="true"></span>
	          <span class="sr-only">Next</span>
	        </a>
	  </div>
	</header>
	<!-- main Content if any -->
	<section class="py-5">
	<div class="container bg-white">
		<div class="moviecontainer">
		<div class="container">
		<jsp:include page="Message.jsp"></jsp:include>
        <div class="row">
          <div class="col-md-4 col-sm-12">
            <div class="section-heading">
              <div class="line-dec"></div>
              <h1 class="page-title">Up Coming Movies </h1>
            </div>
          </div>
        </div>
      </div>
	  <div class="movie-card">
		<div class="movie-header movieimage" style="background-image: url('images/fast-x.jpg');">
			<div class="header-icon-container">
				<a href="#">
					<i class="material-icons header-icon"> </i>
				</a>
			</div>
		</div><!--movie-header-->
		<div class="movie-content">
			<div class="movie-content-header">
				<a href="#">
					<h3 class="movie-title">Fast - X</h3>
				</a>
				<div class="imax-logo"></div>
			</div>
			<div class="movie-info">
				
				<div class="info-section">
					<label>Producer</label>
					<span>Neal H. Moritz</span>
				</div><!--Producer-->
				<div class="info-section">
					<label>Director</label>
					<span>Louis Leterrier</span>
				</div><!--Director-->
				<div class="info-section">
					<label>Writer</label>
					<span>Dan Mazeau</span>
				</div><!--Director-->
			</div>
			<div class="movie-info">
				<div class="info-section">
					<label>Cast </label>
					<span>Vin Diesel<br>  Cody Walker </span>
				</div><!--cast-->
				<div class="info-section">
					<label>Release Date </label>
					<span>19 Dec 2023 </span>
				</div><!--date-->
			</div>
			<div  class="movie-info">
				<div  class="info-section">
					<a class="btn btn-primary ml-auto" href="#" role="button">Coming Soon...</a>
				</div>
			</div>
		</div><!--movie-content-->
	</div><!--movie-card-->
	<div class="movie-card">
		<div class="movie-header movieimage" style="background-image: url('images/Jawan.jpg');">
			<div class="header-icon-container">
				<a href="#">
					<i class="material-icons header-icon"> </i>
				</a>
			</div>
		</div><!--movie-header-->
		<div class="movie-content">
			<div class="movie-content-header">
				<a href="#">
					<h3 class="movie-title">Jawan</h3>
				</a>
				<div class="imax-logo"></div>
			</div>
			<div class="movie-info">
				
				<div class="info-section">
					<label>Producer</label>
					<span>Red Chillies</span>
				</div><!--Producer-->
				<div class="info-section">
					<label>Director</label>
					<span>Atlee Kumar</span>
				</div><!--Director-->
				<div class="info-section">
					<label>Writer</label>
					<span>T. Muthuraj</span>
				</div><!--Director-->
			</div>
			<div class="movie-info">
				<div class="info-section">
					<label>Cast </label>
					<span>Shahrukh Khan<br> Nayantara </span>
				</div><!--cast-->
				<div class="info-section">
					<label>Release Date </label>
					<span>7 Sept 2023 </span>
				</div><!--date-->
			</div>
			<div  class="movie-info">
				<div  class="info-section">
					<a class="btn btn-primary ml-auto" href="#" role="button">Coming Soon...</a>
				</div>
			</div>
		</div><!--movie-content-->
	</div><!--movie-card-->
	  <div class="movie-card">
		<div class="movie-header movieimage" style="background-image: url('images/Gadar.jpg');">
			<div class="header-icon-container">
				<a href="#">
					<i class="material-icons header-icon"> </i>
				</a>
			</div>
		</div><!--movie-header-->
		<div class="movie-content">
			<div class="movie-content-header">
				<a href="#">
					<h3 class="movie-title">Gadar 2</h3>
				</a>
				<div class="imax-logo"></div>
			</div>
			<div class="movie-info">
				
				<div class="info-section">
					<label>Producer</label>
					<span>Zee Studios</span>
				</div><!--Producer-->
				<div class="info-section">
					<label>Director</label>
					<span>Anil Sharma</span>
				</div><!--Director-->
				<div class="info-section">
					<label>Writer</label>
					<span>Najeeb Khan</span>
				</div><!--Director-->
			</div>
			<div class="movie-info">
				<div class="info-section">
					<label>Cast </label>
					<span>Sunny Deol<br> Ameesha Patel</span>
				</div><!--cast-->
				<div class="info-section">
					<label>Release Date </label>
					<span>11 Aug 2023 </span>
				</div><!--date-->
			</div>
			<div  class="movie-info">
				<div  class="info-section">
					<a class="btn btn-primary ml-auto" href="#" role="button">Coming Soon...</a>
				</div>
			</div>
		</div><!--movie-content-->
	</div><!--movie-card-->
	<div class="movie-card">
		<div class="movie-header movieimage" style="background-image: url('images/Yodha.jpg');">
			<div class="header-icon-container">
				<a href="#">
					<i class="material-icons header-icon"> </i>
				</a>
			</div>
		</div>
		<!--movie-header-->
		<div class="movie-content">
			<div class="movie-content-header">
				<a href="#">
					<h3 class="movie-title">Yodha</h3>
				</a>
				<div class="imax-logo"></div>
			</div>
			<div class="movie-info">
				<div class="info-section">
					<label>Producer</label>
					<span>Karan Johar</span>
				</div><!--Producer-->
				<div class="info-section">
					<label>Director</label>
					<span>Pushkar Ojha</span>
				</div><!--Director-->
				<div class="info-section">
					<label>Writer</label>
					<span>Sagar Ambre</span>
				</div><!--Director-->
			</div>
			<div class="movie-info">
				<div class="info-section">
					<label>Cast </label>
					<span>Sidharth Malhotra<br> Disha Patani </span>
				</div><!--cast-->
				<div class="info-section">
					<label>Release Date </label>
					<span>15 Sept 2023 </span>
				</div><!--date-->
			</div>
			<div  class="movie-info">
				<div  class="info-section">
					<a class="btn btn-primary ml-auto" href="#" role="button">Coming Soon...</a>
				</div>
			</div>
		</div><!--movie-content-->
	</div><!--movie-card-->
	<div class="movie-card">
		<div class="movie-header movieimage" style="background-image: url('images/Maidan.jpg');">
			<div class="header-icon-container">
				<a href="#">
					<i class="material-icons header-icon"> </i>
				</a>
			</div>
		</div>
		<!--movie-header-->
		<div class="movie-content">
			<div class="movie-content-header">
				<a href="#">
					<h3 class="movie-title">Maidaan</h3>
				</a>
				<div class="imax-logo"></div>
			</div>
			<div class="movie-info">
				<div class="info-section">
					<label>Producer</label>
					<span>Karan Johar</span>
				</div><!--Producer-->
				<div class="info-section">
					<label>Director</label>
					<span>Pushkar Ojha</span>
				</div><!--Director-->
				<div class="info-section">
					<label>Writer</label>
					<span>Sagar Ambre</span>
				</div><!--Director-->
			</div>
			<div class="movie-info">
				<div class="info-section">
					<label>Cast </label>
					<span>Sidharth Malhotra<br> Disha Patani </span>
				</div><!--cast-->
				<div class="info-section">
					<label>Release Date </label>
					<span>15 Sept 2023 </span>
				</div><!--date-->
			</div>
			<div  class="movie-info">
				<div  class="info-section">
					<a class="btn btn-primary ml-auto" href="#" role="button">Coming Soon...</a>
				</div>
			</div>
		</div><!--movie-content-->
	</div><!--movie-card-->
	<div class="movie-card">
		<div class="movie-header movieimage" style="background-image: url('images/Aquaman.jpg');">
			<div class="header-icon-container">
				<a href="#">
					<i class="material-icons header-icon"> </i>
				</a>
			</div>
		</div>
		<!--movie-header-->
		<div class="movie-content">
			<div class="movie-content-header">
				<a href="#">
					<h3 class="movie-title">Aquaman </h3>
				</a>
				<div class="imax-logo"></div>
			</div>
			<div class="movie-info">
				<div class="info-section">
					<label>Producer</label>
					<span>Peter Safran</span>
				</div><!--Producer-->
				<div class="info-section">
					<label>Director</label>
					<span>James Wan</span>
				</div><!--Director-->
				<div class="info-section">
					<label>Writer</label>
					<span>James wan</span>
				</div><!--Director-->
			</div>
			<div class="movie-info">
				<div class="info-section">
					<label>Cast </label>
					<span>Jason Momoa<br> Amber Heard</span>
				</div><!--cast-->
				<div class="info-section">
					<label>Release Date </label>
					<span>20 Dec 2023 </span>
				</div><!--date-->
			</div>
			<div  class="movie-info">
				<div  class="info-section">
					<a class="btn btn-primary ml-auto" href="#" role="button">Coming Soon...</a>
				</div>
			</div>
		</div><!--movie-content-->
	</div><!--movie-card-->
	
	</div>
	</div>
	</section>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>