package com.ileossa.hwo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by kevin on 15/07/2016.
 */

/**
 * L'exception est levé si aucune discussion n'est trouvé dans la base de donnée via le repository correspondant
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Discussion non trouvé")
public class DiscussionNotFroundException  extends Throwable {

    public DiscussionNotFroundException() {
        // TODO Auto-generated constructor stub
    }
}
