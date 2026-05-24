package com.cs.saumya.week1;

import com.cs.saumya.week1.implementations.EmailNotificationService;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Week1Application implements CommandLineRunner {

	// Concept 3: dependency injection using @Autowired - no new keyword is used, no object is created by us --> Spring Boot will create the object (IOC)
	// CommandLineRunner will run all the runners after all beans are created
//	@Autowired PaymentService paymentService;
//	@Autowired PaymentService paymentService2;

	// Concept 11: Dependency injection - design pattern where an object receives its dependencies from the outside instead of creating them itself.
	// DI types: Constructor - best for Mandatory requirements; Setter/Property (Autowired) - okay, best for Optional/Late initialization;
	// Interface Injection for Standardized injection; field/ method injection - avoid, for Single-use functionality.
	// Field/method DI example:
	//	@Autowired NotificationService notificationService;
	// Constructor DI example:
	//	public class OrderService {
	//		private final PaymentGateway gateway;
	//
	//		// Dependency is injected here
	//		public OrderService(PaymentGateway gateway) {
	//			this.gateway = gateway;
	//		}
	//	}
//		final NotificationService notificationService;	// final makes it immutable
//
//		public Week1Application(NotificationService notificationService) {
//			this.notificationService = notificationService;
//		}

//		public Week1Application(@Qualifier("emailNotif") NotificationService notificationService) {
//			this.notificationService = notificationService;
//		}

	// Setter DI example:
	// public class ReportGenerator {
	//    private Formatter formatter;
	//
	//    // Dependency can be set or changed later
	//    public void setFormatter(Formatter formatter) {
	//        this.formatter = formatter;
	//    }
	//}

	// Interface DI example:
	// public interface DatabaseClient {
	//    void injectConnection(Connection conn);
	//}
	//
	//public class UserRepository implements DatabaseClient {
	//    private Connection connection;
	//
	//    @Override
	//    public void injectConnection(Connection conn) {
	//        this.connection = conn;
	//    }
	//}

	// Field/method DI example:
	// public class UserProfile {
	//    // Dependency (Logger) is only provided when this specific method is called
	//    public void updateEmail(String newEmail, Logger logger) {
	//        this.email = newEmail;
	//        logger.info("Email updated");
	//    }
	//}

	// Concept 12: How does Spring resolve dependencies?
	// by type e.g. EmailNotificationService,
	// by @Qualifier if multiple beans - @Qualifier("smsNotif") in injection and bean annotation,
	// use @Primary if still ambiguous,
	// @ConditionalOnProperties in application.properties (notif.type = email)

	// Concept 14: To get all implementations, not just one:
	@Autowired
	Map<String, NotificationService> notificationServiceMap = new HashMap<>();


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
//		System.out.printf(paymentService.hashCode() + "\n");
//		System.out.printf(paymentService2.hashCode() + "\n");
//		paymentService.pay();

		// Concept 10: NotificationService interface usage - tightly coupled here (use of new keyword in a class, not a config class)
		// this is a wrong way to use it because I will need to manually update the type of notification service to use every time!
		// Solution - create a bean. Can't use @Component on NotificationService because it's an interface, and you cannot create objects from interfaces.
		// Use @Component on the implementations / concrete classes. Then Autowire to inject bean.
		// but if more than one implementation has @Component, Autowire doesn't know which bean to use. --> Use @Primary on one of the implementations.
		// e.g. Field notificationService in com.cs.saumya.week1.Week1Application required a single bean, but 2 were found: emailNotificationService, smsNotificationService

//		notificationService = new EmailNotificationService();
//		notificationService.send("hello");

		// Concept 14 cont.:
		for(var notificationService: notificationServiceMap.entrySet()) {
			System.out.println(notificationService.getKey());
			notificationService.getValue().send("hello");
		}
		// output:
		//emailNotificationService
		//Sending Email hello
		//smsNotificationService
		//Sending SMS hello

		// Concept 15: Can also define beans as Optional, or use @Autowired(required=false) if incomplete
	}
}
