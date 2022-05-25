package com.prekes.web.prekesweb.repository;

import com.prekes.web.prekesweb.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
