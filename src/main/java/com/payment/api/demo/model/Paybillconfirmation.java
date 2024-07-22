package com.payment.api.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("paybillconfirmation")
public class Paybillconfirmation {

    @Id
    private String id;

    private Date createdate;

    private boolean processed;

    private Date processeddate;

    private String transactionid;
    private Date transtime;
    private Double amount;
    private String businessshortcode;
    private int errorcount;
    private String lasterrormessage;
    private  boolean error;

    public Paybillconfirmation(String id, Date createdate, boolean processed, Date processeddate, String transactionid, Date transtime, Double amount, String businessshortcode, int errorcount, String lasterrormessage, boolean error) {
        super();
        this.id = id;
        this.createdate = createdate;
        this.processed = processed;
        this.processeddate = processeddate;
        this.transactionid = transactionid;
        this.transtime = transtime;
        this.amount = amount;
        this.businessshortcode = businessshortcode;
        this.errorcount = errorcount;
        this.lasterrormessage = lasterrormessage;
        this.error= error;
    }
}
