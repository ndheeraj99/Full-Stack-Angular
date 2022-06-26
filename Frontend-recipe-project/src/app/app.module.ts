import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { RecipeListComponent } from './recipe-list/recipe-list.component';

import { RecipeDetailsComponent } from './recipe-list/recipe-details/recipe-details.component';
import { AddRecipeComponent } from './recipe-list/add-recipe/add-recipe.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UpdateRecipeDetailsComponent } from './update-recipe-details/update-recipe-details.component';



@NgModule({
  declarations: [
    AppComponent, 
    RecipeListComponent, RecipeDetailsComponent, 
    AddRecipeComponent, UpdateRecipeDetailsComponent 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
