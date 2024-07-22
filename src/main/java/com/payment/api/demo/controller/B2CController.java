package com.payment.api.demo.controller;

import com.payment.api.demo.model.B2CRequest;
import com.payment.api.demo.repository.B2CRequestRepository;
import com.payment.api.demo.services.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/b2c")
public class B2CController {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public B2CController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    @Autowired
    private B2CRequestRepository repository;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/request")
    public B2CRequest receiveB2CRequest(@RequestBody B2CRequest request) {
        request.setStatus("PENDING");
        repository.save(request);
        kafkaProducerService.sendB2CRequest(request);
        return request;
    }

    @GetMapping("/request/{id}")
    public B2CRequest fetchPaymentStatus(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/request/{id}")
    public B2CRequest updatePaymentStatus(@PathVariable String id, @RequestBody B2CRequest request) {
        B2CRequest existingRequest = repository.findById(id).orElse(null);
        if (existingRequest != null) {
            existingRequest.setStatus(request.getStatus());
            repository.save(existingRequest);
        }
        return existingRequest;
    }
}

