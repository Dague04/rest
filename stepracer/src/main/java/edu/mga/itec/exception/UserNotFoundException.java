package edu.mga.itec.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(String userId) {
		super("could not find user '" + userId + "'.");
	}

}
