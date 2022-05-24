package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.model.Item;
import com.prekes.web.prekesweb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

import static com.prekes.web.prekesweb.controller.HomeController.checkCurrentUser;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/item/{itemId}")
    public String showItemPage(ModelMap model, @PathVariable int itemId) {
        checkCurrentUser(model);
        model.addAttribute("item", itemService.findById(itemId));
        return "item";
    }

    @GetMapping("/add-item")
    public String showAddItemPage(ModelMap model) {
        checkCurrentUser(model);
        Item item = new Item();
        item.setId((int) new Random().nextLong());
        model.addAttribute("item", item);
        return "add-item";
    }

    @PostMapping("/add-item")
    public String addItem(ModelMap model, @ModelAttribute("item") Item itemModel) {
        Item item = new Item(itemModel.category, itemModel.name, itemModel.imgUrl, itemModel.price);

        itemService.add(item);

        return "redirect:/shop";
    }
}
