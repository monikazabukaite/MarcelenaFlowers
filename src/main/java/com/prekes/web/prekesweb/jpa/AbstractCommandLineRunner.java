package com.prekes.web.prekesweb.jpa;

import com.prekes.web.prekesweb.model.Saskaita;
import com.prekes.web.prekesweb.model.TelNr;
import com.prekes.web.prekesweb.repository.SaskaitaRepository;
import com.prekes.web.prekesweb.repository.TelNrRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class AbstractCommandLineRunner implements CommandLineRunner{
	private static final Logger log = LoggerFactory.getLogger(AbstractCommandLineRunner.class);
	
	@Autowired
	private TelNrRepository repository;
	@Autowired
	private SaskaitaRepository saskaitaRepository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new TelNr(1, "+370648", 1));
		repository.save(new TelNr(2, "+370658", 1));
		repository.save(new TelNr(3, "+370668", 1));
		repository.save(new TelNr(4, "+370678", 1));

		saskaitaRepository.save(new Saskaita(1, 1, 5, BigDecimal.valueOf(20)));
		saskaitaRepository.save(new Saskaita(2, 2, 10, BigDecimal.valueOf(30)));
		saskaitaRepository.save(new Saskaita(3, 3, 12, BigDecimal.valueOf(40)));
		saskaitaRepository.save(new Saskaita(4, 4, 11, BigDecimal.valueOf(50)));
	}
}
