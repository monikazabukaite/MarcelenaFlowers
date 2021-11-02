package com.prekes.web.prekesweb.repository;

import com.prekes.web.prekesweb.model.TelNr;
import org.springframework.data.repository.CrudRepository;

public interface TelNrRepository extends CrudRepository<TelNr, Integer> {
    TelNr findByTelNr(String telNr);
}
