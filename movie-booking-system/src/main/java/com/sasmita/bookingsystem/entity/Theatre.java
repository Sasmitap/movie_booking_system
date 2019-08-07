package com.sasmita.bookingsystem.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="TheatreDetails")
public class Theatre implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Theatre_Id", length=10)
	private int theatreId;
	
	@Column(name="Theatre_Name", length=150)
	private String name;
	
	@Column(name="NoOfSeats", length=20)
	private int noOfSeats;
	
	@ManyToOne
	@JoinColumn(name="City_Id", nullable=false)
	private City city;
	
	@OneToMany(mappedBy = "theatre")
	private List<Movie> movieList;
	
	@OneToMany(mappedBy = "theatreInfo", fetch=FetchType.EAGER)
	private List<BookingInfo> bookingList;
	
	@OneToOne(mappedBy = "theatre", fetch=FetchType.LAZY)
	private Seat seat;
	
	@Transient
	private int cityId;
	
	@Transient
	private String cityName;

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
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

	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", name=" + name + ", noOfSeats=" + noOfSeats + ", city=" + city
				+ ", movieList=" + movieList + ", bookingList=" + bookingList + ", seat=" + seat + "]";
	}

}
