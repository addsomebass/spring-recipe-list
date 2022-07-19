package com.joevmartin.spring.springrecipelist.repositories;

import com.joevmartin.spring.springrecipelist.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
