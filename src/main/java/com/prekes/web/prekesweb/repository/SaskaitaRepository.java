package com.prekes.web.prekesweb.repository;

import com.prekes.web.prekesweb.model.Saskaita;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface SaskaitaRepository extends CrudRepository<Saskaita, Integer> {
    @Transactional
    List<Saskaita> deleteByTelNrId(int telNrId);
}
