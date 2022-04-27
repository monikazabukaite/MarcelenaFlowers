package com.prekes.web.prekesweb.service;

import com.prekes.web.prekesweb.model.Review;
import com.prekes.web.prekesweb.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> findAll() {
        return (List<Review>) reviewRepository.findAll();
    }

    public Review findById(int id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public Review add(Review review) {
        reviewRepository.save(review);
        return review;
    }

    public void update(Review review) {
        reviewRepository.save(review);
    }

    public void delete(Review review) {
        reviewRepository.delete(review);
    }

    public void deleteById(int id) {
        reviewRepository.deleteById(id);
    }
}
