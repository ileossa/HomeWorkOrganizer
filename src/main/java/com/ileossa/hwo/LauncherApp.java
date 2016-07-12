package com.ileossa.hwo;

import com.ileossa.hwo.model.UserModel;
import com.ileossa.hwo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 * @author ileossa
 *
 */


@SpringBootApplication
public class LauncherApp {

	private static final Logger log = LoggerFactory.getLogger(LauncherApp.class);

	public static void main(String[] args) {
		SpringApplication.run(LauncherApp.class);
	}


	/*@Bean
	public CommandLineRunner demo(UserRepository userRepository) {
		return (args) -> {
			userRepository.save(new UserModel("pseudo", "email", "password", "group", "role", true));
            userRepository.save(new UserModel("pseudoqsqscqsc", "emaiqscsl", "paqsscqscsword", "gqcroup", "rqcqsole", false));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (UserModel hall : userRepository.findAll()) {
				log.info( hall.toString());
			}
			log.info("");

            // fetch an individual customer by ID
            UserModel customer = userRepository.findOne(1L);
            log.info("Customers found with findOne(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customers found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            for (UserModel bauer : userRepository.findByPseudo("pseudo")) {
                log.info(bauer.toString());
            }
            log.info("");
		};
	}*/

}
