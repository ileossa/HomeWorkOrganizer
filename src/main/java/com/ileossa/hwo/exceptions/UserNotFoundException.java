package com.ileossa.hwo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @author k.vivor
 * @update ileossa
 */

/**
 * L'exception est levé si aucune discussion n'est trouvé dans la base de donnée via le repository correspondant
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "L'utilisateur non trouvé")
public class UserNotFoundException extends Throwable {

	public UserNotFoundException() {
		// TODO Auto-generated constructor stub
	}

}
