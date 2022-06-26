import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Recipe } from '../recipe';
import { RecipeListService } from '../recipe-list/recipe-list.service';

@Component({
  selector: 'app-update-recipe-details',
  templateUrl: './update-recipe-details.component.html',
  styleUrls: ['./update-recipe-details.component.css']
})
export class UpdateRecipeDetailsComponent implements OnInit {
  recipeName: any;
  recipe: Recipe;

  constructor(private recipeListService: RecipeListService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.recipeName=this.route.snapshot.params['recipeName'];
    this.getRecipeDetails();
     }
   
     getRecipeDetails(){
       this.recipeListService.getRecipeDetails(this.recipeName).subscribe(data=>{
      this.recipe =data;
       })
      }
      onSubmit(){
        this.recipeListService.updateRecipeDetails(this.recipeName,this.recipe).subscribe(data=>{
          this.router.navigate(['/details/'+this.recipeName]);
        })
      }

}
