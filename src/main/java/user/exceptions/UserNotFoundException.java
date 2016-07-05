package user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @author k.vivor
 * @update ileossa
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "L'utilisateur non trouvé")
public class UserNotFoundException {

	public UserNotFoundException() {
		// TODO Auto-generated constructor stub
	}

}
