package com.ileossa.hwo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ileossa on 13/07/16.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "empty file")
public class EmptyFile extends Throwable {
    public EmptyFile(){

    }
}


