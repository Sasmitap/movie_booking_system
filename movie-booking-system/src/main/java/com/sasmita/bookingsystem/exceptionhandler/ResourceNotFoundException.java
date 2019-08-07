package com.sasmita.bookingsystem.exceptionhandler;

public class ResourceNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	public ResourceNotFoundException(String resourceType, String keyName, String keyValue) {
		super(resourceType + " with " + keyName + "[" + keyValue + "] not found in the system!");
	}
}
