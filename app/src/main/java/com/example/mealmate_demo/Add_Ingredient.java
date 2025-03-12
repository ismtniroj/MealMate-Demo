package com.example.mealmate_demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mealmate_demo.Adapter.Grocery_Database_Helper;


public class Add_Ingredient extends AppCompatActivity {

    private ImageView imageView;
    private EditText txt_name,txt_description,txt_price;
    private Button addIngredientButton;
    Grocery_Database_Helper groceryDatabaseHelper;
    private Uri imageUri;

    public static Intent getIntent(Context context) {
        return new Intent(context, Add_Ingredient.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_ingredient);

        imageUri = Uri.EMPTY;

        groceryDatabaseHelper = new Grocery_Database_Helper(this);

        imageView=findViewById(R.id.ingredient_image);
        txt_name=findViewById(R.id.ingredient_name);
        txt_description=findViewById(R.id.ingredient_description);
        txt_price=findViewById(R.id.ingredient_price);
        addIngredientButton=findViewById(R.id.btn_submit);

        imageView.setOnClickListener(this::AddGroceryImage);
        addIngredientButton.setOnClickListener(this::AddGroceryButton);




    }

    private void AddGroceryButton(View view) {
        String name = txt_name.getText().toString();
        if (name.isEmpty()) {
            txt_name.setError("Name field is empty");
            txt_name.requestFocus();
        }
        double price = 0;

        try {
            price = Double.parseDouble(txt_price.getText().toString());
        } catch (NullPointerException e) {
            Toast.makeText(
                    getApplicationContext(),
                    "Something wrong with price.",
                    Toast.LENGTH_SHORT
            ).show();
        } catch (NumberFormatException e) {
            Toast.makeText(
                    getApplicationContext(),
                    "Price should be a number",
                    Toast.LENGTH_SHORT
            ).show();
        }
        if (price <= 0) {
            txt_price.setError("Price should be greater than 0.");
            txt_price.requestFocus();
        }
        String description = txt_description.getText().toString();
        if(description.isEmpty()) {
            txt_description.setError("Description is empty.");
            txt_description.requestFocus();
        }

        if (groceryDatabaseHelper.insert(name, price, description, imageUri.toString(), false)) {
            Toast.makeText(getApplicationContext(), "Saved Successfully",
                    Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Failed to save", Toast.LENGTH_SHORT).show();
        }
    }

    +

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