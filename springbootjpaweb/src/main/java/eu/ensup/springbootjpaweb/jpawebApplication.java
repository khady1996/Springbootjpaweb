package eu.ensup.springbootjpaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import eu.ensup.springbootjpaweb.service.FormationController;

@SpringBootApplication

public class jpawebApplication {

	public static void main(String[] args) {
		SpringApplication.run(jpawebApplication.class, args);
	}

}
