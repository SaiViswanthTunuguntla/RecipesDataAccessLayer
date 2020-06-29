package com.recipes.dataaccess.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.recipes.dataaccess.Entity.IngredientDTO;
import com.recipes.dataaccess.Entity.Ingredients;
import com.recipes.dataaccess.Entity.RecipeDTO;
import com.recipes.dataaccess.Entity.RecipeIngredients;
import com.recipes.dataaccess.Entity.Recipes;

@Repository
@org.springframework.transaction.annotation.Transactional
public class RecipeRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public RecipeDTO findById(long id) {
		Recipes recipe = em.find(Recipes.class, id);
		RecipeDTO reccipeDto=new RecipeDTO(recipe.getId(), recipe.getName(), recipe.getDescription(), recipe.getImagePath());
		RecipeDTO recipeDTO = setIngredients(recipe.getRecipeIngredients(), recipe,reccipeDto);
		return recipeDTO;
	}

	public List<RecipeDTO> findRecipes() {
		TypedQuery<Recipes> recipes = em.createQuery("select r from Recipes r", Recipes.class);
		List<Recipes> resultList = recipes.getResultList();
		List<RecipeDTO> finalList= new ArrayList<RecipeDTO>();
		for (Recipes recipe : resultList) {
			RecipeDTO reccipeDto=new RecipeDTO(recipe.getId(), recipe.getName(), recipe.getDescription(), recipe.getImagePath());
			finalList.add(setIngredients(recipe.getRecipeIngredients(), recipe, reccipeDto));
		}
		return finalList;
	}

	public List<Ingredients> getAllIngredients() {
		TypedQuery<Ingredients> ings = em.createQuery("select r from Ingredients r", Ingredients.class);
		return ings.getResultList();
	}
	
	//DELETE A RECIPE
	public void removeRecipeById(long id) {
		Recipes recipe = em.find(Recipes.class, id);
		 //recipe.getRecipeIngredients().removeAll(recipe.getRecipeIngredients());
		em.remove(recipe);
		em.flush();
		List<RecipeDTO> findRecipes = findRecipes();
		for (RecipeDTO recipeDTO : findRecipes) {
			System.out.println(recipeDTO);
		}
		em.clear();
	}

	public void insertRecipe(Recipes recipe) {
		if (recipe.getId() != null) {//update a  recipe starts
			Recipes retreivedRecipe = em.merge(recipe);
			
			List<Ingredients> allIngredients = getAllIngredients();
			Set<RecipeIngredients> recipeIngredients = retreivedRecipe.getRecipeIngredients();
			
			for (Ingredients ingredient : recipe.getIngredients()) {
				boolean isIngExist=false;
				if (allIngredients.contains(ingredient)) {
					Ingredients retreivedIng = getIngredientByName(ingredient.getName());

					for (RecipeIngredients recipeIngredients2 : recipeIngredients) {
						
						if(recipeIngredients2.getIngredient().getName().equals(ingredient.getName()))
						{
							recipeIngredients2.setQuantity(ingredient.getQuantity());
							isIngExist=true;
							break;
						}
					}
					if(!isIngExist) {
						retreivedIng.setQuantity(ingredient.getQuantity());
						RecipeIngredients reIng = new RecipeIngredients();
						reIng.setQuantity(retreivedIng.getQuantity());
						reIng.setIngredient(retreivedIng);
						reIng.setRecipe(retreivedRecipe);
						em.persist(reIng);
					}
				} else {
					RecipeIngredients reIng = new RecipeIngredients();
					reIng.setQuantity(ingredient.getQuantity());
					reIng.setIngredient(ingredient);
					reIng.setRecipe(retreivedRecipe);
					em.persist(reIng);
				}
			}
		} //update a  recipe ends 
		//below code to insert a new recipe
		else {
			List<Ingredients> allIngredients = getAllIngredients();
			for (Ingredients ingredient : recipe.getIngredients()) {
				if (allIngredients.contains(ingredient)) {
					Ingredients retreivedIng = getIngredientByName(ingredient.getName());
					retreivedIng.setQuantity(ingredient.getQuantity());

					RecipeIngredients reIng = new RecipeIngredients();
					reIng.setQuantity(retreivedIng.getQuantity());
					reIng.setIngredient(retreivedIng);
					reIng.setRecipe(recipe);
					em.persist(reIng);
				} else {
					RecipeIngredients reIng = new RecipeIngredients();
					reIng.setQuantity(ingredient.getQuantity());
					reIng.setIngredient(ingredient);
					reIng.setRecipe(recipe);
					em.persist(reIng);
				}
			}
		}
	}

	public Ingredients getIngredientByName(String name) {
		Query q = em.createNativeQuery("select * from Ingredients  where name=?", Ingredients.class);
		q.setParameter(1, name);
		Ingredients ing = (Ingredients) q.getSingleResult();
		return ing;
	}

	public Recipes getRecipeByName(String name) {
		Query q = em.createNativeQuery("select * from Recipes  where name=?", Recipes.class);
		q.setParameter(1, name);
		Recipes recipe = (Recipes) q.getSingleResult();
		return setIngredients(recipe.getRecipeIngredients(), recipe);
		//return recipe;
	}

	private Recipes setIngredients(Set<RecipeIngredients> recipeIngredients, Recipes recipe) {
		for (RecipeIngredients reIng : recipeIngredients) {
			Ingredients ingredient = reIng.getIngredient();
			ingredient.setQuantity(reIng.getQuantity());
			recipe.addIngredient(ingredient);
		}
		return recipe;
	}

	// UtilityMethods
	public RecipeDTO setIngredients(Set<RecipeIngredients> recipeIngredients, Recipes recipe, RecipeDTO reccipeDto) {
		for (RecipeIngredients reIng : recipeIngredients) {
			IngredientDTO ingredient = new IngredientDTO(reIng.getIngredient().getId(), reIng.getIngredient().getName());
			ingredient.setQuantity(reIng.getQuantity());
			reccipeDto.addIngredient(ingredient);
		}
		return reccipeDto;
	}

}
