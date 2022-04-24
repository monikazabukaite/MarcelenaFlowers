package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.model.Saskaita;
import com.prekes.web.prekesweb.model.SaskaitaDto;
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
public class ItemController {

    @GetMapping("/item")
    public String showItemPage(ModelMap model) {
        System.out.println("Testing...");
        return "item"; // view resolver /WEB-INF/jsp/welcome.jsp
    }
}
