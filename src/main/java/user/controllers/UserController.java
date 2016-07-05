package user.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import user.exceptions.UserCreateException;
import user.model.UserEnum;
import user.model.UserModel;
import user.repositorys.UserRepository;


/**
 * @author v.lafosse
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(method = POST)
	public void newUser(@RequestParam(value = "pseudo") String pseudo,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "class") String group) throws UserCreateException {
		LOG.debug("Parameters get pseudo: " + pseudo
				+ " , email: " + email
				+ " , password: " + password
				+ " , group: " + group);

		if(userRepository.findOneByEmail(email) != null || userRepository.findOneByPseudo(pseudo) != null)
		{
			throw new UserCreateException();
		}
		else
		{
			String role = UserEnum.ETUDIANT.toString();
			UserModel user = new UserModel(pseudo, email, password, group, role);
			userRepository.save(user);

			LOG.debug("Create new user pseudo: " + pseudo
					+ " , email: " + email
					+ " , password: " + password
					+ " , group: " + group
					+ " , role: " + role);
		}
	}
}
