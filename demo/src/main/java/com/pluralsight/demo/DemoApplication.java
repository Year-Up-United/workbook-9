package com.pluralsight.demo;

import com.pluralsight.demo.model.Student;
import com.pluralsight.demo.service.RegistrationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext context;
		context = SpringApplication.run(DemoApplication.class, args);

		CommandLineRunner clr = context.getBean(CLI.class);
		clr.run();
	}

}
