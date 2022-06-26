import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Recipe } from 'src/app/recipe';
import { RecipeListService } from '../recipe-list.service';

@Component({
  selector: 'app-add-recipe',
  templateUrl: './add-recipe.component.html',
  styleUrls: ['./add-recipe.component.css']
})
export class AddRecipeComponent implements OnInit {
  recipe: Recipe = new Recipe();
  errorMessage: any;
  registerRecipe: any;

  constructor(private recipeListService: RecipeListService, private router: Router) { }

  ngOnInit(): void {

  }

  addRecipe() {
    this.recipeListService.addNewRecipe(this.recipe).subscribe(data => {
      this.goToAddRecipe();
    }, error=>console.log(error));
  }
  goToAddRecipe() {
    this.router.navigate(['/recipe-list']);
  }
  onSubmit() {
    this.addRecipe();
  }


}
