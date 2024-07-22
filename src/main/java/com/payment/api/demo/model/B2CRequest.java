package com.payment.api.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "b2c_requests")
public class B2CRequest {
    @Id
    private String id;
    private String customerId;
    private double amount;
    private String status;
}
