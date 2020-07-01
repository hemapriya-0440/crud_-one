package com.example.crudEx1.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class usernotfoundException extends RuntimeException {

	public usernotfoundException(String message) {
		super(message);
	}

}
