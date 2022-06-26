package com.recipe.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recipe.project.DTO.RecipeDTO;
import com.recipe.project.entity.RecipeEntity;
import com.recipe.project.exception.RecipeException;
import com.recipe.project.repository.RecipeRepository;

@Service(value = "recipeService")
@Transactional
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private RecipeService recipeService;
	
	@Override
	public List<RecipeDTO> getAllRecipes() throws RecipeException {
		Iterable<RecipeEntity> recipe = recipeRepository.findAll();
		List<RecipeDTO> recipes = new ArrayList<>();
		recipe.forEach(recipeName -> {
			RecipeDTO recipe1 = new RecipeDTO();
			recipe1.setRecipeName(recipeName.getRecipeName());
			recipe1.setRecipeNumber(recipeName.getRecipeNumber());
			recipe1.setCreationDate(recipeName.getCreationDate());
			recipe1.setDishType(recipeName.getDishType());
			recipe1.setNumberOfPeople(recipeName.getNumberOfPeople());
			recipe1.setIngredients(recipeName.getIngredients());
			recipe1.setInstructions(recipeName.getInstructions());
			recipes.add(recipe1);
		}); 
		return recipes;
	}
	
	@Override
	public RecipeDTO getRecipeDetails(String recipeName) throws RecipeException {
		Optional<RecipeEntity> optional = recipeRepository.findByRecipeName(recipeName);
		RecipeEntity recipe = optional.orElseThrow(() -> new RecipeException("Service.RECIPE_NOT_FOUND"));
		RecipeDTO recipes = new RecipeDTO();
		recipes.setRecipeNumber(recipe.getRecipeNumber());
		recipes.setRecipeName(recipe.getRecipeName());
		recipes.setCreationDate(recipe.getCreationDate());
		recipes.setDishType(recipe.getDishType());
		recipes.setNumberOfPeople(recipe.getNumberOfPeople());
		recipes.setIngredients(recipe.getIngredients());
		recipes.setInstructions(recipe.getInstructions());
		return recipes;
	}
	
	@Override
	public String addRecipe(RecipeDTO recipe) throws RecipeException {
		if (!(recipe.getRecipeName().matches("(\\s*[a-zA-Z]*){9}"))) {
			throw new RecipeException("Service.RECIPE_NAME_MISMATCH");
		}
		List<RecipeDTO> recipeName =recipeService.getAllRecipes();
        List<RecipeDTO> list = new ArrayList<>();
        recipeName.forEach(data -> {
            if(data.getRecipeName().equalsIgnoreCase(recipe.getRecipeName()))
                list.add(data);
        });      
        if(!list.isEmpty())
         throw new RecipeException("Service.RECIPE_NAME_ERROR");
		RecipeEntity recipe1 = new RecipeEntity();
		recipe1.setRecipeName(recipe.getRecipeName());
		recipe1.setRecipeNumber(recipe.getRecipeNumber());
		recipe1.setCreationDate(recipe.getCreationDate());
		recipe1.setDishType(recipe.getDishType());
		recipe1.setNumberOfPeople(recipe.getNumberOfPeople());
		recipe1.setIngredients(recipe.getIngredients());
		recipe1.setInstructions(recipe.getInstructions());
		RecipeEntity recipes = recipeRepository.save(recipe1);
		return recipes.getRecipeName();
	}
	
	
	@Override
	public void updateRecipe(String recipeName, Integer numberOfPeople) throws RecipeException {
		Optional<RecipeEntity> recipe = recipeRepository.findByRecipeName(recipeName);
		RecipeEntity recipe1 = recipe.orElseThrow(() -> new RecipeException("Service.RECIPE_NOT_FOUND"));
		recipe1.setNumberOfPeople(numberOfPeople);
	}

	

	@Override
	public void deleteRecipe(String recipeName) throws RecipeException {
		Optional<RecipeEntity> recipe = recipeRepository.findByRecipeName(recipeName);
		recipe.orElseThrow(() -> new RecipeException("Service.RECIPE_NOT_FOUND"));
		recipeRepository.deleteByRecipeName(recipeName);
}


}
