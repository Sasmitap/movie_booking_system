package com.sasmita.bookingsystem.controller;

import com.sasmita.bookingsystem.exceptionhandler.ResourceNotFoundException;

public class TheatreNotFoundException extends ResourceNotFoundException {

	
	private static final long serialVersionUID = 1L;

	public TheatreNotFoundException(String resourceType, String keyName, String cityName) {
		super("Theater ", "NotFound ", cityName);
	}

}
