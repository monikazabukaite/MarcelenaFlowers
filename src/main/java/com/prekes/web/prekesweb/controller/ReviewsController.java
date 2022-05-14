package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.model.Item;
import com.prekes.web.prekesweb.model.Review;
import com.prekes.web.prekesweb.payload.response.MessageResponse;
import com.prekes.web.prekesweb.repository.ReviewRepository;
import com.prekes.web.prekesweb.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Controller
public class ReviewsController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/reviews")
    public String showCartPage(ModelMap model) {
        model.addAttribute("review", new Review());
        List<Review> reviews = reviewService.findAll();
        model.put("reviews", reviews);
        return "reviews";
    }

    @Transactional
    @PostMapping("/add-review")
    public String addReview(ModelMap model, @ModelAttribute("review") Review reviewModel) {
        String year = String.valueOf(LocalDate.now().getYear());
        String day = String.valueOf(LocalDate.now().getDayOfMonth());
        String month = LocalDate.now().getMonth().name().substring(0, 1).toUpperCase() + LocalDate.now().getMonth().name().substring(1).toLowerCase();
        String date = month + " " + day + ", " + year;
        Review review = new Review(reviewModel.user, reviewModel.product, reviewModel.rating, reviewModel.details, date);

        reviewRepository.save(review);

        return "redirect:/reviews";
    }
}
