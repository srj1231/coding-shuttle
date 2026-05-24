package com.cs.saumya.week1.implementations;

import com.cs.saumya.week1.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
@Qualifier("emailNotif") // only create this bean if qualifier matches
@Component
//@ConditionalOnProperty(name = "notif.type", havingValue = "email")    // only create this bean if condition matches
public class EmailNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sending Email " + message);
    }
}
