package com.sasmita.bookingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SeatDetails")
public class Seat  implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Seat_Id", length=10)
	private int seatId;
	
	@Column(name="TotalNoOfSeat", length=150)
	private int totalNoOfSeat;
	
	@Column(name="AvailableNoOfSeat", length=150)
	private int availableNoOfSeat;
	
	@Column(name="BookedNoOfSeat", length=150)
	private int bookedNoOfSeat;
	
	@OneToOne
	@JoinColumn(name = "Theatre_Id", nullable = false)
	private Theatre theatre;

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public int getTotalNoOfSeat() {
		return totalNoOfSeat;
	}

	public void setTotalNoOfSeat(int totalNoOfSeat) {
		this.totalNoOfSeat = totalNoOfSeat;
	}

	public int getAvailableNoOfSeat() {
		return availableNoOfSeat;
	}

	public void setAvailableNoOfSeat(int availableNoOfSeat) {
		this.availableNoOfSeat = availableNoOfSeat;
	}

	public int getBookedNoOfSeat() {
		return bookedNoOfSeat;
	}

	public void setBookedNoOfSeat(int bookedNoOfSeat) {
		this.bookedNoOfSeat = bookedNoOfSeat;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	
}
