package com.sasmita.bookingsystem.controller;

import com.sasmita.bookingsystem.exceptionhandler.ResourceNotFoundException;

public class MovieNotFoundException extends ResourceNotFoundException{
	private static final long serialVersionUID = 1L;

	public MovieNotFoundException(String resourceType, String keyName, String movieName) {
		super("Movie", "Not Found", movieName);
	}

}
