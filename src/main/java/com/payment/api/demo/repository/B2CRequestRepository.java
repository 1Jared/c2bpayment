package com.payment.api.demo.repository;

import com.payment.api.demo.model.B2CRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface B2CRequestRepository extends MongoRepository<B2CRequest, String> {
}

