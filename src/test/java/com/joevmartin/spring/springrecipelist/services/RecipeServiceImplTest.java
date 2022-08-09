package com.joevmartin.spring.springrecipelist.services;

import com.joevmartin.spring.springrecipelist.converters.RecipeCommandToRecipe;
import com.joevmartin.spring.springrecipelist.converters.RecipeToRecipeCommand;
import com.joevmartin.spring.springrecipelist.domain.Recipe;
import com.joevmartin.spring.springrecipelist.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeService;

	@Mock
	RecipeRepository recipeRepository;

	@Mock
	RecipeCommandToRecipe recipeCommandToRecipe;

	@Mock
	RecipeToRecipeCommand recipeToRecipeCommand;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks( this );

		recipeService = new RecipeServiceImpl( recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand );
	}

	@Test
	void getRecipeById() {

		final Recipe recipe = new Recipe();
		recipe.setId( 1L );

		when(recipeRepository.findById( any() )).thenReturn( Optional.of( recipe ) );

		final Recipe byId = recipeService.findById( 1L );

		assertNotNull(byId);

		verify( recipeRepository, times( 1 ) ).findById( any() );

	}
}
