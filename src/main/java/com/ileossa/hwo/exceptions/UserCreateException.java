package com.ileossa.hwo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @author v.lafosse
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "fields not found")
public class UserCreateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserCreateException() {

	}

}
