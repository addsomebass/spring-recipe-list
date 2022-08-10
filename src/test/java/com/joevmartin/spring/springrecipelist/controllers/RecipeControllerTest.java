package com.joevmartin.spring.springrecipelist.controllers;

import com.joevmartin.spring.springrecipelist.commands.RecipeCommand;
import com.joevmartin.spring.springrecipelist.converters.RecipeCommandToRecipe;
import com.joevmartin.spring.springrecipelist.converters.RecipeToRecipeCommand;
import com.joevmartin.spring.springrecipelist.domain.Recipe;
import com.joevmartin.spring.springrecipelist.services.RecipeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class RecipeControllerTest {

	@Mock
	RecipeService recipeService;

	RecipeController recipeController;
	private AutoCloseable mocks;

	@BeforeEach
	void setUp() {
		mocks = MockitoAnnotations.openMocks( this );

		recipeController = new RecipeController( recipeService);


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

		mockMvc.perform( get("/recipe/1/show/") )
				.andExpect( status().isOk() )
				.andExpect( view().name( "recipe/show" ) );

	}

	@Test
	void postNewRecipe() throws Exception {

		final RecipeCommand recipeCommand = new RecipeCommand();
		recipeCommand.setId( 2L );

		final MockMvc mockMvc = MockMvcBuilders.standaloneSetup( recipeController ).build();

		when( recipeService.saveRecipeCommand( any() ) ).thenReturn( recipeCommand );

		mockMvc.perform( post( "/recipe" )
						.contentType( MediaType.APPLICATION_FORM_URLENCODED )
						.param( "id", "")
						.param("description", "this is a test")
				).andExpect( status().is3xxRedirection() )
				.andExpect( view().name( "redirect:/recipe/" + recipeCommand.getId() + "/show" ) );

	}

	@Test
	void updateRecipe() throws Exception {

		final RecipeCommand recipe = new RecipeCommand();
		recipe.setId( 3L );

		when( recipeService.findCommandById( any() ) ).thenReturn( recipe );

		final MockMvc mockMvc = MockMvcBuilders.standaloneSetup( recipeController ).build();

		mockMvc.perform( get( "/recipe/1/update" ) )
				.andExpect( status().isOk() )
				.andExpect( view().name( "recipe/recipeform" ) )
				.andExpect( model().attributeExists( "recipe" ) );

	}
}