package com.recipes.dataaccess.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Ingredients {

	@Id
	@GeneratedValue( strategy=GenerationType.SEQUENCE)
	@Column(name="Ingredient_Id")
	public Long id;
	
	@Column(unique=true,nullable=false)
	public String name;
	@Transient
	public int quantity;
	
	@OneToMany(mappedBy="ingredient")
	public Set<RecipeIngredients>  recipeIngredients;
	
	
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	public Ingredients() {
		super();
	}
	public Ingredients(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Ingredients [id=" + id + ", name=" + name + ", quantity=" + quantity + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredients other = (Ingredients) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
