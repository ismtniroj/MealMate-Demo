package com.example.mealmate_demo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Add_Recipe extends AppCompatActivity {


    ImageView imageView;
     EditText txt_name,txt_description;
     Button addRecipeButton;
     Spinner week_dropdown,ingredients_dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_recipe);


        imageView=findViewById(R.id.recipe_image);
        txt_name=findViewById(R.id.recipe_name);
        txt_description=findViewById(R.id.recipe_description);
        addRecipeButton=findViewById(R.id.btn_submit);
        week_dropdown=findViewById(R.id.spinner_week);
        ingredients_dropdown=findViewById(R.id.spinner_ingredients);



    }
}