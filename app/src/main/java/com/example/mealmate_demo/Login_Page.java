package com.example.mealmate_demo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Page extends AppCompatActivity {

    EditText email, password;
    Button btnlogin;
    TextView register_txt;

    FirebaseAuth auth;

//    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);

        email = findViewById(R.id.txt_email);
        password = findViewById(R.id.txt_password);
        btnlogin = findViewById(R.id.login_btn);
        register_txt = findViewById(R.id.txt_login);

        auth = FirebaseAuth.getInstance();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();
                if (Email.isEmpty()) {
                    Toast.makeText(Login_Page.this, "Enter Email", Toast.LENGTH_SHORT).show();
                }
                if (Password.isEmpty()) {
                    Toast.makeText(Login_Page.this, "Enter Password", Toast.LENGTH_SHORT).show();
                } else {
                    auth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(Login_Page.this, MainActivity.class);
                                startActivity(intent);
                                Toast.makeText(Login_Page.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(Login_Page.this, "Something Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}