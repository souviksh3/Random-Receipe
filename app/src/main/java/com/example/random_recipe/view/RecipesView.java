package com.example.random_recipe.view;

import com.example.random_recipe.model.Recipes;

public interface RecipesView {
    void showRefresh();//to show refresh
    void hideRefresh();//to hide refresh
    void getRecipesList(Recipes recipeList);//to get the list
    void onRequestSucess();//to get the sucess msg form server
    void onRequestError(String message);
}
