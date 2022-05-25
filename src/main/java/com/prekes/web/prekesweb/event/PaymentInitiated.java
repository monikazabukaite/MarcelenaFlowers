package com.prekes.web.prekesweb.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class PaymentInitiated extends ApplicationEvent {
    private final String status;
    private final String payerName;

    public PaymentInitiated(Object source, String status, String payerName) {
        super(source);
        this.status = status;
        this.payerName = payerName;
    }
}
