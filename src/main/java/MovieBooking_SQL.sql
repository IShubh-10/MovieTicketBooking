CREATE DATABASE movieBooking;
USE movieBooking;
CREATE TABLE movie_Booking (
   movieId int NOT NULL AUTO_INCREMENT,
   movieName varchar(100) DEFAULT NULL,
   director varchar(50) DEFAULT NULL,
   producer varchar(50) DEFAULT NULL,
   cast varchar(200) DEFAULT NULL,
   releaseDate date DEFAULT NULL,
   lang varchar(50) DEFAULT NULL,
   PRIMARY KEY (movieId) );
   DROP TABLE movie_Booking;
  SELECT * FROM movie_Booking;
  
  CREATE TABLE customer (
  cId int PRIMARY KEY AUTO_INCREMENT,
  cname VARCHAR(100),
  email VARCHAR(100) UNIQUE KEY,
  password VARCHAR(100) UNIQUE KEY,
  contactNo BIGINT UNIQUE KEY,
  age INT,
  gender VARCHAR(10));
  SELECT * FROM customer;

  CREATE TABLE shows (
  showId INT PRIMARY KEY AUTO_INCREMENT,
  movieId INT(10) DEFAULT NULL,
  theatre_Location VARCHAR(200),
  screenName VARCHAR(200),
  showDate DATE,
  startTime VARCHAR(20),
  endTime VARCHAR(20),
  ticketPrice DOUBLE(15,2),
  FOREIGN KEY(movieId) REFERENCES movie_Booking(movieId));
  SELECT * FROM shows;
  
  CREATE TABLE Booking (
  bookId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  showId INT DEFAULT NULL,
  bookingDate DATETIME DEFAULT NULL,
  email VARCHAR(100) DEFAULT NULL,
  seats VARCHAR(50) DEFAULT NULL,
  totalBill DOUBLE(15,2) DEFAULT NULL,
  FOREIGN KEY (showID) REFERENCES shows (showId));
  SELECT * FROM Booking;
  
  CREATE TABLE admin01 (
   adminId INT PRIMARY KEY AUTO_INCREMENT,
   adminEmail VARCHAR(200),
   adminPassword VARCHAR(200));
   SELECT * FROM admin01;
   INSERT INTO admin01(adminEmail , adminPassword) VALUES("coder@gmail.com", "coder123"),("squad@gmail.com","squad123");