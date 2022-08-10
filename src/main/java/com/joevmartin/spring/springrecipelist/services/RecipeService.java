package com.joevmartin.spring.springrecipelist.services;

import com.joevmartin.spring.springrecipelist.commands.RecipeCommand;
import com.joevmartin.spring.springrecipelist.domain.Recipe;


import java.util.Set;

public interface RecipeService {

	public Set<Recipe> getRecipes();

	public Recipe findById(Long id);

	public RecipeCommand findCommandById(Long id);

	public RecipeCommand saveRecipeCommand ( RecipeCommand recipeCommand );
}
