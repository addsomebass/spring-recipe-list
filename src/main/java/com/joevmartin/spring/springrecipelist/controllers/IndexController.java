package com.joevmartin.spring.springrecipelist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping({"", "/", "/index"})
	public String getIndexPage() {
		return "index";
	}


}
