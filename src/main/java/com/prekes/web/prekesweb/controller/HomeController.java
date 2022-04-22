package com.prekes.web.prekesweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String showHomePage(ModelMap model) {
        System.out.println("Testing...");
        return "home"; // view resolver /WEB-INF/jsp/welcome.jsp
    }
}
