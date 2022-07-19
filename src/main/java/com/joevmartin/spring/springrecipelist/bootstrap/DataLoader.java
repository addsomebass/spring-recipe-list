package com.joevmartin.spring.springrecipelist.bootstrap;

import com.joevmartin.spring.springrecipelist.domain.*;
import com.joevmartin.spring.springrecipelist.repositories.CategoryRepository;
import com.joevmartin.spring.springrecipelist.repositories.RecipeRepository;
import com.joevmartin.spring.springrecipelist.repositories.UnitOfMeasureRepository;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private RecipeRepository recipeRepository;
	private CategoryRepository categoryRepository;
	private UnitOfMeasureRepository unitOfMeasureRepository;

	@Override
	public void onApplicationEvent( ContextRefreshedEvent event ) {
		final List<Recipe> recipes = getRecipes();

		recipeRepository.saveAll( recipes );

	}

	public DataLoader( RecipeRepository recipeRepository,
					   CategoryRepository categoryRepository,
					   UnitOfMeasureRepository unitOfMeasureRepository ) {
		this.recipeRepository = recipeRepository;
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}


	public List<Recipe> getRecipes() {

		final Category italian = categoryRepository.findByDescription( "Italian" ).orElseThrow( RuntimeException::new );
		final Category american = categoryRepository.findByDescription( "American" ).orElseThrow( RuntimeException::new );

		final UnitOfMeasure cup = unitOfMeasureRepository.findByDescription( "Cup" ).orElseThrow( RuntimeException::new );
		final UnitOfMeasure teaspoon = unitOfMeasureRepository.findByDescription( "Teaspoon" ).orElseThrow( RuntimeException::new );
		final UnitOfMeasure tablespoon = unitOfMeasureRepository.findByDescription( "Tablespoon" ).orElseThrow( RuntimeException::new );
		final UnitOfMeasure unit = unitOfMeasureRepository.findByDescription( "Unit" ).orElseThrow( RuntimeException::new );
		final UnitOfMeasure ounce = unitOfMeasureRepository.findByDescription( "Ounce" ).orElseThrow( RuntimeException::new );


		final Recipe zojirushiBread;
		{
			final Recipe recipe = new Recipe();
			recipe.setDifficulty( Difficulty.Moderate );
			recipe.setCookTime( 150 );
			recipe.setPrepTime( 10 );
			recipe.addCategory( american );
			recipe.setDescription( "Zojirushi Bread" );
			recipe.setDirections( "See note for directions" );
			recipe.setSource( "Bread Beckers - Recipe Collection - Basic Dough Recipe" );
			recipe.setUrl( "https://slothinthekitchen.com/ZojirushiBread" );
			recipe.setServings( 15 );

			{

				final Note note = new Note();
				note.setRecipeNote( "Combine water, oil, honey, salt, and egg. Add lecithin, gluten, half of flour, and ground\n" +
						"flax seed. Mix thoroughly. Add yeast and enough flour to make a soft dough. Knead until\n" +
						"smooth and elastic (about 5-6 minutes). Let rise until double. Shape as desired and let\n" +
						"rise again until double. For 2 - 1 lb. loaves bake at 350° 25-30 minutes.\n" +
						"Double recipe knead 8 minutes. Triple or quadruple recipe knead 12 minutes" );
				recipe.setNote( note );
			}


			{
				final Ingredient ingredient = getIngredient( "Honey", 0.3, cup );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Hot Water", 1.5, cup );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Oil", 0.3, cup );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Salt", 2, teaspoon );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Egg", 1, unit );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Lecithin", 2, tablespoon );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Gluten", 1, teaspoon );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Flour", 4, cup );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Flax Seed", 0.5, cup );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Yeast", 1, tablespoon );
				recipe.addIngredient( ingredient );
			}

			zojirushiBread = recipe;
		}


		final Recipe skettiSauce;
		{
			final Recipe recipe = new Recipe();
			recipe.setDifficulty( Difficulty.Easy );
			recipe.setCookTime( 240 );
			recipe.setPrepTime( 10 );
			recipe.addCategory( italian );
			recipe.setDescription( "Sketti Sauce" );
			recipe.setDirections( "See note for directions" );
			recipe.setSource( "Little Black Recipe Book" );
			recipe.setUrl( "https://slothinthekitchen.com/SkettiSauce" );
			recipe.setServings( 8 );

			{

				final Note note = new Note();
				note.setRecipeNote( "In a large port, heat olive oil on medium high heat\n" +
						"Add onion and cook for 5 minutes until soft\n" +
						"Add garlic and cook for 1 minute\n" +
						"Add remaining ingredients and simmer for 4 hours\n" +
						"* Use a blender after cooling for a smoother sauce instead of chunkier." );
				recipe.setNote( note );
			}


			{
				final Ingredient ingredient = getIngredient( "Olive Oil", 2, tablespoon );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Large Onion", 1, unit );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Cloves of Garlic", 5, unit );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Chicken Broth", 0.5, cup );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Crushed Tomato", 28, ounce );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Tomato Sauce", 15, ounce );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Sugar", 1, tablespoon );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Fennel Seeds", 1, tablespoon );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Oregano", 1, tablespoon );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Salt", 0.5, teaspoon );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Pepper", 0.25, teaspoon );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Basic", 0.5, cup );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Fresh Parsley", 0.5, cup );
				recipe.addIngredient( ingredient );
			}
			{
				final Ingredient ingredient = getIngredient( "Tomato Paste", 6, ounce );
				recipe.addIngredient( ingredient );
			}

			skettiSauce = recipe;

		}


		final ArrayList<Recipe> recipes = new ArrayList<>();
		recipes.add( zojirushiBread );
		recipes.add( skettiSauce );



		return recipes;
	}

	private Ingredient getIngredient( String ingredientName, double ingredientAmount, UnitOfMeasure uom ) {
		final Ingredient honey = new Ingredient();
		honey.setAmount( BigDecimal.valueOf( ingredientAmount ) );
		honey.setDescription( ingredientName );
		honey.setUom( uom );
		return honey;
	}


}
