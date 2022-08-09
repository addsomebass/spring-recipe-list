package com.joevmartin.spring.springrecipelist.controllers;

import com.joevmartin.spring.springrecipelist.domain.Recipe;
import com.joevmartin.spring.springrecipelist.services.RecipeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class RecipeControllerTest {

	@Mock
	RecipeService recipeService;

	RecipeController recipeController;
	private AutoCloseable mocks;

	@BeforeEach
	void setUp() {
		mocks = MockitoAnnotations.openMocks( this );

		recipeController = new RecipeController( recipeService );


	}

	@AfterEach
	void tearDown() throws Exception {
		mocks.close();
	}

	@Test
	void findRecipeById() throws Exception {

		final Recipe recipe = new Recipe();
		recipe.setId( 1L );

		final MockMvc mockMvc = MockMvcBuilders.standaloneSetup( recipeController ).build();

		mockMvc.perform( get("/recipe/show/1") )
				.andExpect( status().isOk() )
				.andExpect( view().name( "recipe/show" ) );

	}
}