package com.movie.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.movie.pojo.Movie;
import com.movie.utility.DBConnection;

public class MovieDaoImpl implements MovieDao {

	Connection con=null;
	PreparedStatement ps=null;
	String sql=null;
	ResultSet rs=null;
	Movie m=null;
	List<Movie> mlist=null;

	@Override
	public boolean addMovie(Movie m) 
	{
		con=DBConnection.makeConnection();
		sql="insert into movie_Booking(movieName, director, producer, cast, releaseDate, lang)"+"values (?, ?, ?, ?, ?, ?)";
		try 
		{
			ps=con.prepareStatement(sql);
			ps.setString(1, m.getMovieName());
			ps.setString(2, m.getDirector());
			ps.setString(3, m.getProducer());
			ps.setString(4, m.getCast());
			/*
			 * Movie object has the release date in local date type
			 * we have to convert it into sql date type in order to store it in table
			 * */
			ps.setDate(5, Date.valueOf(m.getReleaseDate()));
			ps.setString(6, m.getlang());

			int i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateMovie(Movie m) 
	{
		DBConnection.makeConnection();
		sql="update movie_Booking set movieName=?, director=?, producer=?, cast=?, releaseDate=?, lang=? where movieId=?";
		try 
		{
			ps=con.prepareStatement(sql);
			ps.setString(1, m.getMovieName());
			ps.setString(2, m.getDirector());
			ps.setString(3, m.getProducer());
			ps.setString(4, m.getCast());
			ps.setDate(5, Date.valueOf(m.getReleaseDate()));
			ps.setString(6, m.getlang());
			ps.setInt(7, m.getMovieId());

			int i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteMovie(Integer movieId) 
	{
		new ShowDaoImpl().deleteShowOfMovie(movieId);
		
			con=DBConnection.makeConnection();
			sql="delete from movie_Booking where movieId=?";
			try 
			{
				ps=con.prepareStatement(sql);
				ps.setInt(1, movieId);
				int i=ps.executeUpdate();
				if(i>0)
				{
					return true;
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
		return false;
	}

	@Override
	public Movie searchMovieById(Integer movieId) 
	{
		con=DBConnection.makeConnection();
		sql="select * from movie_Booking where movieId=?";
		try 
		{
			ps=con.prepareStatement(sql);
			ps.setInt(1, movieId);

			rs=ps.executeQuery();
			if(rs.next()) 
			{
				m=new Movie();
				m.setMovieId(rs.getInt("movieId"));
				m.setCast(rs.getString("cast"));
				m.setDirector(rs.getString("director"));
				m.setlang(rs.getString("lang"));
				m.setMovieName(rs.getString("movieName"));
				m.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
				m.setProducer(rs.getString("producer"));

				return m;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Movie> searchMovieByDirector(String director) 
	{
		con=DBConnection.makeConnection();
		sql="select * from movie_Booking where director like ?";
		try 
		{
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+director+"%");
			rs=ps.executeQuery();
			mlist=new ArrayList<>();
			while(rs.next())
			{
				m=new Movie();
				m.setMovieId(rs.getInt("movieId"));
				m.setCast(rs.getString("cast"));
				m.setDirector(rs.getString("director"));
				m.setlang(rs.getString("lang"));
				m.setMovieName(rs.getString("movieName"));
				m.setProducer(rs.getString("producer"));
				m.setReleaseDate(rs.getDate("releaseDate").toLocalDate());

				mlist.add(m);
			}
			return mlist;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Movie> searchMovieByLanguage(String lang) 
	{
		con=DBConnection.makeConnection();
		sql="select*from movie_Booking where lang=?";
		try 
		{
			ps=con.prepareStatement(sql);
			ps.setString(1, lang);
			rs=ps.executeQuery();
			mlist=new ArrayList<>();
			while(rs.next())
			{
				m=new Movie();
				m.setMovieId(rs.getInt("movieId"));
				m.setCast(rs.getString("cast"));
				m.setDirector(rs.getString("director"));
				m.setlang(rs.getString("lang"));
				m.setMovieName(rs.getString("movieName"));
				m.setProducer(rs.getString("producer"));
				m.setReleaseDate(rs.getDate("releaseDate").toLocalDate());

				mlist.add(m);
			}
			return mlist;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Movie> searchMovieByCast(String cast) 
	{
		con=DBConnection.makeConnection();
		sql="select*from movie_Booking where cast like ?";
		try 
		{
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+cast+"%");
			rs=ps.executeQuery();
			mlist=new ArrayList<>();
			while(rs.next())
			{
				m=new Movie();
				m.setMovieId(rs.getInt("movieId"));
				m.setCast(rs.getString("cast"));
				m.setDirector(rs.getString("director"));
				m.setlang(rs.getString("lang"));
				m.setMovieName(rs.getString("movieName"));
				m.setProducer(rs.getString("producer"));
				m.setReleaseDate(rs.getDate("releaseDate").toLocalDate());

				mlist.add(m);
			}
			return mlist;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Movie> fetchallMovies() 
	{
		con=DBConnection.makeConnection();
		sql="select*from movie_Booking";
		try 
		{
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			mlist=new ArrayList<>();
			while(rs.next())
			{
				m=new Movie();
				m.setMovieId(rs.getInt("movieId"));
				m.setCast(rs.getString("cast"));
				m.setDirector(rs.getString("director"));
				m.setlang(rs.getString("lang"));
				m.setMovieName(rs.getString("movieName"));
				m.setProducer(rs.getString("producer"));
				m.setReleaseDate(rs.getDate("releaseDate").toLocalDate());

				mlist.add(m);
			}
			return mlist;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}


		return null;
	}

	@Override
	public Integer searchMovieId(String movieName) {
		con=DBConnection.makeConnection();
		sql="select movieId from movie_Booking where movieName=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, movieName);
			rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
