package com.payment.api.demo.services;

import com.payment.api.demo.model.B2CRequest;
import com.payment.api.demo.repository.B2CRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @Autowired
    private B2CRequestRepository repository;

    @KafkaListener(topics = "b2c_responses", groupId = "b2c-consumer-group")
    public void consume(B2CRequest request) {
        // Update the status of the B2C request in MongoDB
        B2CRequest existingRequest = repository.findById(request.getId()).orElse(null);
        if (existingRequest != null) {
            existingRequest.setStatus(request.getStatus());
            repository.save(existingRequest);
        }
    }
}

