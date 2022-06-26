package com.recipe.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.project.DTO.RecipeDTO;
import com.recipe.project.exception.RecipeException;
import com.recipe.project.service.RecipeService;
@CrossOrigin
@RestController 
@RequestMapping(value = "/recipedetails")
public class RecipeAPI {

	@Autowired
	private RecipeService recipeService;
	
	@GetMapping(value = "/recipes")
	public ResponseEntity<List<RecipeDTO>> getAllRecipeDetails() throws RecipeException {
		List<RecipeDTO> listOfRecipes = recipeService.getAllRecipes();
		return new ResponseEntity<>(listOfRecipes, HttpStatus.OK);

	}
	
	@GetMapping(value = "/recipes/{recipeName}")
	public ResponseEntity<RecipeDTO> getRecipeDetails(@PathVariable String recipeName) throws RecipeException {
		RecipeDTO recipeDetails = recipeService.getRecipeDetails(recipeName);
		return new ResponseEntity<>(recipeDetails, HttpStatus.OK);
}
	
	@PostMapping(value = "/recipes")
	public ResponseEntity<String> addRecipe(@RequestBody RecipeDTO recipe) throws RecipeException {
		recipeService.addRecipe(recipe);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/recipes/{recipeName}")
	public ResponseEntity<String> updateRecipe(@PathVariable String recipeName, @RequestBody RecipeDTO recipe) throws RecipeException {
		recipeService.updateRecipe(recipeName, recipe.getNumberOfPeople());
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/recipes/{recipeName}")
	public ResponseEntity<String> deleteRecipe(@PathVariable String recipeName) throws RecipeException {
		recipeService.deleteRecipe(recipeName);
		return new ResponseEntity<>( HttpStatus.OK);
	}
}
