package com.movie.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.dao.BookingDaoImpl;
import com.movie.dao.ShowDaoImpl;
import com.movie.pojo.Booking;
import com.movie.pojo.Show;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Booking b;
	List<Booking> blist;
	BookingDaoImpl bimpl=new BookingDaoImpl();
	HttpSession session;
	RequestDispatcher rd;
	Boolean flag;
	String login, msg, errorMsg;

	private Integer bookingId;
	private Integer ShowId;
	private Show s;
	private LocalDateTime bookingDate;
	private String email;
	private String seats;
	private Double totalBill;
	private String status;

	public BookingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session=request.getSession();
		String process=request.getParameter("process");

		if(process!=null && process.equals("bookMyShow")) {
			ShowId=Integer.parseInt(request.getParameter("showId"));
			Show s=new ShowDaoImpl().searchShowById(ShowId);
			List<String> reservedSeats=bimpl.getReservedSeats(ShowId);
			session.setAttribute("reservedSeats", reservedSeats);
			session.setAttribute("s", s);
			response.sendRedirect("SeatView.jsp");
		}
		else if(process!=null && process.equals("myBookingHistory")) {
			email=(String)session.getAttribute("username");
			blist=bimpl.displayMyBookingHistory(email);
			for(Booking b1:blist){
				LocalDate showDate=b1.getS().getShowDate();
				Integer bookId=b1.getBookingId();
				bimpl.changeStatus(bookId, showDate);
			}
			session.setAttribute("blist", blist);
			response.sendRedirect("BookingList.jsp");
		}
		else if(process!=null && process.equals("cancelBooking")){
			bookingId=Integer.parseInt(request.getParameter("bookId"));
			flag=bimpl.cancelMyShow(bookingId);
			if(flag) 
				request.setAttribute("errorMsg", "your booking has been cancelled");
			else 
				request.setAttribute("errorMsg", "Error while cancelling your booking");
			
			email=(String)session.getAttribute("username");
			blist=bimpl.displayMyBookingHistory(email);

			session.setAttribute("blist", blist);
			rd=request.getRequestDispatcher("BookingList.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session=request.getSession();
		String process=request.getParameter("process");
		if(process!=null && process.equals("confirmBooking")) {
			ShowId=Integer.parseInt(request.getParameter("showId"));
			email=(String)session.getAttribute("username");
			seats=request.getParameter("seats");
			totalBill=Double.parseDouble(request.getParameter("totalBill"));

			b=new Booking();
			b.setEmail(email);
			b.setShowId(ShowId);
			b.setSeats(seats);
			b.setTotalBill(totalBill);

			Booking b1=bimpl.bookMyShow(b);
			if(b1!=null) {
				request.setAttribute("b1", b1);
				request.setAttribute("msg", "Your ticket has been booked Enjoy!!!");
				rd=request.getRequestDispatcher("Ticket.jsp");
				rd.forward(request, response);
			}
		}

	}

}
