package com.recipe.project.service;

import java.util.List;

import com.recipe.project.DTO.RecipeDTO;
import com.recipe.project.exception.RecipeException;

public interface RecipeService {
	public List<RecipeDTO> getAllRecipes() throws RecipeException;
	public RecipeDTO getRecipeDetails(String recipeName) throws RecipeException;
	public String addRecipe(RecipeDTO recipe) throws RecipeException;
	public void updateRecipe(String recipeName, Integer numberOfPeople) throws RecipeException;
	public void deleteRecipe(String recipeName) throws RecipeException;

}
