package com.sasmita.bookingsystem.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="BookingDetails")
public class BookingInfo implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Booking_Id", length=10)
	private int bookingId;
	
	@Column(name="Movie_Time", length=10)
	private Time movieTiming;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Booked_Date", length=30)
	private Date bookedDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Event_Date", length=30)
	private Date eventDate;
	
	@ManyToOne
	@JoinColumn(name="User_Id", nullable=false)
	private UserInfo userInfo;
	
	@ManyToOne
	@JoinColumn(name="Theatre_Id", nullable=false)
	private Theatre theatreInfo;
	
	@ManyToOne
	@JoinColumn(name="Movie_Id", nullable=false)
	private Movie movieInfo;
	
	@Column(name="BookingStatus", length=10)
	private String bookingStatus;
	
	@Transient
	private int userId;
	
	@Transient
	private int theatreId;
	
	@Transient
	private String theatreName;
	
	@Transient
	private int movieId;
	
	@Transient
	private String movieName;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Time getMovieTiming() {
		return movieTiming;
	}

	public void setMovieTiming(Time movieTiming) {
		this.movieTiming = movieTiming;
	}

	public Date getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Theatre getTheatreInfo() {
		return theatreInfo;
	}

	public void setTheatreInfo(Theatre theatreInfo) {
		this.theatreInfo = theatreInfo;
	}

	public Movie getMovieInfo() {
		return movieInfo;
	}

	public void setMovieInfo(Movie movieInfo) {
		this.movieInfo = movieInfo;
	}
	
	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "BookingInfo [bookingId=" + bookingId + ", movieTiming=" + movieTiming + ", bookedDate=" + bookedDate
				+ ", eventDate=" + eventDate + ", userInfo=" + userInfo + ", theatreInfo=" + theatreInfo
				+ ", movieInfo=" + movieInfo + ", bookingStatus=" + bookingStatus + "]";
	}

}
