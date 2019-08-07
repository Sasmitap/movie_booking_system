package com.sasmita.bookingsystem.model;

import java.sql.Time;

import org.springframework.stereotype.Component;

@Component
public class BookingDetailsModel {

	private int userId;
	private String userName;
	private int theatreId;
	private String theatreName;
	private int movieId;
	private String movieName;
	private Time movieTime;
	private String language;
	private int cityId;
	private String cityName;
	private String bookingDate;
	private String eventDate;
	private String bookingStatus;
	private int bookingId;
	
	public BookingDetailsModel() {
		super();
	}
	
	public BookingDetailsModel(int userId, String userName, int theatreId, String theatreName, int movieId,
			String movieName, Time movieTime, String language, int cityId, String cityName, String bookingDate,
			String eventDate, String bookingStatus, int bookingId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieTime = movieTime;
		this.language = language;
		this.cityId = cityId;
		this.cityName = cityName;
		this.bookingDate = bookingDate;
		this.eventDate = eventDate;
		this.bookingStatus = bookingStatus;
		this.bookingId = bookingId;
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Time getMovieTime() {
		return movieTime;
	}
	public void setMovieTime(Time movieTime) {
		this.movieTime = movieTime;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
}
