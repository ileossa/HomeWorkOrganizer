package com.ileossa.hwo;

import com.ileossa.hwo.model.UserModel;
import com.ileossa.hwo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.util.FileSystemUtils;


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

    @Bean
    CommandLineRunner init() {
        return (args) -> {
            FileSystemUtils.deleteRecursively(new File(FileUploadController.ROOT));

            Files.createDirectory(Paths.get(FileUploadController.ROOT));


        };
    }



}
