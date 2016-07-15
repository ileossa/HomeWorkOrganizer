package com.ileossa.hwo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by kevin on 15/07/2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Discussion non trouvé")
public class DiscussionNotFroundException  extends Throwable {

    public DiscussionNotFroundException() {
        // TODO Auto-generated constructor stub
    }
}
