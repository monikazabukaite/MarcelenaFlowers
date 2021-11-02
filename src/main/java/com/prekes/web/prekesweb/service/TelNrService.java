package com.prekes.web.prekesweb.service;

import com.prekes.web.prekesweb.model.TelNr;
import com.prekes.web.prekesweb.repository.TelNrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelNrService {

    @Autowired
    private TelNrRepository repository;

    public List<TelNr> findAll() {
        return (List<TelNr>) repository.findAll();
    }

    public TelNr findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public TelNr add(TelNr telNr) {
        repository.save(telNr);
        return telNr;
    }
    public int findMaxId() {
        Iterable<TelNr> telNrs = repository.findAll();
        int max = 0;
        for(TelNr o : telNrs) {
            if(o.getId() > max) max = o.getId();
        }
        return max;
    }

    public void update(TelNr telNr) {
        repository.save(telNr);
    }

    public void delete(TelNr telNr) {
        repository.delete(telNr);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
