package com.joevmartin.spring.springrecipelist.services;

import com.joevmartin.spring.springrecipelist.commands.RecipeCommand;
import com.joevmartin.spring.springrecipelist.converters.RecipeCommandToRecipe;
import com.joevmartin.spring.springrecipelist.converters.RecipeToRecipeCommand;
import com.joevmartin.spring.springrecipelist.domain.Recipe;
import com.joevmartin.spring.springrecipelist.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RecipeServiceImpl implements RecipeService {

	private RecipeRepository recipeRepository;
	private RecipeCommandToRecipe recipeCommandToRecipe;
	private RecipeToRecipeCommand recipeToRecipeCommand;

	public RecipeServiceImpl( RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand ) {
		this.recipeRepository = recipeRepository;
		this.recipeCommandToRecipe = recipeCommandToRecipe;
		this.recipeToRecipeCommand = recipeToRecipeCommand;
	}

	public Set<Recipe> getRecipes() {
		return StreamSupport.stream( recipeRepository.findAll().spliterator(), false )
				.collect( Collectors.toSet() );
	}

	@Override
	public Recipe findById( Long id ) {
		final Optional<Recipe> byId = recipeRepository.findById( id );

		if (byId.isEmpty()) {
			throw new RuntimeException("Could not find Recipe with id: " + id);
		}

		return byId.get();
	}

	@Override
	public RecipeCommand findCommandById( Long id ) {
		final Optional<Recipe> byId = recipeRepository.findById( id );

		if (byId.isEmpty()) {
			throw new RuntimeException("Could not find Recipe with id: " + id);
		}

		return recipeToRecipeCommand.convert( byId.get() );
	}

	@Transactional
	@Override
	public RecipeCommand saveRecipeCommand( RecipeCommand recipeCommand ) {
		Recipe detachedRecipe = recipeCommandToRecipe.convert( recipeCommand );

		final Recipe save = recipeRepository.save( detachedRecipe );

		return recipeToRecipeCommand.convert( save );
	}
}
