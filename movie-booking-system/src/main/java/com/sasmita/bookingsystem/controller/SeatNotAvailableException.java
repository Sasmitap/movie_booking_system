package com.sasmita.bookingsystem.controller;

import com.sasmita.bookingsystem.exceptionhandler.ResourceNotFoundException;

public class SeatNotAvailableException extends ResourceNotFoundException{

	private static final long serialVersionUID = 1L;

	public SeatNotAvailableException(String resourceType, String keyName, String movieName) {
		super("Booking Seat Not Available", keyName, movieName);
	}

}
