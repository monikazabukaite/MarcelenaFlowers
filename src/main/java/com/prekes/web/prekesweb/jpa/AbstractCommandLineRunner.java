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

        itemRepository.save(new Item(1, "Hand-tied bouquets", "The Ellen", "images/flower1.jpg", 49));
        itemRepository.save(new Item(2, "Hand-tied bouquets", "The Millie", "images/flower2.jpg", 59));
        itemRepository.save(new Item(3, "Hand-tied bouquets", "The Abby", "images/flower3.jpg", 39));
        itemRepository.save(new Item(4, "Hand-tied bouquets", "The Jeanie", "images/flower4.jpg", 49));

        itemRepository.save(new Item(5, "Hand-tied bouquets", "The Harper", "images/flower5.jpg", 49));
        itemRepository.save(new Item(6, "Spring flowers", "The Grace", "images/flower6.jpg", 59));
        itemRepository.save(new Item(7, "Spring flowers", "The Camille", "images/flower7.jpg", 39));
        itemRepository.save(new Item(8, "Spring flowers", "The Caitlin", "images/flower8.jpg", 49));

        roleRepository.save(new Role(UserRole.USER));
        roleRepository.save(new Role(UserRole.ADMIN));
    }
}
