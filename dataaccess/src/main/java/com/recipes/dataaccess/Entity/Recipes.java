package com.recipes.dataaccess.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Recipes {
	@Id
	@Column(name="Recipe_Id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Long id;
	
	@Column(unique=true,nullable=false)
	public String name;
	public String description;
	public String imagePath;
	
	@OneToMany(mappedBy="recipe",fetch=FetchType.EAGER,orphanRemoval=true, cascade = CascadeType.ALL)
	public Set<RecipeIngredients>  recipeIngredients;
	
	@Transient
	public List<Ingredients> Ingredients=new ArrayList<Ingredients>();
	
	
	public List<Ingredients> getIngredients() {
		return Ingredients;
	}
	public void setIngredients(List<Ingredients> ingredients) {
		Ingredients = ingredients;
	}
	public void addIngredient(Ingredients ing) {
		//System.out.println(ing);
		this.Ingredients.add(ing);
	}
	
	
	
	public Set<RecipeIngredients> getRecipeIngredients() {
		return recipeIngredients;
	}
	public void setRecipeIngredients(Set<RecipeIngredients> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}
	public void addRecipeIngredients(RecipeIngredients ri)
	{
		this.recipeIngredients.add(ri);
	}
	public void removeRecipeIngredients(RecipeIngredients ri)
	{
		this.recipeIngredients.remove(ri);
	}
	
	
	
	
	public Recipes() {
		super();
	}
	public Recipes( String name, String description, String imagePath,
			List<com.recipes.dataaccess.Entity.Ingredients> ingredients) {
		super();
		this.name = name;
		this.description = description;
		this.imagePath = imagePath;
		Ingredients = ingredients;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Recipes [id=" + id + ", name=" + name + ", description=" + description + ", imagePath=" + imagePath
				+ ", Ingredients=" + Ingredients + "]";
	}
	
	

}
