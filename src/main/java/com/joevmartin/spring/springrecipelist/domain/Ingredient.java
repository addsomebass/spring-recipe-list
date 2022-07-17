package com.joevmartin.spring.springrecipelist.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;
	private BigDecimal amount;

	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure uom;

	@ManyToOne
	private Recipe recipe;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription( String name ) {
		this.description = name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount( BigDecimal quantity ) {
		this.amount = quantity;
	}

	public UnitOfMeasure getUom() {
		return uom;
	}

	public void setUom( UnitOfMeasure uom ) {
		this.uom = uom;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe( Recipe recipe ) {
		this.recipe = recipe;
	}
}