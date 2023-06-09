package com.movie.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.dao.CustomerDaoImpl;
import com.movie.dao.MovieDaoImpl;
import com.movie.dao.ShowDaoImpl;
import com.movie.pojo.Customer;
import com.movie.pojo.Movie;
import com.movie.pojo.Show;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Show s;
	List<Show> slist;
	ShowDaoImpl simpl=new ShowDaoImpl();
	HttpSession session;
	RequestDispatcher rd;
	Boolean flag;
	String login, msg, errorMsg;
	
	private Integer showId;
	private Integer movieId;
	private Movie m;
	private String theatre_Location;
	private String screenName;
	private LocalDate showDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private Double ticketPrice;
	
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session=request.getSession();
		String process=request.getParameter("process");
		if(process!=null && process.equals("addShow")) {
			List<Movie> mlist=new MovieDaoImpl().fetchallMovies();
			session.setAttribute("mlist", mlist);
			response.sendRedirect("AddShow.jsp");
		}
		else if(process!=null && process.equals("showList")) {
			slist=simpl.fetchAllShow();
			session.setAttribute("slist", slist);
			response.sendRedirect("ShowList.jsp");
		}
		else if(process!=null && process.equals("updateShow")) {
			showId=Integer.parseInt(request.getParameter("showId"));
			s=simpl.searchShowById(showId);
			List<Movie> mlist=new MovieDaoImpl().fetchallMovies();
			session.setAttribute("mlist", mlist);
			
			session.setAttribute("showObj", s);
			response.sendRedirect("UpdateShow.jsp");
		}
		else if(process!=null && process.equals("deleteShow")) {
			showId=Integer.parseInt(request.getParameter("showId"));
			flag=simpl.deleteShow(showId);
			if(flag) {
				request.setAttribute("msg", "Show deleted successfully");
				slist=simpl.fetchAllShow();
				session.setAttribute("slist", slist);
				rd=request.getRequestDispatcher("ShowList.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("errorMsg", "Error while deleting show details!!");
				slist=simpl.fetchAllShow();
				session.setAttribute("slist", slist);
				rd=request.getRequestDispatcher("ShowList.jsp");
				rd.forward(request, response);
			}
		}
		else if(process!=null && process.equals("showDetails")) {
			movieId=Integer.parseInt(request.getParameter("movieId"));
			slist=simpl.SearchShowByMovieid(movieId);
			session.setAttribute("slist", slist);
			rd=request.getRequestDispatcher("ShowList.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session=request.getSession();
		String process=request.getParameter("process");
		if(process!=null && process.equals("addShowDetails")) {
			movieId=Integer.parseInt(request.getParameter("movieId"));
			theatre_Location=request.getParameter("theatre_Location");
			screenName=request.getParameter("screenName");
			showDate=LocalDate.parse(request.getParameter("showDate"));
			startTime=LocalTime.parse(request.getParameter("startTime"));
			endTime=LocalTime.parse(request.getParameter("endTime"));
			ticketPrice=Double.parseDouble(request.getParameter("ticketPrice"));
			s=new Show(movieId, m, theatre_Location, screenName, showDate, startTime, endTime, ticketPrice);
			
			flag=simpl.addShow(s);
			if(flag) {
				request.setAttribute("msg", "Show added successfully");
				rd=request.getRequestDispatcher("AddShow.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("errorMsg", "Error while adding show details!!");
				rd=request.getRequestDispatcher("AddShow.jsp");
				rd.forward(request, response);
			}
		}
		else if(process!=null && process.equals("editShow")) {
			movieId=Integer.parseInt(request.getParameter("movieId"));
			theatre_Location=request.getParameter("theatre_Location");
			screenName=request.getParameter("screenName");
			showDate=LocalDate.parse(request.getParameter("showDate"));
			startTime=LocalTime.parse(request.getParameter("startTime"));
			endTime=LocalTime.parse(request.getParameter("endTime"));
			ticketPrice=Double.parseDouble(request.getParameter("ticketPrice"));
			showId=Integer.parseInt(request.getParameter("showId"));
			s=new Show(showId, movieId, m, theatre_Location, screenName, showDate, startTime, endTime, ticketPrice);
			
			flag=simpl.updateShow(s);
			if(flag) {
				request.setAttribute("msg", "Show updated successfully");
				slist=simpl.fetchAllShow();
				session.setAttribute("slist", slist);
				rd=request.getRequestDispatcher("ShowList.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("errorMsg", "Error while updating show details!!");
				slist=simpl.fetchAllShow();
				session.setAttribute("slist", slist);
				rd=request.getRequestDispatcher("ShowList.jsp");
				rd.forward(request, response);
			}
		}
	}

}
