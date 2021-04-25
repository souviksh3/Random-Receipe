package com.example.random_recipe.presenter;

import android.widget.Toast;

import com.example.random_recipe.api.ApiClient;
import com.example.random_recipe.api.ApiInterface;
import com.example.random_recipe.model.Recipes;
import com.example.random_recipe.view.RecipesView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipesPresenter {

    public RecipesView view;

    public RecipesPresenter(RecipesView view) {
        this.view = view;
    }

    public void getRecipiesList()
    {
        view.showRefresh();

        ApiInterface apiInterface = ApiClient.getRetrofitClint().create(ApiInterface.class);

        Call<Recipes> call = apiInterface.getRecipes();

        call.enqueue(new Callback<Recipes>() {
            @Override
            public void onResponse(Call<Recipes> call, Response<Recipes> response) {

                if(response.isSuccessful())
                {
                    view.hideRefresh();
                    view.onRequestSucess();
                    view.getRecipesList(response.body());


                }

            }

            @Override
            public void onFailure(Call<Recipes> call, Throwable t) {
                view.onRequestError(t.getLocalizedMessage());

            }
        });
    }
}
