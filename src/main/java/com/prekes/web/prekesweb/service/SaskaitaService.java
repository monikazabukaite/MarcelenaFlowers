package com.prekes.web.prekesweb.service;

import com.prekes.web.prekesweb.model.Saskaita;
import com.prekes.web.prekesweb.repository.SaskaitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaskaitaService {

    @Autowired
    private SaskaitaRepository repository;

    public List<Saskaita> findAll() {
        return (List<Saskaita>) repository.findAll();
    }

    public Saskaita findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Saskaita add(Saskaita Saskaita) {
        repository.save(Saskaita);
        return Saskaita;
    }

    public int findMaxId() {
        Iterable<Saskaita> saskaitaIterable = repository.findAll();
        int max = 0;
        for (Saskaita o : saskaitaIterable) {
            if (o.getId() > max) max = o.getId();
        }
        return max;
    }

    public void update(Saskaita Saskaita) {
        repository.save(Saskaita);
    }

    public void delete(Saskaita Saskaita) {
        repository.delete(Saskaita);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public void deleteByTelNr(int telNr) {
        repository.deleteByTelNrId(telNr);
    }
}
