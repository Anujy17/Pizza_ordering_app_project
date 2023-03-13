package com.example.pizza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class forgetActivity extends AppCompatActivity {

    TextView login;
    Button for_g;
    EditText forget_email;
    String email;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_forget);
        auth = FirebaseAuth.getInstance();
        login = findViewById(R.id.forget);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(forgetActivity.this, LoginActivity.class);
                startActivity(in);
            }
        });
        for_g = findViewById(R.id.forgb);
        forget_email = findViewById(R.id.email_f);


        for_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate_data();
            }
        });

    }

    private void validate_data() {
        email = forget_email.getText().toString();
        if (email.isEmpty()) {
            forget_email.setError("Please enter email");
        } else {
            forget_pass();
        }
    }

    private void forget_pass() {


        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(forgetActivity.this, "Please check your mail", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(forgetActivity.this, "error " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }

                    }
                });
    }
}