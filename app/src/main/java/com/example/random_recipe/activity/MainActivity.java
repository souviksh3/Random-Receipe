package com.example.random_recipe.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.Toast;

import com.example.random_recipe.R;
import com.example.random_recipe.adaptar.RecipesAdaptar;
import com.example.random_recipe.model.Recipes;
import com.example.random_recipe.presenter.RecipesPresenter;
import com.example.random_recipe.view.RecipesView;

public class MainActivity extends AppCompatActivity implements RecipesView {

    SwipeRefreshLayout mSwip;
    RecyclerView mRecyclerView;
    RecipesPresenter recipesPresenter;
    RecipesAdaptar recipesAdaptar;
    RecipesAdaptar.ItemClick itemClick;
    Recipes recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSwip=findViewById(R.id.swipe_refresh);
        mRecyclerView=findViewById(R.id.recyclerView);

        recipesPresenter = new RecipesPresenter(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        recipesPresenter.getRecipiesList();

        mSwip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                recipesPresenter.getRecipiesList();
            }
        });

    }

    @Override
    public void showRefresh() {

        mSwip.setRefreshing(true);

    }

    @Override
    public void hideRefresh() {
        mSwip.setRefreshing(false);

    }

    @Override
    public void getRecipesList(Recipes recipeList) {
        recipesAdaptar = new RecipesAdaptar(MainActivity.this,recipeList,itemClick);
        recipesAdaptar.notifyDataSetChanged();
        mRecyclerView.setAdapter(recipesAdaptar);
        recipe = recipeList;
    }

    @Override
    public void onRequestSucess() {
        Toast.makeText(MainActivity.this,"sucessfull",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onRequestError(String message) {

        Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();

    }
}
