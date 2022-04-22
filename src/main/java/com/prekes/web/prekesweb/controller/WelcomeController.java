package com.prekes.web.prekesweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
@Controller is used to mark classes as Spring MVC Controller.
@RestController is a convenience annotation that does nothing more than adding the @Controller and @ResponseBody annotations
*/

// MVC controller
@Controller
public class WelcomeController {

	@GetMapping("/")
	public String showRootPage(ModelMap model) {
		return "index";
	}

	@GetMapping("/index")
	public String showWelcomePage(@RequestParam String name, ModelMap model) {
		return "index";
	}
}
