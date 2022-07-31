package com.joevmartin.spring.springrecipelist.services;

import com.joevmartin.spring.springrecipelist.domain.Recipe;

import java.util.List;
import java.util.Set;

public interface RecipeService {

	public Set<Recipe> getRecipes();
}
