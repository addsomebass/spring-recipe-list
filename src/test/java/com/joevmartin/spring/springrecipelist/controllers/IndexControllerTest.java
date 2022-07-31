package com.joevmartin.spring.springrecipelist.controllers;

import com.joevmartin.spring.springrecipelist.domain.Difficulty;
import com.joevmartin.spring.springrecipelist.domain.Recipe;
import com.joevmartin.spring.springrecipelist.repositories.RecipeRepository;
import com.joevmartin.spring.springrecipelist.services.RecipeService;
import com.joevmartin.spring.springrecipelist.services.RecipeServiceImpl;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;

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
//		recipeService = new RecipeServiceImpl( recipeRepository );
	}

	@AfterEach
	void tearDown() throws Exception {
		mockitoAnnotations.close();
	}

	@Test
	void getIndexPage() {

		controller = new IndexController( recipeService );

		final String indexPage = controller.getIndexPage( model );

		Assertions.assertEquals( indexPage, "index" );
		Mockito.verify( recipeService, Mockito.times( 1 ) ).getRecipes();
		Mockito.verify( model, Mockito.times( 1 ) )
				.addAttribute( Mockito.eq( "recipes" ), Mockito.anySet() );


	}
}