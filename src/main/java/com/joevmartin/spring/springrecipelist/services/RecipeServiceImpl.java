package com.joevmartin.spring.springrecipelist.services;

import com.joevmartin.spring.springrecipelist.domain.Recipe;
import com.joevmartin.spring.springrecipelist.repositories.RecipeRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RecipeServiceImpl implements RecipeService {

	private RecipeRepository recipeRepository;

	public RecipeServiceImpl( RecipeRepository recipeRepository ) {
		this.recipeRepository = recipeRepository;
	}

	public List<Recipe> getRecipes() {
		return StreamSupport.stream( recipeRepository.findAll().spliterator(), false )
				.collect( Collectors.toList() );
	}

}
