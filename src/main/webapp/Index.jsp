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
	      <div class="carousel-item" style="background-image: url('images/RC.jpg')">
	        <div class="carousel-caption d-none d-md-block">
	        <!--   <h2 class="display-4">Third Slide</h2>
	          <p class="lead">This is a description for the third slide.</p> -->
	        </div>
	      </div>
	      <!-- Slide One - Set the background image for this slide in the line below -->
	      <div class="carousel-item active" style="background-image: url('images/bollywoodbannerfinal.jpg')">
	        <div class="carousel-caption d-none d-md-block">
	          <!-- <h2 class="display-4">First Slide</h2>
	          <p class="lead">This is a description for the first slide.</p> -->
	        </div>
	      </div>
	      <!-- Slide Two - Set the background image for this slide in the line below -->
	      <div class="carousel-item" style="background-image: url('images/akshay-kumars-laxmmi-bomb-hardly-a-diwali-fare-920x518.jpg')">
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
		<div class="movie-header movieimage" style="background-image: url('images/3-Walmart-Superman-a.jpg');">
			<div class="header-icon-container">
				<a href="#">
					<i class="material-icons header-icon"> </i>
				</a>
			</div>
		</div><!--movie-header-->
		<div class="movie-content">
			<div class="movie-content-header">
				<a href="#">
					<h3 class="movie-title">Man of Steel</h3>
				</a>
				<div class="imax-logo"></div>
			</div>
			<div class="movie-info">
				
				<div class="info-section">
					<label>Producer</label>
					<span>Abc</span>
				</div><!--Producer-->
				<div class="info-section">
					<label>Director</label>
					<span>Mno</span>
				</div><!--Director-->
				<div class="info-section">
					<label>Writer</label>
					<span>PQR</span>
				</div><!--Director-->
			</div>
			<div class="movie-info">
				<div class="info-section">
					<label>Cast </label>
					<span>Sun 8 Sept </span>
				</div><!--cast-->
				<div class="info-section">
					<label>Release Date </label>
					<span>Sun 8 Sept </span>
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
		<div class="movie-header movieimage" style="background-image: url('http://henrycavill.org/images/Films/2013-Man-of-Steel/posters/3-Walmart-Superman-a.jpg');">
			<div class="header-icon-container">
				<a href="#">
					<i class="material-icons header-icon"> </i>
				</a>
			</div>
		</div><!--movie-header-->
		<div class="movie-content">
			<div class="movie-content-header">
				<a href="#">
					<h3 class="movie-title">Man of Steel</h3>
				</a>
				<div class="imax-logo"></div>
			</div>
			<div class="movie-info">
				
				<div class="info-section">
					<label>Producer</label>
					<span>Abc</span>
				</div><!--Producer-->
				<div class="info-section">
					<label>Director</label>
					<span>Mno</span>
				</div><!--Director-->
				<div class="info-section">
					<label>Writer</label>
					<span>PQR</span>
				</div><!--Director-->
			</div>
			<div class="movie-info">
				<div class="info-section">
					<label>Cast </label>
					<span>Sun 8 Sept </span>
				</div><!--cast-->
				<div class="info-section">
					<label>Release Date </label>
					<span>Sun 8 Sept </span>
				</div><!--date-->
			</div>
			<div  class="movie-info">
				<div  class="info-section">
					<a class="btn btn-primary ml-auto" href="#" role="button">Show's</a>
				</div>
			</div>
		</div><!--movie-content-->
	</div><!--movie-card-->
	  <div class="movie-card">
		<div class="movie-header movieimage" style="background-image: url('http://henrycavill.org/images/Films/2013-Man-of-Steel/posters/3-Walmart-Superman-a.jpg');">
			<div class="header-icon-container">
				<a href="#">
					<i class="material-icons header-icon"> </i>
				</a>
			</div>
		</div><!--movie-header-->
		<div class="movie-content">
			<div class="movie-content-header">
				<a href="#">
					<h3 class="movie-title">Man of Steel</h3>
				</a>
				<div class="imax-logo"></div>
			</div>
			<div class="movie-info">
				
				<div class="info-section">
					<label>Producer</label>
					<span>Abc</span>
				</div><!--Producer-->
				<div class="info-section">
					<label>Director</label>
					<span>Mno</span>
				</div><!--Director-->
				<div class="info-section">
					<label>Writer</label>
					<span>PQR</span>
				</div><!--Director-->
			</div>
			<div class="movie-info">
				<div class="info-section">
					<label>Cast </label>
					<span>Sun 8 Sept </span>
				</div><!--cast-->
				<div class="info-section">
					<label>Release Date </label>
					<span>Sun 8 Sept </span>
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
		<div class="movie-header movieimage" style="background-image: url('http://henrycavill.org/images/Films/2013-Man-of-Steel/posters/3-Walmart-Superman-a.jpg');">
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
					<h3 class="movie-title">Man of Steel</h3>
				</a>
				<div class="imax-logo"></div>
			</div>
			<div class="movie-info">
				<div class="info-section">
					<label>Producer</label>
					<span>Abc</span>
				</div><!--Producer-->
				<div class="info-section">
					<label>Director</label>
					<span>Mno</span>
				</div><!--Director-->
				<div class="info-section">
					<label>Writer</label>
					<span>PQR</span>
				</div><!--Director-->
			</div>
			<div class="movie-info">
				<div class="info-section">
					<label>Cast </label>
					<span>Sun 8 Sept </span>
				</div><!--cast-->
				<div class="info-section">
					<label>Release Date </label>
					<span>Sun 8 Sept </span>
				</div><!--date-->
			</div>
			<div  class="movie-info">
				<div  class="info-section">
					<a class="btn btn-primary ml-auto" href="#" role="button">Show's</a>
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