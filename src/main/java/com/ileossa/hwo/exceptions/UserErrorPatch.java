package com.ileossa.hwo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ileossa on 11/07/16.
 */

/**
 * L'exception est levé si aucune discussion n'est trouvé dans la base de donnée via le repository correspondant
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Error server, patch doesn't work")
public class UserErrorPatch  extends Throwable {

    public UserErrorPatch (){

    }
}
