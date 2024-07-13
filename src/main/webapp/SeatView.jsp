<%@page import="com.movie.dao.CustomerDaoImpl"%>
<%@page import="com.movie.pojo.Customer"%>
<%@page import="com.movie.pojo.Movie"%>
<%@page import="com.movie.pojo.Show"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/seatingcss.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/seatingjs.js"></script>

<script type="text/javascript">
		function confirmSelection() {
			$(".seatStructure").hide();
			$(".displayerBoxes").show();

			var selectedSeats = $("input:checked");

			var seats = "";
			for (var i = 0; i < selectedSeats.length; i++) {
				if (i != selectedSeats.length - 1)
					seats = seats + selectedSeats[i].value + ",";
				else
					seats = seats + selectedSeats[i].value;
			}

			$("#seatsDisplay").val(seats);
			var noOfSeats = selectedSeats.length;
			var ticketPrice = parseInt(document.getElementById("ticketPrice").value);
			$("#total").val(noOfSeats * ticketPrice);
		}
</script>
</head>
<body>
<%
List<String> reservedSeats=(List<String>)session.getAttribute("reservedSeats");
%>
<jsp:include page="Header.jsp"></jsp:include>

<!-- main Content if any -->
	<section class="py-5">
	<div class="container bg-white">
		<div class="moviecontainer">
		<div class="container" style="padding: 30px">
		<jsp:include page="Message.jsp"></jsp:include>
		
		<div class="container"  >
	<div class="seatStructure column" style="margin: 0px auto" >
		<table id="seatsBlock" align="center"style="color:black;">
			<tr>
				<td colspan="14"><div class="screen">SCREEN</div></td>
				<td rowspan="20" style="padding-left: 3rem;">
					<div class="smallBox greenBox">Selected Seat</div> <br />
					<div class="smallBox redBox">Reserved Seat</div> <br />
					<div class="smallBox emptyBox">Empty Seat</div> <br />
				</td>
				<br/>
			</tr>

			<tr>
				<td></td>
				<td>1</td>
				<td>2</td>
				<td>3</td>
				<td>4</td>
				<td>5</td>
				<td></td>
				<td>6</td>
				<td>7</td>
				<td>8</td>
				<td>9</td>
				<td>10</td>
			</tr>
			<%for(char row='A'; row<='M'; row++) {%>
			<tr>
				<td><%= row %></td>
				
				<%for(int i=1; i<=10; i++) {%>
				<%if(reservedSeats!=null && reservedSeats.contains(row+""+i)){ %>
				<td><div class="smallBox redBox"></div></td>
				<%if(i==5){ %>
				<td class="seatGap"></td>
				<%} %>
				<%}else{ %>
				<td><input type="checkbox" class="seats" value="<%= row %><%= i %>"></td>
				<%if(i==5){ %>
				<td class="seatGap"></td>
				<%} %><%--end of if condition --%>
				<%} %>
				<%} %><%--end of inner for loop --%>
				
			</tr>
			<%} %><%--end of outer for loop --%>
			<tr>
			<td align="center" colspan="14"><button  class="csbtn" onclick="confirmSelection()" style="margin: 5px;">Confirm Selection</button></td>
			</tr>
		</table>
	</div>

<%
Show s=(Show)session.getAttribute("s");
Movie m=s.getM();
String email=(String)session.getAttribute("username");
Customer c=new CustomerDaoImpl().searchCustomerByEmail(email);
%>

	<div class="displayerBoxes column " style="margin-top: 50px; display: none;"   >
		<form action="BookingServlet" method="post">
		<input type="hidden" name="process" value="confirmBooking"> 
		<input type="hidden" id="ticketPrice" name="ticketPrice" value="<%=s.getTicketPrice() %>">
		<table class="Displaytable" align="center">
		
			<tr>
				<th>Customer Name :</th>
				<td><%=c.getCname() %></td>
			</tr>
			<tr>
				<th>Show Id :</th>
				<td><input type="text" id="showId" name="showId"
					value="<%=s.getShowId() %>" readonly="readonly"></td>
			</tr>
			<tr>
				<th>Movie :</th>
				<td><%=m.getMovieName() %></td>
			</tr>
			<tr>
				<th>Screen Name :</th>
				<td><%=s.getScreenName() %></td>
			</tr>
			<tr>
				<th>Start Time :</th>
				<td><%=s.getStartTime() %></td>
			</tr>
			<tr>
				<th>End Time :</th>
				<td><%=s.getEndTime() %></td>
			</tr>
			<tr>
				<th>Seat :</th>
				<td><input type="text" id="seatsDisplay" name="seats" readonly="readonly"></textarea></td>
			</tr>
			<tr>
				<th>Total :</th>
				<td><input type="text" id="total" name="totalBill" readonly="readonly"></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="Buy" class="buybtn"></th>
			</tr>
		</table>
		</form>
		<div id="legend"></div>
		<div style="clear: both"></div>
	</div>
	</div>
    </div>
  </div>
</div>
<!-- END PAGE SOURCE -->
		
		</div>
		</div>
		</div>
		</section>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>