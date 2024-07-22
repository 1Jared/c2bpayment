package com.payment.api.demo.repository;

import com.payment.api.demo.model.Paybillconfirmation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PaybillconfirmationRepository extends MongoRepository<Paybillconfirmation, String> {

    @Query("{transactionid:'?0'}")
    Paybillconfirmation findByTransactionId(String transactionid);

//    @Query(fields="{'transactionid' : 1 , 'amount' : 1}")
//    List<Paybillconfirmation> findAll(String transactionid);

    public long count();

}