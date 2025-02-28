package com.example.mealmate_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgot_Password_Page extends AppCompatActivity {
    EditText email;
    Button btnlogin;

    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_password_page);

        email=findViewById(R.id.txt_email);
        btnlogin=findViewById(R.id.login_btn);

        auth = FirebaseAuth.getInstance();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString().trim();
                if (Email.isEmpty()) {
                    Toast.makeText(Forgot_Password_Page.this, "Enter Email", Toast.LENGTH_SHORT).show();
                } else {
                    auth.sendPasswordResetEmail(Email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(Forgot_Password_Page.this, MainActivity.class);
                                startActivity(intent);
                                Toast.makeText(Forgot_Password_Page.this, "Password reset email sent!", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(Forgot_Password_Page.this, "Failed to send email!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}