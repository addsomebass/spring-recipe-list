package com.joevmartin.spring.springrecipelist.controllers;


import com.joevmartin.spring.springrecipelist.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class IndexController {


	private RecipeService recipeService;

	public IndexController( RecipeService recipeService ) {
		this.recipeService = recipeService;
	}

	@RequestMapping({"", "/", "/index"})
	public String getIndexPage( Model model) {

		log.debug( "testing debug logger" );
		model.addAttribute( "recipeList", recipeService.getRecipes() );

		return "index";
	}


}
