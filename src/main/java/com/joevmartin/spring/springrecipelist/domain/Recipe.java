package com.joevmartin.spring.springrecipelist.domain;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer services;
	private String source;
	private String url;
	private String directions;
	//todo add
	//private Difficulty difficulty

	@Lob
	private Byte[] image;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private Set<Ingredient> ingredients = new HashSet<>();

	@OneToOne(cascade = CascadeType.ALL)
	private Note note;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription( String description ) {
		this.description = description;
	}

	public Integer getPrepTime() {
		return prepTime;
	}

	public void setPrepTime( Integer prepTime ) {
		this.prepTime = prepTime;
	}

	public Integer getCookTime() {
		return cookTime;
	}

	public void setCookTime( Integer cookTime ) {
		this.cookTime = cookTime;
	}

	public Integer getServices() {
		return services;
	}

	public void setServices( Integer services ) {
		this.services = services;
	}

	public String getSource() {
		return source;
	}

	public void setSource( String source ) {
		this.source = source;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl( String url ) {
		this.url = url;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections( String directions ) {
		this.directions = directions;
	}

	public Byte[] getImage() {
		return image;
	}

	public void setImage( Byte[] image ) {
		this.image = image;
	}

	public Note getNote() {
		return note;
	}

	public void setNote( Note note ) {
		this.note = note;
	}
}
