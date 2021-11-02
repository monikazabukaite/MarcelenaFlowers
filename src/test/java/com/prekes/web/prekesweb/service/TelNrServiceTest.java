package com.prekes.web.prekesweb.service;

import com.prekes.web.prekesweb.model.TelNr;
import com.prekes.web.prekesweb.repository.TelNrRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TelNrServiceTest {

    @Mock
    TelNrRepository repository;

    @InjectMocks
    TelNrService service;

    @Test
    void testFindAll() {
        TelNr telNr = new TelNr(1, "+370", 1);
        List<TelNr> telNrs = new ArrayList<>();
        telNrs.add(telNr);

        when(repository.findAll()).thenReturn(telNrs);

        List<TelNr> found = service.findAll();

        verify(repository).findAll();

        assertEquals(1, found.size());
    }

    @Test
    void testFindById() {
        TelNr telNr = new TelNr(1, "+370", 1);
        when(repository.findById(Mockito.anyInt())).thenReturn(Optional.of(telNr));

        TelNr found = service.findById(1);
        verify(repository).findById(Mockito.anyInt());
        assertNotNull(found);
    }

    @Test
    void testUpdate() {
        TelNr telNr = new TelNr(1, "+370", 1);
        service.update(telNr);
        verify(repository).save(Mockito.any(TelNr.class));
    }

    @Test
    void testAdd() {
        TelNr telNr = new TelNr(1, "+370", 1);
        when(repository.save(Mockito.any(TelNr.class))).thenReturn(telNr);

        TelNr added = service.add(telNr);
        verify(repository).save(Mockito.any(TelNr.class));
        assertNotNull(added);
    }

    @Test
    void testDeleteById() {
        service.deleteById(1);
        verify(repository).deleteById(Mockito.anyInt());
    }

    @Test
    void testDelete() {
        TelNr telNr = new TelNr(1, "+370", 1);
        service.delete(telNr);
        verify(repository).delete(Mockito.any(TelNr.class));
    }
}
