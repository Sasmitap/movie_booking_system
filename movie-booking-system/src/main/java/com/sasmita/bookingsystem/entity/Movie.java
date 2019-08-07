package com.sasmita.bookingsystem.entity;

import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="MovieDetails")
public class Movie implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Movie_Id", length=10)
	private int movieId;
	
	@Column(name="Movie_Name", length=150)
	private String movieName;
	
	@Column(name="Language", length=150)
	private String language;
	
	@Column(name="Movie_Time", length=10)
	private Time movieTiming;
	
	@ManyToOne
	@JoinColumn(name="Theatre_Id", nullable=false)
	private Theatre theatre;
	
	@OneToMany(mappedBy = "movieInfo", fetch=FetchType.EAGER)
	private List<BookingInfo> bookingList;
	
	@Transient
	private int cityId;
	
	@Transient
	private String cityName;
	
	@Transient
	private Time stratTime;
	
	@Transient
	private Time endTime;

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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Time getMovieTiming() {
		return movieTiming;
	}

	public void setMovieTiming(Time movieTiming) {
		this.movieTiming = movieTiming;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	
	public List<BookingInfo> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<BookingInfo> bookingList) {
		this.bookingList = bookingList;
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
	
	public Time getStratTime() {
		return stratTime;
	}

	public void setStratTime(Time stratTime) {
		this.stratTime = stratTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language + ", movieTiming="
				+ movieTiming + ", theatre=" + theatre + ", bookingList=" + bookingList + "]";
	}

	
}
