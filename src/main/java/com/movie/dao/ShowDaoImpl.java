package com.movie.dao;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.movie.pojo.Movie;
import com.movie.pojo.Show;
import com.movie.utility.DBConnection;

public class ShowDaoImpl implements ShowDao {

	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String sql=null;
	List<Show> slist=null;
	Show s=null;
	Movie m=null;

	@Override
	public boolean addShow(Show s) {

		con=DBConnection.makeConnection();
		sql="insert into shows(movieId, theatre_Location, screenName, showDate, startTime, endTime, ticketPrice) values(? , ? , ? , ? , ? , ? , ?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, s.getMovieId());
			ps.setString(2, s.getTheatre_Location());
			ps.setString(3, s.getScreenName());
			ps.setDate(4, Date.valueOf(s.getShowDate()));
			ps.setString(5, s.getStartTime().toString());
			ps.setString(6, s.getEndTime().toString());
			ps.setDouble(7, s.getTicketPrice());

			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateShow(Show s) {
		con=DBConnection.makeConnection();
		sql="update shows set movieId=?, theatre_Location=?, screenName=?, showDate=?,"
				+ " startTime=?, endTime=?, ticketPrice=? where showId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, s.getMovieId());
			ps.setString(2, s.getTheatre_Location());
			ps.setString(3, s.getScreenName());
			ps.setDate(4, Date.valueOf(s.getShowDate()));
			ps.setString(5, s.getStartTime().toString());
			ps.setString(6, s.getEndTime().toString());
			ps.setDouble(7, s.getTicketPrice());
			ps.setInt(8, s.getShowId());
			int i = ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteShow(Integer showId) {
		con=DBConnection.makeConnection();
		sql="delete from shows where showId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, showId);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Show> searchShowByTheatre(String theatre_Location) {
		con=DBConnection.makeConnection();
		sql="select * from shows where theatre_Location like ?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+theatre_Location+"%");
			rs=ps.executeQuery();
			slist=new ArrayList<>();
			while(rs.next())
			{
				s=new Show();
				s.setMovieId(rs.getInt("movieId"));
				s.setShowId(rs.getInt("showId"));
				s.setTheatre_Location(rs.getString("theatre_Location"));
				s.setScreenName(rs.getString("screenName"));
				s.setStartTime(LocalTime.parse(rs.getString(6)));
				s.setEndTime(LocalTime.parse(rs.getString(7)));
				s.setTicketPrice(rs.getDouble("ticketPrice"));
				s.setShowDate(rs.getDate("showDate").toLocalDate());

				m=new MovieDaoImpl().searchMovieById(rs.getInt(2));
				s.setM(m);
				slist.add(s);
			}
			return slist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Show> searchShowByTime(LocalTime startTime) {
		con=DBConnection.makeConnection();
		sql="select * from shows where startTime=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, startTime.toString());
			rs=ps.executeQuery();
			slist=new ArrayList<>();
			while(rs.next())
			{
				s=new Show();
				s.setMovieId(rs.getInt("movieId"));
				s.setShowId(rs.getInt("showId"));
				s.setTheatre_Location(rs.getString("theatre_Location"));
				s.setScreenName(rs.getString("screenName"));
				s.setStartTime(LocalTime.parse(rs.getString(6)));
				s.setEndTime(LocalTime.parse(rs.getString(7)));
				s.setTicketPrice(rs.getDouble("ticketPrice"));
				s.setShowDate(rs.getDate("showDate").toLocalDate());

				m=new MovieDaoImpl().searchMovieById(rs.getInt(2));
				s.setM(m);
				slist.add(s);
			}
			return slist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Show> searchShowByMovie(String movieName) {
		con=DBConnection.makeConnection();
		sql="select * from shows where movieId=?";
		try {
			ps=con.prepareStatement(sql);
			Integer movieId=new MovieDaoImpl().searchMovieId(movieName);

			if(movieId!=null) {
				ps.setInt(1, movieId);
				rs=ps.executeQuery();
				slist=new ArrayList<>();
				while(rs.next())
				{
					s=new Show();
					s.setMovieId(rs.getInt("movieId"));
					s.setShowId(rs.getInt("showId"));
					s.setTheatre_Location(rs.getString("theatre_Location"));
					s.setScreenName(rs.getString("screenName"));
					s.setStartTime(LocalTime.parse(rs.getString(6)));
					s.setEndTime(LocalTime.parse(rs.getString(7)));
					s.setTicketPrice(rs.getDouble("ticketPrice"));
					s.setShowDate(rs.getDate("showDate").toLocalDate());

					m=new MovieDaoImpl().searchMovieById(rs.getInt(2));
					s.setM(m);
					slist.add(s);
				}
				return slist;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Show> fetchAllShow() {

		con=DBConnection.makeConnection();
		sql="select * from shows";
		try {
			ps=con.prepareStatement(sql);
			slist=new ArrayList<>();
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Show();
				s.setShowId(rs.getInt(1));
				s.setMovieId(rs.getInt(2));
				s.setTheatre_Location(rs.getString(3));
				s.setScreenName(rs.getString(4));
				// converting sql date to java LocalDate by toLocalDate();
				s.setShowDate(rs.getDate(5).toLocalDate());

				s.setStartTime(LocalTime.parse(rs.getString(6)));
				s.setEndTime(LocalTime.parse(rs.getString(7)));

				s.setTicketPrice(rs.getDouble(8));

				m=new MovieDaoImpl().searchMovieById(rs.getInt(2));
				s.setM(m);

				slist.add(s);
			}
			return slist;	
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Show searchShowById(Integer showId) {
		con=DBConnection.makeConnection();
		sql="select * from shows where showId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, showId);
			rs=ps.executeQuery();
			if(rs.next()) {
				s=new Show();
				s.setShowId(rs.getInt(1));
				s.setMovieId(rs.getInt(2));
				s.setTheatre_Location(rs.getString(3));
				s.setScreenName(rs.getString(4));
				// converting sql date to java LocalDate by toLocalDate();
				s.setShowDate(rs.getDate(5).toLocalDate());

				s.setStartTime(LocalTime.parse(rs.getString(6)));
				s.setEndTime(LocalTime.parse(rs.getString(7)));

				s.setTicketPrice(rs.getDouble(8));

				m=new MovieDaoImpl().searchMovieById(rs.getInt(2));
				s.setM(m);
			}
			return s;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public HashMap<Integer, String> searchMovieId(){
		con=DBConnection.makeConnection();
		sql="select movieId, movieName from movie_Booking ";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			Movie m = null;
			HashMap<Integer, String> hm=new HashMap<>();
			while(rs.next()) {
				/*
				 * int movieId=rs.getInt(1); 
				 * String movieName=rs.getString(2); 
				 * hm.put(movieId,movieName);
				 */
				hm.put(rs.getInt(1), rs.getString(2));
			}
			return hm;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteShowOfMovie(Integer movieId) {
		con=DBConnection.makeConnection();
		sql="delete from shows where movieId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, movieId);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public List<Show> SearchShowByMovieid(Integer movieId){
		con=DBConnection.makeConnection();
		sql="select * from shows where movieId=?";
			try {
				ps=con.prepareStatement(sql);
				ps.setInt(1, movieId);
				rs=ps.executeQuery();
				slist=new ArrayList<>();
				while(rs.next()) {
					s=new Show();
					s.setShowId(rs.getInt(1));
					s.setMovieId(rs.getInt(2));
					s.setTheatre_Location(rs.getString(3));
					s.setScreenName(rs.getString(4));
					// converting sql date to java LocalDate by toLocalDate();
					s.setShowDate(rs.getDate(5).toLocalDate());

					s.setStartTime(LocalTime.parse(rs.getString(6)));
					s.setEndTime(LocalTime.parse(rs.getString(7)));

					s.setTicketPrice(rs.getDouble(8));

					m=new MovieDaoImpl().searchMovieById(rs.getInt(2));
					s.setM(m);
					
					slist.add(s);
				}
				return slist;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}

}
