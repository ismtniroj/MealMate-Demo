package com.example.mealmate_demo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Add_Ingredient extends AppCompatActivity {

    ImageView imageView;
    EditText txt_name,txt_description,txt_price;
    Button addIngredientButton;


    private Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_ingredient);

        imageView=findViewById(R.id.ingredient_image);
        txt_name=findViewById(R.id.ingredient_name);
        txt_description=findViewById(R.id.ingredient_description);
        txt_price=findViewById(R.id.ingredient_price);
        addIngredientButton=findViewById(R.id.btn_submit);

        imageView.setOnClickListener(this::AddGroceryImage);
        addIngredientButton.setOnClickListener(this::AddGroceryButton);




    }

    private void AddGroceryButton(View view) {


    }

    private void AddGroceryImage(View view) {
        ImagePickerUtility.pickImage(view,Add_Ingredient.this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(data !=null){
           imageUri=data.getData();
           imageView.setImageURI(imageUri);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}