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
		
		<form action="MovieServlet" method="post">
		<input type="hidden" name="process" value="editMovie">
		<input type="hidden" name="movieId" value="${movieObj.movieId }">
		
		<table style="text-align: center;" class="table table-success">
		<tr>
		<th>Enter movie name </th>
		<td><input type="text" name="movieName" value="${movieObj.movieName }"></td>
		</tr>
		
		<tr>
		<th>Enter director name </th>
		<td><input type="text" name="director" value="${movieObj.director }"></td>
		</tr>
		
		<tr>
		<th>Enter producer name </th>
		<td><input type="text" name="producer" value="${movieObj.producer }"></td>
		</tr>
		
		<tr>
		<th>Enter cast name </th>
		<td><input type="text" name="cast" value="${movieObj.cast }"></td>
		</tr>
		
		<tr>
		<th>Enter movie language </th>
		<td><input type="text" name="lang" value="${movieObj.lang }"></td>
		</tr>
		
		<tr>
		<th>Enter release date</th>
		<td><input type="date" name="releaseDate" value="${movieObj.releaseDate }"></td>
		</tr>
		
		<tr>
		<td><input type="reset" value="Clear" class="btn btn-outline-warning"></td>
		<td><input type="submit" value="Update" class="btn btn-outline-success"></td>
		</tr>
		</table>
		</form>
		
		</div>
		</div>
		</div>
		</section>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>