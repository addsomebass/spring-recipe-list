package com.joevmartin.spring.springrecipelist.domain;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode(exclude = {"categories", "ingredients"})
@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;

	@Lob
	private String directions;

	@Enumerated(EnumType.STRING)
	private Difficulty difficulty;

	@Lob
	private Byte[] image;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe", fetch = FetchType.EAGER)
	private Set<Ingredient> ingredients = new HashSet<>();

	@OneToOne(cascade = CascadeType.ALL)
	private Note note;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "recipe_category",
			joinColumns = @JoinColumn(name = "recipe_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id")
	)
	private Set<Category> categories = new HashSet<>();

	public String getCategoryList() {
		return categories.stream().map( Category::getDescription ).collect( Collectors.joining(", ") );
	}

	public void addIngredient( Ingredient ingredient ) {
		ingredient.setRecipe( this );
		getIngredients().add( ingredient );
	}

	public void addCategory ( Category category ) {
		category.getRecipes().add( this );
		getCategories().add( category );
	}

}
