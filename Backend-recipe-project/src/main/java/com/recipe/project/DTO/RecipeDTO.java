package com.recipe.project.DTO;

import java.time.LocalDateTime;

import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;

public class RecipeDTO {
	
	private Integer recipeNumber;
	@NotNull
	@Pattern(regexp="[A-Za-z]+( [A-Za-z]+)*", message= "Only Alphabetical words")
	private String recipeName;
	private LocalDateTime creationDate;
	private RecipeEnum dishType;
	private Integer numberOfPeople;
	private String ingredients;
	private String instructions;
		
	public RecipeDTO() {
		
	}
	
	public RecipeDTO( String recipeName, LocalDateTime creationDate, RecipeEnum dishType,
			Integer numberOfPeople, String ingredients, String instructions) {
		this.recipeName = recipeName;
		this.creationDate = creationDate;
		this.dishType = dishType;
		this.numberOfPeople = numberOfPeople;
		this.ingredients = ingredients;
		this.instructions = instructions;
	}
	
	public Integer getRecipeNumber() {
		return recipeNumber;
	}
	public void setRecipeNumber(Integer recipeNumber) {
		this.recipeNumber = recipeNumber;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	
	public RecipeEnum getDishType() {
		return dishType;
	}
	public void setDishType(RecipeEnum dishType) {
		this.dishType = dishType;
	}
	public Integer getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(Integer numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}


}
