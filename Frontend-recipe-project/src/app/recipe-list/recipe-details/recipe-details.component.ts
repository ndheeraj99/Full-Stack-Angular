import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Recipe } from 'src/app/recipe';
import { RecipeListService } from '../recipe-list.service';

@Component({
  selector: 'app-recipe-details',
  templateUrl: './recipe-details.component.html',
  styleUrls: ['./recipe-details.component.css']
})
export class RecipeDetailsComponent implements OnInit {
  recipeName: Recipe;

  recipe: Recipe;


  constructor(private recipeListService: RecipeListService, private route: ActivatedRoute ,
     private router: Router ) { }

  ngOnInit(): void {
 this.recipeName=this.route.snapshot.params['recipeName'];
 this.getRecipeDetails();
  }

  getRecipeDetails(){
    this.recipeListService.getRecipeDetails(this.recipeName).subscribe(data=>{
    this.recipe=data;
    },
    error=>{
    })

 
  }
  deleteRecipe(recipeName: String){
    this.recipeListService.deleteRecipe(recipeName).subscribe(data=>{
      this.recipeList();
    })
  }
  recipeList(){
    this.router.navigate(['/recipe-list']);
  }
  updateRecipe(recipeName){
    this.router.navigate(['/update/'+recipeName]);
  }
 

}
