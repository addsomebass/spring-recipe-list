package com.joevmartin.spring.springrecipelist.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String description;


	//Add FetchType.EAGER here to fix the LazyInitializationException
	@ManyToMany(mappedBy = "categories")
	private Set<Recipe> recipes = new HashSet<>();

	public Long getId() {
		return Id;
	}

	public void setId( Long id ) {
		Id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription( String name ) {
		this.description = name;
	}

	public Set<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes( Set<Recipe> recipes ) {
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		return description;
	}
}
