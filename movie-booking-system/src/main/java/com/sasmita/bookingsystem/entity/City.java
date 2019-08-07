package com.sasmita.bookingsystem.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CityDetails")
public class City implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="City_Id", length=10)
	private int cityId;
	
	@Column(name="City_Name", length=150)
	private String name;
	
	@Column(name="State", length=150)
	private String state;
	
	@OneToMany(mappedBy="city")
	private List<Theatre> theaterList;

	public List<Theatre> getTheaterList() {
		return theaterList;
	}

	public void setTheaterList(List<Theatre> theaterList) {
		this.theaterList = theaterList;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", name=" + name + ", state=" + state + ", theaterList=" + theaterList + "]";
	}

}
