package traderproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
//This is a convenience annotation that is equivalent to 
//declaring @Configuration, @EnableAutoConfiguration and @ComponentScan.
@ComponentScan(basePackages = "traderproject")
@SpringBootApplication
public class Application extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
//Dimitris did a useless push :D
//Dimitris did another useless pull to develop branch
}
