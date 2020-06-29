package com.recipes.dataaccess.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

@Table(name="Recipe_Ingredient")
public class RecipeIngredients {
	
	@Id
	@GeneratedValue
	public Long id;
	
	@ManyToOne()
	@JoinColumn(name="Recipe_Id")
	public Recipes recipe;
	
	@ManyToOne()
	@JoinColumn(name="Ingredient_Id")
	public Ingredients ingredient;
	
	public int quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Recipes getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipes recipe) {
		this.recipe = recipe;
	}
	
	
	public Ingredients getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredients ingredient) {
		this.ingredient = ingredient;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "RecipeIngredients [id=" + id + ", recipe=" + recipe + ", ingredient=" + ingredient + ", quantity="
				+ quantity + "]";
	}
	
	
	

}
