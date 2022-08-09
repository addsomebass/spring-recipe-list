package com.joevmartin.spring.springrecipelist.services;

import com.joevmartin.spring.springrecipelist.commands.RecipeCommand;
import com.joevmartin.spring.springrecipelist.converters.RecipeCommandToRecipe;
import com.joevmartin.spring.springrecipelist.converters.RecipeToRecipeCommand;
import com.joevmartin.spring.springrecipelist.domain.Recipe;
import com.joevmartin.spring.springrecipelist.repositories.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith( SpringExtension.class )
@SpringBootTest
class RecipeServiceIT {

	private static final String MY_NEW_DESCRIPTION = "My New Description";

	@Autowired
	RecipeService recipeService;

	@Autowired
	RecipeRepository recipeRepository;

	@Autowired
	RecipeToRecipeCommand recipeToRecipeCommand;

	@Autowired
	RecipeCommandToRecipe recipeCommandToRecipe;


	@Test
	void saveRecipeCommand() {

		//given
		final Iterable<Recipe> all = recipeRepository.findAll();
		final Recipe recipe = all.iterator().next();
		final RecipeCommand recipeCommand = recipeToRecipeCommand.convert( recipe );

		//when
		recipeCommand.setDescription( MY_NEW_DESCRIPTION );
		final RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand( recipeCommand );
		recipeService.saveRecipeCommand( savedRecipeCommand );

		//then
		assertEquals( MY_NEW_DESCRIPTION, savedRecipeCommand.getDescription() );
		assertEquals( savedRecipeCommand.getId(), recipe.getId() );
		assertEquals( savedRecipeCommand.getCategories().size(), recipe.getCategories().size() );
		assertEquals( savedRecipeCommand.getIngredients().size(), recipe.getIngredients().size() );


	}
}