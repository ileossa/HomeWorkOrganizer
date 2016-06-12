package com.ileossa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by kevin on 12/06/2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "L'utilisateur non trouvé")
public class UserNotFoundException extends RuntimeException {
}
