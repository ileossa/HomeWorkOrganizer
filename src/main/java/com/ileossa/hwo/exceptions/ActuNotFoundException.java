package com.ileossa.hwo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by kevin on 12/07/2016.
 */

/**
 * L'exception est levé si aucune actualité n'est trouvé dans la base de donnée
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Actualité non trouvé")
public class ActuNotFoundException extends Throwable {

    public ActuNotFoundException() {
        // TODO Auto-generated constructor stub
    }

}