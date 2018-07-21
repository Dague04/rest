package edu.mga.itec.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InfoNotFoundException extends RuntimeException{
	
	public InfoNotFoundException(Long infoId) {
		
		super("could not find User Info '" + infoId + "'.");
	}

}
