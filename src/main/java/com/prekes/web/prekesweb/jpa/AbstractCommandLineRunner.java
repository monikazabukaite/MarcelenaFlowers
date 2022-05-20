package com.prekes.web.prekesweb.jpa;

import com.prekes.web.prekesweb.model.Item;
import com.prekes.web.prekesweb.model.Review;
import com.prekes.web.prekesweb.model.Role;
import com.prekes.web.prekesweb.model.UserRole;
import com.prekes.web.prekesweb.repository.ItemRepository;
import com.prekes.web.prekesweb.repository.ReviewRepository;
import com.prekes.web.prekesweb.repository.RoleRepository;
import com.prekes.web.prekesweb.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AbstractCommandLineRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(AbstractCommandLineRunner.class);

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        reviewRepository.save(new Review("Emilly", "The Ellen", 5, "Labai gera gele", "February 14, 2022"));
        reviewRepository.save(new Review("Ajus", "The Millie", 5, "Auksine gele", "February 12, 2022"));
        reviewRepository.save(new Review("Haris", "The Abby", 5, "Ehhh gera gele", "February 5, 2022"));
        reviewRepository.save(new Review("Birute", "The Kylie", 5, "Super parduotuve, dar karta grisime!", "May 1, 2022"));

        itemRepository.save(new Item(1, "hand-tied-bouquets", "The Ellen", "images/flower1.jpg", 49));
        itemRepository.save(new Item(2, "hand-tied-bouquets", "The Gabrielle", "images/flower2.jpg", 59));
        itemRepository.save(new Item(3, "hand-tied-bouquets", "The Abby", "images/flower3.jpg", 39));
        itemRepository.save(new Item(4, "spring-flowers", "The Jeanie", "images/flower4.jpg", 49));

        itemRepository.save(new Item(5, "dried-flowers", "The Harper", "images/flower5.jpg", 49));
        itemRepository.save(new Item(6, "spring-flowers", "The Grace", "images/flower6.jpg", 59));
        itemRepository.save(new Item(7, "dried-flowers", "The Camille", "images/flower7.jpg", 39));
        itemRepository.save(new Item(8, "spring-flowers", "The Caitlin", "images/flower8.jpg", 49));

        roleRepository.save(new Role(UserRole.USER));
        roleRepository.save(new Role(UserRole.ADMIN));
    }
}
