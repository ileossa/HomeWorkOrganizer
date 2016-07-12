package com.ileossa.hwo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ileossa on 11/07/16.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Error server, patch doesn't work")
public class UserErrorPatch  extends Throwable {

    public UserErrorPatch (){

    }
}
