package com.example.pizza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class feedbackActivity extends AppCompatActivity {
    EditText content;
    TextView home;
    Button sub;
    String a;
    FirebaseAuth mAuth;
    String userID;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_feedback);
        progressDialog = new ProgressDialog(this);
        content = (EditText) findViewById(R.id.feed);
        sub = findViewById(R.id.submit);
        a = null;
        a = content.getText().toString();
        mAuth = FirebaseAuth.getInstance();
        userID = mAuth.getCurrentUser().getUid();
        home = findViewById(R.id.home_page);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(feedbackActivity.this, HomeActivity.class);
                startActivity(in);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (a != "") {

                    progressDialog.setCancelable(false);
                    progressDialog.setMessage("Storing response...");
                    progressDialog.show();
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("content", content.getText().toString());

                    FirebaseFirestore.getInstance().collection("feedback")
                            .document(userID).collection("users").add(hashMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            if (progressDialog.isShowing())
                                progressDialog.dismiss();
                            Toast.makeText(feedbackActivity.this, "Response got successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(feedbackActivity.this, HomeActivity.class);
                            startActivity(intent);
                        }
                    });
                } else {
                    content.setError("enter the feedback");
                    content.requestFocus();
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                }


            }
        });
    }
}