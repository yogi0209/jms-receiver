package com.yogendra;

import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListener {
    private final Logger log = LoggerFactory.getLogger(EmailListener.class);

    @JmsListener(destination = "email", containerFactory = "jmsListenerContainerFactory")
    public void processEmail(Email email) {
        log.info("Email Received : {}", email);
    }
}
