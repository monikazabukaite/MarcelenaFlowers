package com.prekes.web.prekesweb.service;

import com.prekes.web.prekesweb.model.Saskaita;
import com.prekes.web.prekesweb.repository.SaskaitaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SaskaitaServiceTest {

    @Mock
    SaskaitaRepository repository;

    @InjectMocks
    SaskaitaService service;

    @Test
    void testFindAll() {
        Saskaita saskaita = new Saskaita(1, 2, 3, BigDecimal.TEN);
        List<Saskaita> saskaitaList = new ArrayList<>();
        saskaitaList.add(saskaita);

        when(repository.findAll()).thenReturn(saskaitaList);

        List<Saskaita> found = service.findAll();

        verify(repository).findAll();

        assertEquals(1, found.size());
    }

    @Test
    void testFindById() {
        Saskaita saskaita = new Saskaita(1, 2, 3, BigDecimal.TEN);
        when(repository.findById(Mockito.anyInt())).thenReturn(Optional.of(saskaita));

        Saskaita found = service.findById(1);
        verify(repository).findById(Mockito.anyInt());
        assertNotNull(found);
    }

    @Test
    void testUpdate() {
        Saskaita saskaita = new Saskaita(1, 2, 3, BigDecimal.TEN);
        service.update(saskaita);
        verify(repository).save(Mockito.any(Saskaita.class));
    }

    @Test
    void testAdd() {
        Saskaita saskaita = new Saskaita(1, 2, 3, BigDecimal.TEN);
        when(repository.save(Mockito.any(Saskaita.class))).thenReturn(saskaita);

        Saskaita added = service.add(saskaita);
        verify(repository).save(Mockito.any(Saskaita.class));
        assertNotNull(added);
    }

    @Test
    void testDeleteById() {
        service.deleteById(1);
        verify(repository).deleteById(Mockito.anyInt());
    }

    @Test
    void testDelete() {
        Saskaita saskaita = new Saskaita(1, 2, 3, BigDecimal.TEN);
        service.delete(saskaita);
        verify(repository).delete(Mockito.any(Saskaita.class));
    }
}
