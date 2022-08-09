package com.joevmartin.spring.springrecipelist.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoteCommand {

	private Long id;
	private RecipeCommand recipe;
	private String recipeNote;
}
