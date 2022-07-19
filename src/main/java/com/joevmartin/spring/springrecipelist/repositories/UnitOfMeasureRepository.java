package com.joevmartin.spring.springrecipelist.repositories;

import com.joevmartin.spring.springrecipelist.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

	Optional<UnitOfMeasure> findByDescription( String description);

}
