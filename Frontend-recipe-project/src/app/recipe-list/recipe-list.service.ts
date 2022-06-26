import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Recipe } from '../recipe';

@Injectable({
  providedIn: 'root'
})
export class RecipeListService {


  constructor(private httpClient: HttpClient ) { }

  getAllRecipes(): Observable<Recipe[]> {
    let url = "http://localhost:8081/recipedetails/recipes";
    return this.httpClient.get<Recipe[]>(url);

  }
  addNewRecipe(recipe: Recipe): Observable<Object>{
    let url = "http://localhost:8081/recipedetails/recipes";
    return this.httpClient.post(url,recipe);
  }

  getRecipeDetails(recipeName): Observable<Recipe>{
    return this.httpClient.get<Recipe>('http://localhost:8081/recipedetails/recipes/'+recipeName);
  }

  deleteRecipe(recipeName): Observable<Object>{
    return this.httpClient.delete('http://localhost:8081/recipedetails/recipes/'+recipeName);
  }

  updateRecipe(numberOfPeople: number, recipe: Recipe): Observable<Object>{
    return this.httpClient.put('http://localhost:8081/recipedetails/recipes/'+numberOfPeople, recipe);
  }

  getRecipe(recipeName): Observable<Recipe>{
    return this.httpClient.get<Recipe>('http://localhost:8081/recipedetails/recipes/'+recipeName);
  }
  updateRecipeDetails(recipeName: String, recipe: Recipe): Observable<Object>{
    return this.httpClient.put('http://localhost:8081/recipedetails/recipes/'+recipeName,recipe);
  }
}

