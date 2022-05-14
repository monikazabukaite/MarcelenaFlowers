package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.model.Item;
import com.prekes.web.prekesweb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static com.prekes.web.prekesweb.controller.HomeController.checkCurrentUser;

@Controller
public class ShopController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/shop")
    public String showHomePage(ModelMap model) {
        checkCurrentUser(model);
        List<Item> items = itemService.findAll();
        model.put("itemsList", items);
        return "shop";
    }
}
