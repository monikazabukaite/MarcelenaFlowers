package com.prekes.web.prekesweb.repository;

import com.prekes.web.prekesweb.model.Saskaita;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class SaskaitaRepositoryTest {

	@Autowired
	private SaskaitaRepository saskaitaRepository;

	@BeforeEach
	public void clearRepo() {
		saskaitaRepository.deleteAll();
	}

	@Test
	public void testSave() {
		Saskaita o = new Saskaita(1, 2, 3, BigDecimal.TEN);
		saskaitaRepository.save(o);

		Optional<Saskaita> saskaita = saskaitaRepository.findById(1);

		assertTrue(saskaita.isPresent());
		assertEquals(BigDecimal.TEN, saskaita.get().getSuma());
	}

	@Test
	public void testFindAll() {
		Saskaita o1 = new Saskaita(1, 2, 3, BigDecimal.TEN);
		Saskaita o2 = new Saskaita(2, 2, 3, BigDecimal.ZERO);
		saskaitaRepository.save(o1);
		saskaitaRepository.save(o2);

		Iterable<Saskaita> saskaitaIterable = saskaitaRepository.findAll();

		assertNotNull(saskaitaIterable);

		List<Saskaita> result = new ArrayList<Saskaita>();
		saskaitaIterable.forEach(result::add);

		assertEquals(2, result.size());
	}

	@Test
	public void testDelete() {
		Saskaita o = new Saskaita(1, 2, 3, BigDecimal.ZERO);
		saskaitaRepository.save(o);

		Optional<Saskaita> saskaita = saskaitaRepository.findById(1);

		assertTrue(saskaita.isPresent());

		saskaitaRepository.delete(saskaita.get());

		Iterable<Saskaita> prekes = saskaitaRepository.findAll();

		List<Saskaita> result = StreamSupport.stream(prekes.spliterator(), false).collect(Collectors.toList());

		assertEquals(0, result.size());
	}

	@Test
	public void testDeleteByTelNrId() {
		Saskaita o = new Saskaita(1, 2, 3, BigDecimal.ZERO);
		saskaitaRepository.save(o);

		Optional<Saskaita> saskaita = saskaitaRepository.findById(1);

		assertTrue(saskaita.isPresent());

		saskaitaRepository.deleteByTelNrId(2);

		Iterable<Saskaita> prekes = saskaitaRepository.findAll();

		List<Saskaita> result = StreamSupport.stream(prekes.spliterator(), false).collect(Collectors.toList());

		assertEquals(0, result.size());
	}
}
