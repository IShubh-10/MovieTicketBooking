package com.movie.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.dao.MovieDaoImpl;
import com.movie.pojo.Movie;
import com.mysql.cj.Session;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Movie m;
	List<Movie> mlist;
	MovieDaoImpl mimpl=new MovieDaoImpl();
	HttpSession session;
	RequestDispatcher rd;
	Boolean flag;
	String login, msg, errorMsg;

	private Integer movieId;
	private String movieName;
	private String director;
	private String producer;
	private String cast;
	private LocalDate releaseDate;
	private String lang;

	public MovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session=request.getSession();
		String process=request.getParameter("process");
		if(process!=null && process.equals("allMovies")) {
			mlist=mimpl.fetchallMovies();

			if(mlist!=null && mlist.isEmpty()!=true) {
				session.setAttribute("mlist", mlist);
				response.sendRedirect("AllMovies.jsp");
			}
			else {
				errorMsg="Sorry no movies to display currently!! please try again";
				request.setAttribute("errorMsg", errorMsg);
				rd=request.getRequestDispatcher("Index.jsp");
				rd.forward(request, response);
			}
		}
		else if(process!=null && process.equals("updateMovie")) {
			movieId=Integer.parseInt(request.getParameter("movieId"));
			m=mimpl.searchMovieById(movieId);
			request.setAttribute("movieObj", m);
			rd=request.getRequestDispatcher("UpdateMovie.jsp");
			rd.forward(request, response);
		}
		else if(process!=null && process.equals("deleteMovie")) {
			movieId=Integer.parseInt(request.getParameter("movieId"));
			flag=mimpl.deleteMovie(movieId);
			if(flag) {
				msg="Movie deleted successfully...";
				request.setAttribute("msg", msg);

				mlist=mimpl.fetchallMovies();
				if(mlist!=null && mlist.isEmpty()!=true) {
					session.setAttribute("mlist", mlist);
					rd=request.getRequestDispatcher("AllMovies.jsp");
					rd.forward(request, response);
				}
				else {
					errorMsg="Sorry no movies to display currently!! please try again";
					request.setAttribute("errorMsg", errorMsg);
					rd=request.getRequestDispatcher("Index.jsp");
					rd.forward(request, response);
				}
			}
			else {
				errorMsg="Error while deleting the movie...";
				request.setAttribute("errorMsg", errorMsg);

				mlist=mimpl.fetchallMovies();
				if(mlist!=null && mlist.isEmpty()!=true) {
					session.setAttribute("mlist", mlist);
					rd=request.getRequestDispatcher("AllMovies.jsp");
					rd.forward(request, response);
				}
				else {
					errorMsg="Sorry no movies to display currently!! please try again";
					request.setAttribute("errorMsg", errorMsg);
					rd=request.getRequestDispatcher("Index.jsp");
					rd.forward(request, response);
				}
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session=request.getSession();
		String process=request.getParameter("process");

		if(process!=null && process.equals("editMovie")) {
			movieId=Integer.parseInt(request.getParameter("movieId"));
			movieName=request.getParameter("movieName");
			director=request.getParameter("director");
			producer=request.getParameter("producer");
			cast=request.getParameter("cast");
			releaseDate=LocalDate.parse(request.getParameter("releaseDate"));
			lang=request.getParameter("lang");

			m=new Movie(movieId, movieName, director, producer, cast, releaseDate, lang);
			flag=mimpl.updateMovie(m);
			if(flag) {
				msg="Movie updated successfully...";
				request.setAttribute("msg", msg);

				mlist=mimpl.fetchallMovies();
				if(mlist!=null && mlist.isEmpty()!=true) {
					session.setAttribute("mlist", mlist);
					rd=request.getRequestDispatcher("AllMovies.jsp");
					rd.forward(request, response);
				}
				else {
					errorMsg="Sorry no movies to display currently, please try again later...";
					request.setAttribute("errorMsg", errorMsg);
					rd=request.getRequestDispatcher("Index.jsp");
					rd.forward(request, response);
				}
			}
			else {
				errorMsg="Error while updating the movie details...";
				request.setAttribute("errorMsg", errorMsg);

				mlist=mimpl.fetchallMovies();
				if(mlist!=null && mlist.isEmpty()!=true) {
					session.setAttribute("mlist", mlist);
					rd=request.getRequestDispatcher("AllMovies.jsp");
					rd.forward(request, response);
				}
				else {
					errorMsg="Sorry no movies to display currently, please try again later...";
					request.setAttribute("errorMsg", errorMsg);
					rd=request.getRequestDispatcher("Index.jsp");
					rd.forward(request, response);
				}
			}
		}
		
		else if(process!=null && process.equals("addMovie")) {
			//movieId=Integer.parseInt(request.getParameter("movieId"));
			movieName=request.getParameter("movieName");
			director=request.getParameter("director");
			producer=request.getParameter("producer");
			cast=request.getParameter("cast");
			releaseDate=LocalDate.parse(request.getParameter("releaseDate"));
			lang=request.getParameter("lang");

			m=new Movie(movieName, director, producer, cast, releaseDate, lang);
			flag=mimpl.addMovie(m);
			if(flag) {
				msg="Movie added successfully...";
				request.setAttribute("msg", msg);

				mlist=mimpl.fetchallMovies();
				if(mlist!=null && mlist.isEmpty()!=true) {
					session.setAttribute("mlist", mlist);
					rd=request.getRequestDispatcher("AllMovies.jsp");
					rd.forward(request, response);
				}
				else {
					errorMsg="Sorry no movies to display currently, please try again later...";
					request.setAttribute("errorMsg", errorMsg);
					rd=request.getRequestDispatcher("Index.jsp");
					rd.forward(request, response);
				}
			}
			else {
				errorMsg="Error while adding the movie details...";
				request.setAttribute("errorMsg", errorMsg);

				mlist=mimpl.fetchallMovies();
				if(mlist!=null && mlist.isEmpty()!=true) {
					session.setAttribute("mlist", mlist);
					rd=request.getRequestDispatcher("AllMovies.jsp");
					rd.forward(request, response);
				}
				else {
					errorMsg="Sorry no movies to display currently, please try again later...";
					request.setAttribute("errorMsg", errorMsg);
					rd=request.getRequestDispatcher("Index.jsp");
					rd.forward(request, response);
				}
			}
		}
	}
}
