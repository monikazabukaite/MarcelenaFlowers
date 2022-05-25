package com.prekes.web.prekesweb.event;

import com.prekes.web.prekesweb.model.Payment;
import com.prekes.web.prekesweb.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
public class PaymentEventListener {

    private static final Logger logger = LoggerFactory.getLogger(PaymentEventListener.class);

    @Autowired
    PaymentRepository paymentRepository;

    @Async
    @EventListener
    public void paymentInitiatedListener(PaymentInitiated event) throws Exception {
        // artificial timeout added for non-blocking communication implementation
        Thread.sleep(5000);
        Payment payment = new Payment();
        payment.setPayerName(event.getPayerName());
        payment.setStatus(event.getStatus());
        try {
            paymentRepository.save(payment);
        } catch (Exception e) {
            logger.error("Unable to save payment");
        }
        logger.info("Payment handled and saved successfully");
    }
}
