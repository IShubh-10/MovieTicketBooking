<%@page import="com.movie.pojo.Show"%>
<%@page import="com.movie.pojo.Movie"%>
<%@page import="java.util.List"%>
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
List<Movie> mlist=(List<Movie>)session.getAttribute("mlist");
Show s=(Show)session.getAttribute("showObj");
%>
<jsp:include page="Header.jsp"></jsp:include>

<!-- main Content if any -->
	<section class="py-5">
	<div class="container bg-white">
		<div class="moviecontainer">
		<div class="container" style="padding: 30px">
		<jsp:include page="Message.jsp"></jsp:include>
		
		<form action="ShowServlet" method="post">
		<input type="hidden" name="process" value="editShow">
		<input type="hidden" name="showId" value="<%= s.getShowId() %>">
		
		<table style="text-align: center;" class="table table-success">
		<tr>
		<th>Movie Id</th>
		<td>
		<select name="movieId">
		<%for(Movie m:mlist){ %>
		<%if(s.getMovieId()==m.getMovieId()){ %>
		<option value="<%= m.getMovieId() %>" selected="selected"><%= m.getMovieName() %></option>
		<%} else{ %>
		<option value="<%=m.getMovieId() %>"><%=m.getMovieName() %></option>
		<%}}%>
		</select>
		</td>
		</tr>
		
		<tr>
		<th>Theatre and Location</th>
		<td><input type="text" name="theatre_Location" value="<%=s.getTheatre_Location() %>" onblur="validate(this)" class="validateMe"><span style="color: red;"> *</span></td>
		</tr>
		
		<tr>
		<th>Screen Name</th>
		<td><input type="text" name="screenName" value="<%=s.getScreenName() %>" onblur="validate(this)" class="validateMe"><span style="color: red;"> *</span></td>
		</tr>
		
		<tr>
		<th>Show Date</th>
		<td><input type="date" name="showDate" value="<%=s.getShowDate() %>" onblur="validate(this)" class="validateMe"><span style="color: red;"> *</span></td>
		</tr>
		
		<tr>
		<th>Start Time</th>
		<td><input type="time" name="startTime" value="<%=s.getStartTime() %>" onblur="validate(this)" class="validateMe"><span style="color: red;"> *</span></td>
		</tr>
		
		<tr>
		<th>End Time</th>
		<td><input type="time" name="endTime" value="<%=s.getEndTime() %>" onblur="validate(this)" class="validateMe"><span style="color: red;"> *</span></td>
		</tr>
		
		<tr>
		<th>Ticket Price</th>
		<td><input type="number" name="ticketPrice" value="<%=s.getTicketPrice() %>" onblur="validate(this)" class="validateMe"><span style="color: red;"> *</span></td>
		</tr>
		
		<tr>
		<td><input type="reset" value="Clear" class="btn btn-outline-warning"></td>
		<td><input type="submit" value="Update" onclick="return validateAll()" class="btn btn-outline-success"></td>
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