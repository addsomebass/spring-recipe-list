package com.joevmartin.spring.springrecipelist.controllers;

import com.joevmartin.spring.springrecipelist.domain.Recipe;
import com.joevmartin.spring.springrecipelist.services.RecipeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class IndexControllerTest {

	IndexController controller;

	@Mock
	RecipeService recipeService;

	@Mock
	Model model;

	private AutoCloseable mockitoAnnotations;

	@BeforeEach
	void setUp() {
		mockitoAnnotations = MockitoAnnotations.openMocks( this );
		controller = new IndexController( recipeService );
	}

	@AfterEach
	void tearDown() throws Exception {
		mockitoAnnotations.close();
	}

	@Test
	void testMockMVC() throws Exception {

		MockMvc mockMvc = MockMvcBuilders.standaloneSetup( controller ).build();

		mockMvc.perform( get("/") )
				.andExpect( status().isOk() )
				.andExpect( view().name( "index" ) );

	}

	@Test
	void getIndexPage() {

		//given
		Set<Recipe> recipes = new HashSet<>();

		final Recipe recipe1 = new Recipe();
		recipe1.setId( 1L );
		recipes.add( recipe1 );

		final Recipe recipe2 = new Recipe();
		recipe2.setId( 2L );
		recipes.add( recipe2 );


		when(recipeService.getRecipes()).thenReturn( recipes );

		ArgumentCaptor<Set<Recipe>> setArgumentCaptor = ArgumentCaptor.forClass( Set.class );



		//when
		final String indexPage = controller.getIndexPage( model );


		//then
		assertEquals( indexPage, "index" );
		verify( recipeService, times( 1 ) ).getRecipes();
		verify( model, times( 1 ) )
				.addAttribute( eq( "recipes" ), setArgumentCaptor.capture() );
		final Set<Recipe> setInController = setArgumentCaptor.getValue();

		assertEquals(2, setInController.size());



	}
}