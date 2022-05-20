package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.model.Item;
import com.prekes.web.prekesweb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/shop/{filterName}")
    public String showShopPageWithFilter(ModelMap model, @PathVariable String filterName) {
        checkCurrentUser(model);
        List<Item> items = itemService.findAll();

        items = items.stream()
                .filter(item -> item.category.equals(filterName))
                .collect(Collectors.toList());

        model.put("filteredItemsList", items);
        return "shop";
    }
}
