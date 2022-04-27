package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.model.Review;
import com.prekes.web.prekesweb.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReviewsController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public String showCartPage(ModelMap model) {
        List<Review> reviews = reviewService.findAll();
        model.put("reviews", reviews);
        return "reviews";
    }
}
