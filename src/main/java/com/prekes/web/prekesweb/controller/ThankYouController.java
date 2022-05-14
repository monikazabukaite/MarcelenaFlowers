package com.prekes.web.prekesweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import static com.prekes.web.prekesweb.controller.HomeController.checkCurrentUser;

@Controller
public class ThankYouController {

    @GetMapping("/thank-you")
    public String showAboutPage(ModelMap model) {
        checkCurrentUser(model);
        return "thankyou";
    }
}
