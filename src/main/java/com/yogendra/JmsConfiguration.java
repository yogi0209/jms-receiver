package com.yogendra;


import jakarta.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageConverter;

@Configuration
@EnableJms
public class JmsConfiguration {

    @Bean
    ConnectionFactory connectionFactory(){

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setUserName("email");
        connectionFactory.setPassword("email-password");
        connectionFactory.setBrokerURL("tcp://localhost:61616");

        return connectionFactory;
    }

    @Bean
    DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setSessionTransacted(true);
        factory.setMessageConverter(messageConverter());
        return factory;
    }


    @Bean
    public MessageConverter messageConverter() {
        return new EmailMessageConvertor();
    }
}
