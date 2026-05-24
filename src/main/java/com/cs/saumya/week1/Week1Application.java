package com.cs.saumya.week1;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Week1Application implements CommandLineRunner {

	// Concept 3: dependency injection using @Autowired - no new keyword is used, no object is created by us --> Spring Boot will create the object (IOC)
	// CommandLineRunner will run all the runners after all beans are created
	@Autowired PaymentService paymentService;

	@Autowired PaymentService paymentService2;


	public static void main(String[] args) {
		SpringApplication.run(Week1Application.class, args);

		// Concept 1: J2E complexities
		// java enterprise edition way - complex, heavy-weight, scattered object creation, harder to test
		// with beans and DI, we leave the object creation and management on Spring Boot
		// Beans are the core blocks that are wired together to create an application
//		PaymentService paymentService = new PaymentService();
//		paymentService.pay();
	}

	@Override
	public void run(String @NonNull ... args) throws Exception {
		// Concept 9: Bean scopes check - default singleton --> same hash code
		System.out.printf(paymentService.hashCode() + "\n");
		System.out.printf(paymentService2.hashCode() + "\n");
		paymentService.pay();
	}
}
