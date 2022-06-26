import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddRecipeComponent } from './recipe-list/add-recipe/add-recipe.component';
import { RecipeDetailsComponent } from './recipe-list/recipe-details/recipe-details.component';
import { RecipeListComponent } from './recipe-list/recipe-list.component';
import { UpdateRecipeDetailsComponent } from './update-recipe-details/update-recipe-details.component';


const routes: Routes = [
  
  {path: 'recipe-list', component: RecipeListComponent},
  {path: '', redirectTo: 'recipe-list', pathMatch: 'full'},
  {path: 'details/:recipeName', component: RecipeDetailsComponent},
  {path: 'details', component: RecipeDetailsComponent},
  {path: 'add', component: AddRecipeComponent},
  {path: 'update/:recipeName', component: UpdateRecipeDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
