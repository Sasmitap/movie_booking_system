package com.sasmita.bookingsystem.config;

import com.sasmita.bookingsystem.exceptionhandler.ResourceNotFoundException;

public class BookingNotFoundException extends ResourceNotFoundException{

	private static final long serialVersionUID = 1L;

	public BookingNotFoundException(String resourceType, String keyName, String keyValue) {
		super("Booking", "Not Found", keyValue);
	}

}
