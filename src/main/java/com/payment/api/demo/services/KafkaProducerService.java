package com.payment.api.demo.services;

import com.payment.api.demo.model.B2CRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private static final String TOPIC = "b2c_requests";

    @Autowired
    private KafkaTemplate<String, B2CRequest> kafkaTemplate;

    public void sendB2CRequest(B2CRequest request) {
        kafkaTemplate.send(TOPIC, request);
    }
}

