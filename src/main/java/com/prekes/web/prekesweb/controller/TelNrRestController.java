package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.model.TelNr;
import com.prekes.web.prekesweb.service.TelNrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class TelNrRestController {
    @Autowired
    TelNrService telNrService;

    @GetMapping("/numbers")
    public Iterable<TelNr> telnrJson() {
        return telNrService.findAll();
    }

    @GetMapping("/numbers/{telNrId}")
    public TelNr telNrById(@PathVariable int telNrId) {
        return telNrService.findById(telNrId);
    }

    @PostMapping("/numbers")
    public ResponseEntity<Void> addTelNr(@RequestBody TelNr newTelNr) {
        TelNr telNr = telNrService.add(newTelNr);
        if (telNr == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(telNr.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/numbers/{telNrId}")
    public void deleteTelNrById(@PathVariable int telNrId) {
        TelNr telnr = telNrService.findById(telNrId);
        if (telnr != null) {
            telNrService.delete(telnr);
        }
    }
}
