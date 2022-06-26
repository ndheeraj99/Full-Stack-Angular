package com.recipe.project;


import java.time.LocalDateTime;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.recipe.project.DTO.RecipeDTO;
import com.recipe.project.DTO.RecipeEnum;
import com.recipe.project.exception.RecipeException;
import com.recipe.project.service.RecipeService;

@SpringBootTest
public class RecipeTest {
		@Autowired
		private RecipeService recipeService; 
		
		
		@Test
		public void TestValidRecipeName() throws RecipeException {
			RecipeEnum type = RecipeEnum.Vegetarian;
			RecipeDTO recipe = new RecipeDTO("Biryani Rice",LocalDateTime.now(), type , 4,"abdcd wdsd", "dnfbcdhfbjvjbv");
			String valid = recipeService.addRecipe(recipe);
			Assertions.assertEquals(valid, recipe.getRecipeName());
		}
		
		@Test
		public void TestInValidRecipeName() throws RecipeException {
			RecipeEnum type = RecipeEnum.Vegetarian;
			RecipeDTO recipe = new RecipeDTO("ABC123",LocalDateTime.now(), type , 4,"abdcd wdsd", "dnfbcdhfbjvjbv");
			RecipeException exception=Assertions.assertThrows(RecipeException.class,()->recipeService.addRecipe(recipe));
			Assertions.assertEquals("Service.RECIPES_NOT_FOUND", exception.getMessage());
		}
		
	}

 



