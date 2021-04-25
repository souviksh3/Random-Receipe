package com.example.random_recipe.api;

import com.example.random_recipe.model.Recipes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("random.php")
    Call<Recipes> getRecipes();

}
