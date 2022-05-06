package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/item/{itemId}")
    public String showItemPage(ModelMap model, @PathVariable int itemId) {
        model.addAttribute("item", itemService.findById(itemId));
        return "item";
    }
}
