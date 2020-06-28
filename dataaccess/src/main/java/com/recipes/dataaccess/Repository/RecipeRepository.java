package com.recipes.dataaccess.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.recipes.dataaccess.Entity.Ingredients;
import com.recipes.dataaccess.Entity.RecipeIngredients;
import com.recipes.dataaccess.Entity.Recipes;

@Repository
@org.springframework.transaction.annotation.Transactional
public class RecipeRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public Recipes findById(long id) {
		Recipes recipe = em.find(Recipes.class, id);
		setIngredients(recipe.getRecipeIngredients(),recipe);
		return recipe;
	}
	
	public List<Recipes> findRecipes() {
		TypedQuery<Recipes> recipes = em.createQuery("select r from Recipes r", Recipes.class);
		List<Recipes> resultList = recipes.getResultList();
		for (Recipes recipe : resultList) {
			setIngredients(recipe.getRecipeIngredients(),recipe);
		}
		return resultList;
	}
	
	
	public List<Ingredients> getAllIngredients(){
		TypedQuery<Ingredients> ings = em.createQuery("select r from Ingredients r", Ingredients.class);
		return ings.getResultList();
		
	}
	
	public void insertRecipe(Recipes recipe) {
		
		List<Ingredients> allIngredients = getAllIngredients();
		for (Ingredients ingredient : recipe.getIngredients()) {
			if(!allIngredients.contains(ingredient))
			{
			RecipeIngredients reIng= new RecipeIngredients();
			reIng.setQuantity(ingredient.getQuantity());
			reIng.setIngredient(ingredient);
			reIng.setRecipe(recipe);
			em.persist(reIng);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	//UtilityMethods
	public void setIngredients(Set<RecipeIngredients> recipeIngredients, Recipes recipe)
	{
		for (RecipeIngredients reIng : recipeIngredients) {
			
			Ingredients ingredient = reIng.getIngredient();
			ingredient.setQuantity(reIng.getQuantity());
			recipe.addIngredient(ingredient);	
		}
		
	}
	
	
}
