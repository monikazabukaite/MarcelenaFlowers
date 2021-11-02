package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.model.TelNr;
import com.prekes.web.prekesweb.service.SaskaitaService;
import com.prekes.web.prekesweb.service.TelNrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class TelNrController {

    @Autowired
    private TelNrService telNrService;
    @Autowired
    private SaskaitaService saskaitaService;

    @GetMapping("/list-telnr")
    public String getAllTellNr(ModelMap modelMap) {
        modelMap.put("telNrList", telNrService.findAll());
        return "list-telnr";
    }

    @PostMapping("/add-telnr")
    public String add(ModelMap model, @ModelAttribute("telNr") TelNr telNr, BindingResult result) {
        if (result.hasErrors()) {
            return "telnr";
        }
        telNrService.add(telNr);
        return "redirect:/list-telnr";
    }

    @GetMapping("/add-telnr")
    public String showAddPage(ModelMap model) {
        model.addAttribute("telnr", new TelNr(telNrService.findMaxId() + 1, "", 0));
        return "telnr";
    }

    @GetMapping("/update-telnr/{telNrId}")
    public String showUpdatePage(ModelMap model, @PathVariable int telNrId) {
        model.addAttribute("telnr", telNrService.findById(telNrId));
        return "telnr";
    }

    @PostMapping("/update-telnr/{telNrId}")
    public String update(ModelMap model, @ModelAttribute("telnr") TelNr telnr, @PathVariable int telNrId, BindingResult result) {
        if(result.hasErrors()) {
            return "telnr";
        }
        telnr.setId(telNrId);
        telNrService.update(telnr);
        return "redirect:/list-telnr";
    }

    @GetMapping("/delete-telnr/{telNrId}")
    public String delete(@PathVariable int telNrId) {
        saskaitaService.deleteByTelNr(telNrId);
        telNrService.deleteById(telNrId);
        return "redirect:/list-telnr";
    }
}
