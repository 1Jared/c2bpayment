package com.payment.api.demo.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {
    @Bean
    public MongoTemplate mongoTemplate() {
        System.out.println("Test");
        return new MongoTemplate(MongoClients.create("mongodb+srv://jared:dbuser1@cluster0.soai0wn.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"), "paybillapidb");
    }
}

