package eu.ensup.springbootjpaweb;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import eu.ensup.springbootjpaweb.controller.FormationController;
import eu.ensup.springbootjpaweb.service.FormationService;

@SpringBootApplication
@RestController
public class jpawebApplication {
	
	@RequestMapping("/")
	public String home() {
		return "Bienvenue";
	}
	
	@RequestMapping("/toto")
	public String accueilToto() {
		return "Bienvenue Toto";
	}
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(jpawebApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.servlet.context-path", "/formationList"));
		app.run(args);
	}

}
