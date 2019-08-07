package com.sasmita.bookingsystem.model;

import java.sql.Time;

import org.springframework.stereotype.Component;

@Component
public class MovieDetailsModel {
	
	private int movieId;
	private String movieName;
	private Time time;
	private String language;
	private String theatreName;
	private int theatreId;
	private int cityId;
	private String cityName;
	private int noOfSeats;
	
	public MovieDetailsModel() {
		super();
	}

	public MovieDetailsModel(int movieId, String movieName, Time time, String language, String theatreName,
			int theatreId, int cityId, String cityName, int noOfSeats) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.time = time;
		this.language = language;
		this.theatreName = theatreName;
		this.theatreId = theatreId;
		this.cityId = cityId;
		this.cityName = cityName;
		this.noOfSeats = noOfSeats;
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

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
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

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	@Override
	public String toString() {
		return "MovieDetailsModel [movieId=" + movieId + ", movieName=" + movieName + ", time=" + time + ", language="
				+ language + ", theatreName=" + theatreName + ", theatreId=" + theatreId + ", cityId=" + cityId
				+ ", cityName=" + cityName + ", noOfSeats=" + noOfSeats + "]";
	}
	
}
