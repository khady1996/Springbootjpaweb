package eu.ensup.springbootjpaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class jpawebApplication {

	@RequestMapping("/")
	public String home() {
		return "WAOUWWW ";
	}
	public static void main(String[] args) {
		SpringApplication.run(jpawebApplication.class, args);
	}

}
