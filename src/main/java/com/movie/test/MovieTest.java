package com.movie.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.movie.dao.MovieDaoImpl;
import com.movie.pojo.Movie;

public class MovieTest {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Movie m=null;
		MovieDaoImpl mimpl=new MovieDaoImpl();
		List<Movie> mlist;
		
		Integer movieId;
		String movieName;
		String director;
		String producer;
		String cast;
		LocalDate releaseDate;
		String lang;
		int day, month, year;
		boolean flag;
		
		System.out.println("*********Welcome to our Movie Booking Portal*********");
		while(true)
		{
			System.out.println("Enter the number given in options...");
			System.out.println("Enter 1---> Add Movie");
			System.out.println("Enter 2---> All Movies");
			System.out.println("Enter 3---> Update movie details");
			System.out.println("Enter 4---> Delete Movie");
			System.out.println("Enter 5---> Search movie by Director");
			System.out.println("Enter 6---> Search movie by Cast");
			System.out.println("Enter 7---> Search movie by Language");
			System.out.println("Enter 8---> E X I T");
			
			
			int option=sc.nextInt();
			sc.nextLine();
			
			switch(option)
			{
			case 1:
				System.out.print("Enter name of movie:");
				movieName=sc.nextLine();
				
				System.out.print("Enter director:");
				director=sc.nextLine();
				
				System.out.print("Enter producer:");
				producer=sc.nextLine();
				
				System.out.print("Enter cast:");
				cast=sc.nextLine();
				
				System.out.print("Enter day of release. Number between 1 to 31 only: ");
				day=sc.nextInt();
				sc.nextLine();
				
				System.out.print("Enter month of release. Number between 1 to 12 only: ");
				month=sc.nextInt();
				sc.nextLine();
				
				System.out.print("Enter year of release: ");
				year=sc.nextInt();
				sc.nextLine();
				
				releaseDate=LocalDate.of(year, month, day);
				
				System.out.print("Enter Language: ");
				lang=sc.nextLine();

				m=new Movie(movieName, director, producer, cast, releaseDate, lang);
				
				flag=mimpl.addMovie(m);
				
				if(flag)
				{
					System.out.print("Movie added successfully!!! ");
				}
				else 
				{
					System.out.print("Error while adding movie details! ");
				}
				break;
			case 2:
				mlist=mimpl.fetchallMovies();
				
				if(mlist!=null && !mlist.isEmpty())
				{
					
					mlist.forEach(x->{
						if(x!=null)
						{
							System.out.println(x);
							System.out.println("------------------------------------");
						}
					});
				}
				
				break;
			case 3:
				System.out.println("Enter movie id: ");
				movieId=sc.nextInt();
				sc.nextLine();
				
				m=mimpl.searchMovieById(movieId);
				
				if(m!=null)
				{
					System.out.println(m);
					System.out.println("DO you want to continue updating? Answer yes or no");
					String choice=sc.next().toLowerCase();
					sc.nextLine();
					
					if(choice.equals("yes")) 
					{
						System.out.print("Enter name of movie:");
						movieName=sc.nextLine();
						
						System.out.print("Enter director:");
						director=sc.nextLine();
						
						System.out.print("Enter producer:");
						producer=sc.nextLine();
						
						System.out.print("Enter cast:");
						cast=sc.nextLine();
						
						System.out.print("Enter day of release. Number between 1 to 31 only: ");
						day=sc.nextInt();
						sc.nextLine();
						
						System.out.print("Enter month of release. Number between 1 to 12 only: ");
						month=sc.nextInt();
						sc.nextLine();
						
						System.out.print("Enter year of release: ");
						year=sc.nextInt();
						sc.nextLine();
						
						releaseDate=LocalDate.of(year, month, day);
						
						System.out.print("Enter Language: ");
						lang=sc.nextLine();
						
						m.setCast(cast);
						m.setDirector(director);
						m.setlang(lang);
						m.setMovieId(movieId);
						m.setMovieName(movieName);
						m.setProducer(producer);
						m.setReleaseDate(releaseDate);
						
						flag=mimpl.updateMovie(m);
						if(flag)	
						{
							System.out.println("Movie updated Successfully!!");
						}
						else
						{
							System.out.println("Error while updating!");
						}
					}
					else if(choice.equals("no")) 
					{
						System.out.println("Thank-you for your response. Continue Browsing..");
					}
					else 
					{
						System.out.println("Invalid input. Please try again.");
					}
				}
				else
				{
					System.out.println("No such movie found!");
				}
				
				break;
				
			case 4:
				
				System.out.println("Enter movie id: ");
				movieId=sc.nextInt();
				sc.nextLine();
				
				m=mimpl.searchMovieById(movieId);
				
				if(m!=null)
				{
					System.out.println(m);
					System.out.println("DO you want to continue Deleting? Answer yes or no");
					String choice=sc.next().toLowerCase();
					sc.nextLine();
					
					if(choice.equals("yes")) 
					{
						flag=mimpl.deleteMovie(movieId);
						if(flag)
						{
							System.out.println("Movie Deleted Successfully!");
						}
						else
						{
							System.out.println("Error while deleting movie");
						}
					}
					else if(choice.equals("no")) 
					{
						System.out.println("Thank-you for your response. Continue Browsing..");
					}
					else 
					{
						System.out.println("Invalid input. Please try again.");
					}
				}
				else
				{
					System.out.println("No such movie found!");
				}
								
				break;
				
			case 5:
				System.out.println("Enter Director Name: ");
				director=sc.nextLine();
				mlist=mimpl.searchMovieByDirector(director);
				if(mlist!=null && mlist.isEmpty()!=true)
				{
					for(Movie m1:mlist)
					{
						System.out.println("m1");
						System.out.println("------------------------------------------------------------");
					}
				}
					
				break;
				
			case 6:
				System.out.println("Enter Cast Name: ");
				cast=sc.nextLine();
				mlist=mimpl.searchMovieByCast(cast);
				if(mlist!=null && mlist.isEmpty()!=true)
				{
					for(Movie m1:mlist)
					{
						System.out.println("m1");
						System.out.println("------------------------------------------------------------");
					}
				}
				break;
				
			case 7:
				System.out.println("Enter Language: ");
				lang=sc.nextLine();
				mlist=mimpl.searchMovieByLanguage(lang);
				if(mlist!=null && mlist.isEmpty()!=true)
				{
					for(Movie m1:mlist)
					{
						System.out.println("m1");
						System.out.println("------------------------------------------------------------");
					}
				}
				break;
			
			case 8 :
				System.out.println("\n\n------ Thank you for visiting , come again soon ------");
				System.exit(0);
				default:System.out.println("Please give valid Input!!!");
			}
	
		}

	}

}
