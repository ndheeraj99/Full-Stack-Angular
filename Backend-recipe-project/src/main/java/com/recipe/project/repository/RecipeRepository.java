package com.recipe.project.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.recipe.project.entity.RecipeEntity;

public interface RecipeRepository extends CrudRepository<RecipeEntity, Integer> {
	

	Optional<RecipeEntity> findByRecipeName(String recipeName);

	void deleteByRecipeName(String recipeName);
}
