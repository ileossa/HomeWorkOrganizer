package com.ileossa.hwo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ileossa on 13/07/16.
 */

/**
 * L'exception est levé si aucune discussion n'est trouvé dans la base de donnée via le repository correspondant
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "failed upload file")
public class FailToUploadException extends Throwable {

    public FailToUploadException(){

    }
}
