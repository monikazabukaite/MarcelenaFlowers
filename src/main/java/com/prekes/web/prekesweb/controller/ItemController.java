package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.model.Item;
import com.prekes.web.prekesweb.model.Role;
import com.prekes.web.prekesweb.model.User;
import com.prekes.web.prekesweb.model.UserRole;
import com.prekes.web.prekesweb.payload.response.MessageResponse;
import com.prekes.web.prekesweb.repository.ItemRepository;
import com.prekes.web.prekesweb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import static com.prekes.web.prekesweb.controller.HomeController.checkCurrentUser;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

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
        Item item = new Item(itemModel.id, itemModel.name, itemModel.imgUrl, itemModel.price);

        itemRepository.save(item);

        return "redirect:/shop";
    }
}
