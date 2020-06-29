package com.recipes.dataaccess;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.recipes.dataaccess.Entity.Ingredients;
import com.recipes.dataaccess.Entity.RecipeDTO;
import com.recipes.dataaccess.Entity.Recipes;
import com.recipes.dataaccess.Repository.RecipeRepository;

@SpringBootApplication
public class DataaccessApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	RecipeRepository recipeRepo;
	public static void main(String[] args) {
		SpringApplication.run(DataaccessApplication.class, args);
	}

	public void run(String... args) throws Exception {
		//fIND A RECIPE BY ID
//		Recipes recipe = recipeRepo.findById(2L);
//		logger.info("Recipe ----------->{}",recipe);
		
//		//FIND ALL RECIPES
//		List<Recipes> recipes = recipeRepo.findRecipes();
//		for (Recipes recipes2 : recipes) {
//			logger.info("Recipes ----------->{}",recipes2);
//		}
		
		//INSERT A NEW RECIPE WITH EXTING INGREDIENTS 
//		List<Ingredients>ing=new ArrayList<Ingredients>();
//		Ingredients ing1= new Ingredients("pasta", 2);
//		ing.add(ing1);
//		Ingredients ing2= new Ingredients("cheese", 3);
//		ing.add(ing2);
//		Ingredients ing3= new Ingredients("Spices", 4);
//		ing.add(ing3);
//		Recipes recipeNew=new Recipes("Desi Pasta", "Desi pasta made with Indian spices and cheese", 
//				"https://upload.wikimedia.org/wikipedia/commons/e/e9/Egyptian_food_Koshary.jpg", ing);
//		recipeRepo.insertRecipe(recipeNew);
//		
//		Recipes recipe = recipeRepo.findById(2L);
//		logger.info("Recipe ----------->{}",recipe);

//		List<Ingredients>ingList=new ArrayList<Ingredients>();
//		Ingredients ing4= new Ingredients("pasta", 7);
//		ingList.add(ing4);
//		Ingredients ing5= new Ingredients("American cheese", 3);
//		ingList.add(ing5);
//		Ingredients ing6= new Ingredients("Spices", 4);
//		ingList.add(ing6);
//		Recipes recipeNew2=new Recipes("American Pasta", "American pasta made with lot of cheese", 
//				"https://upload.wikimedia.org/wikipedia/commons/e/e9/Egyptian_food_Koshary.jpg", ingList);
//		recipeRepo.insertRecipe(recipeNew2);

		//UPDATE A RECIPE 
//		Recipes recipe1 = recipeRepo.getRecipeByName("Indian Dosa");
//		recipe1.setDescription("Changed the desription");
//		Stream<Ingredients> stream = recipe1.getIngredients().stream();
//		Predicate<Ingredients> p1=ing -> ing.getName().equals("Chillies");
//		stream.filter(p1).forEach(ing->ing.setQuantity(9999));
//		recipeRepo.insertRecipe(recipe1);
		
		//REMOVE A RECIPE
		recipeRepo.removeRecipeById(204L);
		
		//FIND ALL RECIPES
//		 List<RecipeDTO> findRecipes = recipeRepo.findRecipes();
//		for (RecipeDTO recipeDTO : findRecipes) {
//			logger.info("Recipes ----------->{}",recipeDTO);
//		}
		
	}

}
