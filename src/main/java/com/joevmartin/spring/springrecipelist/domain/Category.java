package com.joevmartin.spring.springrecipelist.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String description;


	//Add FetchType.EAGER here to fix the LazyInitializationException
	@ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
	private Set<Recipe> recipes = new HashSet<>();

	public Long getId() {
		return Id;
	}

	public void setId( Long id ) {
		Id = id;
	}

}
