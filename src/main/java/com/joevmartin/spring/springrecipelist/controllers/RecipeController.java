package com.joevmartin.spring.springrecipelist.controllers;

import com.joevmartin.spring.springrecipelist.domain.Recipe;
import com.joevmartin.spring.springrecipelist.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class RecipeController {

	RecipeService recipeService;

	public RecipeController( RecipeService recipeService ) {
		this.recipeService = recipeService;
	}

	@RequestMapping(path = {"/recipe/show/{id}"})
	public String findRecipeById( @PathVariable Long id, Model model ) {

		final Recipe byId = recipeService.findById( id );

		model.addAttribute( "recipe", byId );

		return "recipe/show";
	}

}
