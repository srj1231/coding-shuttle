package com.cs.saumya.week1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    // Concept 5 cont. - I define here how this bean is to be created.

    // Concept 6 - Bean lifecycle
    // Bean creation > DI > bean initialisation > bean usage > bean destruction

    // Concept 8: Bean scopes (default - singleton)
    // singleton - 1 instance per application, use for Services, Repositories
    // prototype - new instance every time, use for stateful objects. A lot of beans can fill up memory fast.
    // request - 1 instance per HTTP request, use for web apps only
    // session - 1 instance per HTTP session, use for shopping cart
    // application - 1 instance per application context, use for global config
    // websocket - 1 instance per WebSocket session

    // @Scope("prototype") --> different hash code each time it is used (new instance every time)
    @Bean
    public PaymentService paymentService() {
        // more logic
        return new PaymentService();
    }
}
