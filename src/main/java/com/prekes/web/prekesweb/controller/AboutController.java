package com.prekes.web.prekesweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String showAboutPage(ModelMap model) {
        System.out.println("Testing...");
        return "about"; // view resolver /WEB-INF/jsp/welcome.jsp
    }
}
