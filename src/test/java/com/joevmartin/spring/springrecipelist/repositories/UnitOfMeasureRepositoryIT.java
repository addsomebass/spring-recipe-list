package com.joevmartin.spring.springrecipelist.repositories;

import com.joevmartin.spring.springrecipelist.domain.UnitOfMeasure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringJUnitConfig
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void findByDescription() {
		final Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription( "Teaspoon" );
		assertEquals( "Teaspoon", teaspoon.get().getDescription() );
	}

	@Test
	void findByDescriptionCup() {
		final Optional<UnitOfMeasure> cup = unitOfMeasureRepository.findByDescription( "Cup" );
		assertEquals( "Cup", cup.get().getDescription() );
	}
}