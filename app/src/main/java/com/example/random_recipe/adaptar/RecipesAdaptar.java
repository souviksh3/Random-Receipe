package com.example.random_recipe.adaptar;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.random_recipe.R;
import com.example.random_recipe.model.Recipes;
import com.squareup.picasso.Picasso;

public class RecipesAdaptar extends RecyclerView.Adapter<RecipesAdaptar.MyRecyclerViewAdapter> {

    Context context;
    Recipes recipesList;
    ItemClick itemClick;//for click the video li
    // nk
    public RecipesAdaptar(Context context, Recipes recipesList, ItemClick itemClick) {
        this.context = context;
        this.recipesList = recipesList;
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =LayoutInflater.from(context).inflate(R.layout.recipe_list, parent,false);
        return new MyRecyclerViewAdapter(view,itemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesAdaptar.MyRecyclerViewAdapter holder, int position)
    {
        Recipes rp = recipesList;
        holder.recipe_titel.setText(String.format("TITLE : %s",rp.getMeals().get(position).getStrMeal()));
//        holder.recipe_tag.setText(rp.getMeals().get(position).getStrTags());
        holder.recipie_area.setText(rp.getMeals().get(position).getStrArea());
        holder.recipe_category.setText(rp.getMeals().get(position).getStrCategory());
        holder.recipie_description.setText(rp.getMeals().get(position).getStrInstructions());
        holder.recipie_video_link.setText(rp.getMeals().get(position).getStrYoutube());
        Picasso.get()
                .load(rp.getMeals().get(position).getStrMealThumb()).into(holder.recipe_image);
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient1()+ ", " +rp.getMeals().get(position).getStrMeasure1());
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient2()+ ", " +rp.getMeals().get(position).getStrMeasure2());
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient3()+ ", " +rp.getMeals().get(position).getStrMeasure3());
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient4()+ ", " +rp.getMeals().get(position).getStrMeasure4());
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient5()+ ", " +rp.getMeals().get(position).getStrMeasure5());
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient6()+ ", " +rp.getMeals().get(position).getStrMeasure6());
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient7()+ ", " +rp.getMeals().get(position).getStrMeasure7());
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient8()+ ", " +rp.getMeals().get(position).getStrMeasure8());
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient9()+ ", " +rp.getMeals().get(position).getStrMeasure9());
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient10()+ ", " +rp.getMeals().get(position).getStrMeasure10());
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient11()+ ", " +rp.getMeals().get(position).getStrMeasure11());
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient12()+ ", " +rp.getMeals().get(position).getStrMeasure12());
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient13()+ ", " +rp.getMeals().get(position).getStrMeasure13());
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient14()+ ", " +rp.getMeals().get(position).getStrMeasure14());
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient15()+ ", " +rp.getMeals().get(position).getStrMeasure15());
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient16()+ ", " +rp.getMeals().get(position).getStrMeasure16());
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient17()+ ", " +rp.getMeals().get(position).getStrMeasure17());
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient18()+ ", " +rp.getMeals().get(position).getStrMeasure18());
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient19()+ ", " +rp.getMeals().get(position).getStrMeasure19());
        holder.strBuffer.append(rp.getMeals().get(position).getStrIngredient20()+ ", " +rp.getMeals().get(position).getStrMeasure20());

        holder.recipe_ingredients.setText(holder.strBuffer.toString());

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyRecyclerViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener//for custom adapter and extends that with recycleview,and implete to handle click
    {
         TextView recipe_titel,recipe_category,recipe_tag,recipie_area;
         TextView recipe_ingredients,recipie_description,recipie_video_link;
         ImageView recipe_image;
         StringBuffer strBuffer;

        public MyRecyclerViewAdapter(@NonNull View itemView,ItemClick itemClick)//for handle onclick
         {
            super(itemView);

            recipe_titel = itemView.findViewById(R.id.recipe_name);
            recipe_category= itemView.findViewById(R.id.recipe_category);
//            recipe_tag = itemView.findViewWithTag(R.id.recipe_tags);
            recipie_area = itemView.findViewById(R.id.recipe_area);
            recipe_ingredients = itemView.findViewById(R.id.recipe_ingredients);
            recipie_description=itemView.findViewById(R.id.recipe_descp);
            recipie_video_link = itemView.findViewById(R.id.recipe_video_link);
            recipe_image = itemView.findViewById(R.id.recipe_img);
            strBuffer = new StringBuffer();//to combain all ingrediants and mesurement into one
            recipie_video_link.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)//implemented method for onclick
          {
            itemClick.onItemClick(view,getAdapterPosition());//handel click on adapter

        }
    }

    public interface  ItemClick //handle itemclick
     {

        void onItemClick(View v, int pos);
    }
}
