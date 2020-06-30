package com.recipes.dataaccess.Entity;

import java.util.ArrayList;
import java.util.List;	

public class RecipeDTO {
	
	public Long id;
	public String name;
	public String description;
	public String imagePath;
	
	public List<IngredientDTO> ingredients=new ArrayList();

	public RecipeDTO(Long id, String name, String description, String imagePath) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.imagePath = imagePath;
	}

	public void addIngredient(IngredientDTO ing) {
		this.ingredients.add(ing);
	}

	@Override
	public String toString() {
		return "RecipeDTO [id=" + id + ", name=" + name + ", description=" + description + ", imagePath=" + imagePath
				+ ", ingredients=" + ingredients + "]";
	}
	
	
	
}
