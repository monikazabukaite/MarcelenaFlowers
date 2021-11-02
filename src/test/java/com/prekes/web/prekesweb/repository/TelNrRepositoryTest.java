package com.prekes.web.prekesweb.repository;

import com.prekes.web.prekesweb.model.TelNr;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class TelNrRepositoryTest {

	@Autowired
	private TelNrRepository telNrRepository;

	@Test
	public void testSave() {
		TelNr o = new TelNr(1, "+370", 2);
		telNrRepository.save(o);

		Optional<TelNr> telNr = telNrRepository.findById(1);

		assertTrue(telNr.isPresent());
		assertEquals("+370", telNr.get().getTelNr());
	}

	@Test
	public void testFindByTelNr() {
		TelNr o = new TelNr(1, "+370", 2);
		telNrRepository.save(o);

		TelNr telNr = telNrRepository.findByTelNr("+370");

		assertNotNull(telNr);
		assertEquals(1, telNr.getId());
	}

	@Test
	public void testFindAll() {
		TelNr o1 = new TelNr(1, "+370", 2);
		TelNr o2 = new TelNr(2, "+321", 4);
		telNrRepository.save(o1);
		telNrRepository.save(o2);

		Iterable<TelNr> telNrIterable = telNrRepository.findAll();

		assertNotNull(telNrIterable);

		List<TelNr> result = new ArrayList<TelNr>();
		telNrIterable.forEach(result::add);

		assertEquals(2, result.size());
	}

	@Test
	public void testDelete() {
		TelNr o = new TelNr(1, "+370", 1);
		telNrRepository.save(o);

		Optional<TelNr> telNr = telNrRepository.findById(1);

		assertTrue(telNr.isPresent());

		telNrRepository.delete(telNr.get());

		Iterable<TelNr> prekes = telNrRepository.findAll();

		List<TelNr> result = StreamSupport.stream(prekes.spliterator(), false).collect(Collectors.toList());

		assertEquals(0, result.size());
	}
}
