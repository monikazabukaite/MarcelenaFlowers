package com.prekes.web.prekesweb.jpa;

import com.prekes.web.prekesweb.model.Review;
import com.prekes.web.prekesweb.repository.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class AbstractCommandLineRunner implements CommandLineRunner{
	private static final Logger log = LoggerFactory.getLogger(AbstractCommandLineRunner.class);
	
	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public void run(String... args) {
		reviewRepository.save(new Review("Emilly", "The Ellen", 5, "Labai gera gele", "February 14, 2022"));
		reviewRepository.save(new Review("Ajus", "The Millie", 5, "Auksine gele", "February 12, 2022"));
		reviewRepository.save(new Review("Haris", "The Abby", 3, "Ehhh gera gele", "February 10, 2022"));
	}
}
