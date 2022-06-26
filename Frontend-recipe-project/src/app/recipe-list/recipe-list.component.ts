import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Recipe } from '../recipe';
import { RecipeListService } from './recipe-list.service';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {

  selectedRecipe: Recipe;
  recipes: Recipe[];
  viewRecipeDetails: boolean = false;

  recipeDetails: Recipe[] = [];
  recipeInformation: Recipe;
  recipe: Recipe;

  constructor(private recipeListService: RecipeListService, private router: Router,
    private route: ActivatedRoute) { }


  ngOnInit(): void {


    this.getRecipes();
  }

  private getRecipes() {
    this.recipeListService.getAllRecipes().subscribe(data => {
      this.recipes = data;
      this.recipeDetails = this.recipes;
    });
  }

  addRecipe(){
   }

}


