<%@page import="com.movie.pojo.Movie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
        function validate(element) {
                
                if(element.value == "" && element.name == "MovieId") {
                    element.nextSibling.innerHTML=" This field is mandatory";
                    return false;
                }
                else if(element.value == "" && element.name == "theatre_Location") {
                    element.nextSibling.innerHTML=" This field is mandatory";
                    return false;
                }
                else if(element.value == "" && element.name == "screenName") {
                    element.nextSibling.innerHTML=" This field is mandatory";
                    return false;
                }
                else if(element.value == "" && element.name == "showDate") {
                    element.nextSibling.innerHTML=" This field is mandatory";
                    return false;
                }
                else if(element.value == "" && element.name == "startTime") {
                    element.nextSibling.innerHTML=" This field is mandatory";
                    return false;
                }
                else if(element.value == "" && element.name == "endTime") {
                    element.nextSibling.innerHTML=" This field is mandatory";
                    return false;
                }
                else if(element.value == "" && element.name == "ticketPrice") {
                    element.nextSibling.innerHTML=" This field is mandatory";
                    return false;
                }
                else{
                    element.nextSibling.innerHTML="*";
                }
            }
        
        function validateAll() {
            var a = document.getElementsByClassName("validateMe");
            var flag = true;
            
            for(var i=0; i<a.length; i++) {
                var element = a[i];
                flag = validate(element);
                if(flag==false)
                    break;
        }
        return flag;
    }
    </script>
</head>
<body>
<%
List<Movie> mlist=(List<Movie>)session.getAttribute("mlist");
%>
<jsp:include page="Header.jsp"></jsp:include>

<!-- main Content if any -->
	<section class="py-5">
	<div class="container bg-white">
		<div class="moviecontainer">
		<div class="container" style="padding: 30px">
		<jsp:include page="Message.jsp"></jsp:include>
		
		<form action="ShowServlet" method="post">
		<input type="hidden" name="process" value="addShowDetails">
		
		<table style="text-align: center;" class="table table-success">
		<tr>
		<th>Movie Id</th>
		<td>
		<select name="movieId">
		<%for(Movie m:mlist){ %>
		<option value="<%= m.getMovieId() %>"><%= m.getMovieName() %></option>
		<%} %>
		</select>
		</td>
		</tr>
		
		<tr>
		<th>Theatre and Location</th>
		<td><input type="text" name="theatre_Location" onblur="validate(this)" class="validateMe"><span style="color: red;"> *</span></td>
		</tr>
		
		<tr>
		<th>Screen Name</th>
		<td><input type="text" name="screenName" onblur="validate(this)" class="validateMe"><span style="color: red;"> *</span></td>
		</tr>
		
		<tr>
		<th>Show Date</th>
		<td><input type="date" name="showDate" onblur="validate(this)" class="validateMe"><span style="color: red;"> *</span></td>
		</tr>
		
		<tr>
		<th>Start Time</th>
		<td><input type="time" name="startTime" onblur="validate(this)" class="validateMe"><span style="color: red;"> *</span></td>
		</tr>
		
		<tr>
		<th>End Time</th>
		<td><input type="time" name="endTime" onblur="validate(this)" class="validateMe"><span style="color: red;"> *</span></td>
		</tr>
		
		<tr>
		<th>Ticket Price</th>
		<td><input type="number" name="ticketPrice" onblur="validate(this)" class="validateMe"><span style="color: red;"> *</span></td>
		</tr>
		
		<tr>
		<td><input type="reset" value="Clear" class="btn btn-outline-warning"></td>
		<td><input type="submit" value="Add" onclick="return validateAll()" class="btn btn-outline-success"></td>
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