package com.sasmita.bookingsystem.model;

import org.springframework.stereotype.Component;


@Component
public class TheatreDetailsModel {
	
	private int theatreId;
	private String theatreName;
	private int noOfSeat;
	private int cityId;
	private String cityName;
	
	
	public TheatreDetailsModel(int theatreId, String theatreName, int noOfSeat, int cityId, String cityName) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.noOfSeat = noOfSeat;
		this.cityId = cityId;
		this.cityName = cityName;
	}
	
	public TheatreDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getNoOfSeat() {
		return noOfSeat;
	}
	public void setNoOfSeat(int noOfSeat) {
		this.noOfSeat = noOfSeat;
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

}
