package com.devops.user.service.UserService.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException()
	{
		super("Resource could not br found on the server.");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
