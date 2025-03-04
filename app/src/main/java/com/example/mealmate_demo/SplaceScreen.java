package com.example.mealmate_demo;

import static java.lang.Thread.sleep;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.imageview.ShapeableImageView;

import java.lang.annotation.Annotation;

public class SplaceScreen extends AppCompatActivity {

    private ShapeableImageView imageView;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splace_screen);

        imageView=findViewById(R.id.splaceImage);
        textView=findViewById(R.id.splaceText);

        Animation animation= AnimationUtils.loadAnimation(this,R.anim.animation);
        imageView.startAnimation(animation);
        textView.startAnimation(animation);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent=new Intent(getApplicationContext(),Login_Page.class);
                    startActivity(intent);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();

    }
}