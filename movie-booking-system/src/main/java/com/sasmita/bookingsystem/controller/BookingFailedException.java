package com.sasmita.bookingsystem.controller;

import com.sasmita.bookingsystem.exceptionhandler.ResourceNotFoundException;

public class BookingFailedException extends ResourceNotFoundException{

	private static final long serialVersionUID = 1L;

	public BookingFailedException(String resourceType, String keyName, String booking) {
		super("Booking", keyName, "not successful For "+booking);
	}

}
