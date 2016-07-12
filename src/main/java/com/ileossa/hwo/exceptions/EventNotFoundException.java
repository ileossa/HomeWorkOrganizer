package com.ileossa.hwo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by kevin on 12/07/2016.
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Evenement non trouvé")
public class EventNotFoundException  extends Throwable {

    public EventNotFoundException() {
        // TODO Auto-generated constructor stub
    }

}
