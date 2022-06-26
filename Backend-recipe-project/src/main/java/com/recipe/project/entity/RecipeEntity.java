package com.recipe.project.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.recipe.project.DTO.RecipeEnum;

@Entity
@Table(name="recipe")
public class RecipeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer recipeNumber;
	private String recipeName;
	private LocalDateTime creationDate;
	@Column(columnDefinition = "enum('Vegetarian','Non_Vegetarian')")
	@Enumerated(EnumType.STRING)
	private RecipeEnum dishType;
	private Integer numberOfPeople;
	private String ingredients;
	private String instructions;
	
	
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
