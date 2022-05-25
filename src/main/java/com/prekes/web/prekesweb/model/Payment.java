package com.prekes.web.prekesweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Payment implements Comparable<Payment> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String status;
    public String payerName;

    public Payment(String status, String payerName) {
        this.status = status;
        this.payerName = payerName;
    }

    public Payment() {

    }

    @Override
    public int compareTo(Payment o) {
        return 0;
    }
}
