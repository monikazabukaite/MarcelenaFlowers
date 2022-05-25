package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.event.PaymentInitiated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import static com.prekes.web.prekesweb.controller.HomeController.checkCurrentUser;

@Controller
public class ThankYouController {

    @Autowired
    ApplicationEventPublisher publisher;

    @GetMapping("/thank-you")
    public String showAboutPage(ModelMap model) {
        checkCurrentUser(model);
        PaymentInitiated event = new PaymentInitiated(this, "INITIATED", (String) model.getAttribute("username"));
        publisher.publishEvent(event);
        return "thankyou";
    }
}
