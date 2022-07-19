package com.joevmartin.spring.springrecipelist.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String description;

	@ManyToMany(mappedBy = "categories")
	private Set<Recipe> recipes;

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

	@Override
	public String toString() {
		return description;
	}
}
