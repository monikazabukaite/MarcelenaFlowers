package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.model.Item;
import com.prekes.web.prekesweb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/home")
    public String showHomePage(ModelMap model) {
        List<Item> items = itemService.findAll();
        model.put("itemsList", items);
        return "home";
    }

    @GetMapping("/login")
    public String showLoginPage(ModelMap model) {
        return "login";
    }
}
