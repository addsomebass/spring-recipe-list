package com.joevmartin.spring.springrecipelist.repositories;

import com.joevmartin.spring.springrecipelist.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	Optional<Category> findByDescription(String description);

	Optional<Category[]> findCategoriesByDescriptionIsNotOrderByDescriptionDesc( String description);

}
