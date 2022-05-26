package com.prekes.web.prekesweb.jpa;

import com.prekes.web.prekesweb.model.*;
import com.prekes.web.prekesweb.service.ItemService;
import com.prekes.web.prekesweb.service.ReviewService;
import com.prekes.web.prekesweb.service.RoleService;
import com.prekes.web.prekesweb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class AbstractCommandLineRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(AbstractCommandLineRunner.class);

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void run(String... args) {
        reviewService.add(new Review("Emilly", "The Ellen", 5, "Labai gera gele", "February 14, 2022"));
        reviewService.add(new Review("Ajus", "The Millie", 5, "Auksine gele", "February 12, 2022"));
        reviewService.add(new Review("Haris", "The Abby", 5, "Ehhh gera gele", "February 5, 2022"));
        reviewService.add(new Review("Birute", "The Kylie", 5, "Super parduotuve, dar karta grisime!", "May 1, 2022"));

        itemService.add(new Item("hand-tied-bouquets", "The Ellen", "images/flower1.jpg", 49));
        itemService.add(new Item("hand-tied-bouquets", "The Gabrielle", "images/flower2.jpg", 59));
        itemService.add(new Item("hand-tied-bouquets", "The Abby", "images/flower3.jpg", 39));
        itemService.add(new Item("hand-tied-bouquets", "The Jeanie", "images/flower4.jpg", 49));

        itemService.add(new Item("hand-tied-bouquets", "The Harper", "images/flower5.jpg", 49));
        itemService.add(new Item("hand-tied-bouquets", "The Grace", "images/flower6.jpg", 59));
        itemService.add(new Item("hand-tied-bouquets", "The Camille", "images/flower7.jpg", 39));
        itemService.add(new Item("hand-tied-bouquets", "The Caitlin", "images/flower8.jpg", 49));

        itemService.add(new Item("flowers", "The Sophia", "images/flower9.jpg", 6));
        itemService.add(new Item("flowers", "The Victoria", "images/flower10.jpg", 7));
        itemService.add(new Item("flowers", "The Isabella", "images/flower11.jpg", 5));
        itemService.add(new Item("flowers", "The Olivia", "images/flower12.jpg", 2));

        itemService.add(new Item("home-interior-details", "The Ellie", "images/home1.jpg", 20));
        itemService.add(new Item("home-interior-details", "The Angelina", "images/home2.jpg", 15));
        itemService.add(new Item("home-interior-details", "The Samantha", "images/home3.jpg", 25));
        itemService.add(new Item("home-interior-details", "The Sarah", "images/home4.jpg", 15));

        roleService.add(new Role(UserRole.USER));
        roleService.add(new Role(UserRole.ADMIN));

        Set<Role> adminRole = new HashSet<>(List.of(roleService.findByName(UserRole.ADMIN).get()));
        Set<Role> userRole = new HashSet<>(List.of(roleService.findByName(UserRole.USER).get()));

        userService.add(new User("admin", "admin@admin.com", encoder.encode("admin"), adminRole));
        userService.add(new User("user", "user@user.com", encoder.encode("user"), userRole));
    }
}
