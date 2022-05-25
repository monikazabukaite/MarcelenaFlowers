package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.model.Review;
import com.prekes.web.prekesweb.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import static com.prekes.web.prekesweb.controller.HomeController.checkCurrentUser;

@Controller
public class ReviewsController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public String showReviewPage(ModelMap model) {
        checkCurrentUser(model);
        model.addAttribute("review", new Review());
        List<Review> reviews = reviewService.findAll();
        model.put("reviews", reviews);
        return "reviews";
    }

    @Transactional
    @PostMapping("/add-review")
    public String addReview(ModelMap model, @ModelAttribute("review") Review reviewModel) {
        checkCurrentUser(model);
        String year = String.valueOf(LocalDate.now().getYear());
        String day = String.valueOf(LocalDate.now().getDayOfMonth());
        String month = LocalDate.now().getMonth().name().substring(0, 1).toUpperCase() + LocalDate.now().getMonth().name().substring(1).toLowerCase();
        String date = month + " " + day + ", " + year;
        Review review = new Review(reviewModel.getUser(), reviewModel.getProduct(), reviewModel.getRating(), reviewModel.getDetails(), date);

        reviewService.add(review);

        return "redirect:/reviews";
    }
}
