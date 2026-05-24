package com.cs.saumya.week1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

// Concept 2: Inversion of Control (IOC) (@Component)
// Create a Bean for Spring framework for lifecycle management transfer from the application to the framework
// next inject the bean in the consumer class

// Concept 4: IOC Container / Application Context is bean factory/ pool.
// It takes Config metadata, POJO classes and creates fully configured system.

// Concept 5: How to make beans?
// stereotype annotations: @Component (generic), @Service (business logic), @Controller (web layer), @Repository (db access)
// web annotations: @RestController
// using @Bean in a @Configuration class like AppConfig --> this is given priority over all annotations
@Component
public class PaymentService {

    public void pay() {
        System.out.println("paying...");
    }
    // Concept 7: bean lifecycle methods: @PostConstruct, @PreDestroy
    // @PostConstruct - after bean is created and before it is used
    // @PreDestroy - clean-up before bean is destroyed
    @PostConstruct
    public void init() {
        System.out.println("PaymentService is initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PaymentService is destroyed");
    }
}
