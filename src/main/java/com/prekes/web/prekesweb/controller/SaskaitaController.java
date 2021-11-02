package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.model.Saskaita;
import com.prekes.web.prekesweb.model.SaskaitaDto;
import com.prekes.web.prekesweb.model.TelNr;
import com.prekes.web.prekesweb.service.SaskaitaService;
import com.prekes.web.prekesweb.service.TelNrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SaskaitaController {

    @Autowired
    private TelNrService telNrService;
    @Autowired
    private SaskaitaService saskaitaService;

    @GetMapping("/list-saskaita")
    public String getSaskaitaList(ModelMap modelMap) {
        List<SaskaitaDto> saskaitaDtos = saskaitaService.findAll()
                .stream()
                .map(s -> new SaskaitaDto(s, telNrService.findById(s.getTelNrId()).getTelNr()))
                .collect(Collectors.toList());
        modelMap.put("saskaitaList", saskaitaDtos);
        return "list-saskaita";
    }

    @PostMapping("/add-saskaita")
    public String add(ModelMap model, @ModelAttribute("saskaita") Saskaita saskaita, BindingResult result) {
        if (result.hasErrors()) {
            return "saskaita";
        }
        saskaitaService.add(saskaita);
        return "redirect:/list-saskaita";
    }

    @GetMapping("/add-saskaita")
    public String showAddPage(ModelMap model) {
        Saskaita s = new Saskaita(saskaitaService.findMaxId() + 1 , 0, 0, BigDecimal.ZERO);
        model.addAttribute("saskaita", new SaskaitaDto(s, ""));
        return "saskaita";
    }

    @GetMapping("/update-saskaita/{saskaitaId}")
    public String showUpdatePage(ModelMap model, @PathVariable int saskaitaId) {
        model.addAttribute("saskaita", saskaitaService.findById(saskaitaId));
        return "saskaita";
    }

    @PostMapping("/update-saskaita/{saskaitaId}")
    public String update(ModelMap model, @ModelAttribute("saskaita") Saskaita saskaita, @PathVariable int saskaitaId, BindingResult result) {
        if (result.hasErrors()) {
            return "saskaita";
        }
        saskaita.setId(saskaitaId);
        saskaitaService.update(saskaita);
        return "redirect:/list-saskaita";
    }

    @GetMapping("/delete-saskaita/{saskaitaId}")
    public String delete(@PathVariable int saskaitaId) {
        saskaitaService.deleteByTelNr(saskaitaId);
        return "redirect:/list-saskaita";
    }
}
