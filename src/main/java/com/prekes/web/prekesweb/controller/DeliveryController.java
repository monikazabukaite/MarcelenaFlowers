package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeliveryController {
    @Autowired
    private ItemService itemService;
    @GetMapping("/delivery/{itemId}/{quantity}")
    public String showCartPage(ModelMap model, @PathVariable int itemId, @PathVariable int quantity) {
        model.addAttribute("item", itemService.findById(itemId));
        model.addAttribute("quantity", quantity);
        return "delivery";
    }
}
