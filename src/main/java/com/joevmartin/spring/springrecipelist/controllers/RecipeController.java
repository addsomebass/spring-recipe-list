package com.joevmartin.spring.springrecipelist.controllers;

import com.joevmartin.spring.springrecipelist.commands.RecipeCommand;
import com.joevmartin.spring.springrecipelist.domain.Recipe;
import com.joevmartin.spring.springrecipelist.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class RecipeController {

	RecipeService recipeService;

	public RecipeController( RecipeService recipeService ) {
		this.recipeService = recipeService;
	}

	@RequestMapping(path = {"/recipe/{id}/show"})
	public String findRecipeById( @PathVariable Long id, Model model ) {

		final Recipe byId = recipeService.findById( id );

		model.addAttribute( "recipe", byId );

		return "recipe/show";
	}

	@RequestMapping(path = "/recipe/new")
	public String newRecipe(Model model) {
		model.addAttribute( "recipe", new RecipeCommand() );

		return "recipe/recipeform";
	}

	@RequestMapping(path = "/recipe/{id}/update")
	public String updateRecipe( @PathVariable Long id, Model model) {
		final RecipeCommand commandById = recipeService.findCommandById( id );

		model.addAttribute( "recipe", commandById );

		return "recipe/recipeform";
	}


	@PostMapping
	@RequestMapping("recipe")
	public String saveOrUpdateRecipe(@ModelAttribute RecipeCommand recipeCommand) {
		final RecipeCommand saveRecipeCommand = recipeService.saveRecipeCommand( recipeCommand );

		return "redirect:/recipe/" + saveRecipeCommand.getId() + "/show";

	}

}
