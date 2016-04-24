package com.ileossa;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ileossa.repository")
@EnableSwagger2
@ComponentScan("com")
public class HomeWorkOrganizerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		new SpringApplicationBuilder()
				.bannerMode(Banner.Mode.CONSOLE)
				.sources(HomeWorkOrganizerApplication.class)
				.run(args);
	}

	//--------------------------------------------------------------

	//Swagger init + infos
	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("HWO_")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com"))
				.build();

	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Home Work Organizer")
				.description("Projet annuel ESGI(2016) ")
				.contact("back-end (Vincent L {Ileossa})")
				.license("Back-end de l'application")
				.licenseUrl("prochainement l'url")
				.version("0.1a")
				.build();
	}
}
