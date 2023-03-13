package com.example.pizza;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class cartActivity extends AppCompatActivity {
    Button buy,browse;
    FirebaseUser mUser;
    RecyclerView recyclerView;
    ArrayList<User> userArrayList;
    Cartadapter cartadapter;
    FirebaseFirestore db;
    FirebaseAuth mAuth;
    String userID;
    LinearLayout li;
    RelativeLayout re;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_cart);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching data...");
        progressDialog.show();
        re= findViewById(R.id.relative);
        browse = findViewById(R.id.button);
        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(cartActivity.this,MenuActivity.class);
                startActivity(in);
            }
        });
        buy = findViewById(R.id.buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cartActivity.this,
                        DetailsActivity.class);
                startActivity(intent);
            }
        });
        li = findViewById(R.id.linear);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        userID = mAuth.getCurrentUser().getEmail() + "_cart";
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db = FirebaseFirestore.getInstance();
        userArrayList = new ArrayList<User>();
        cartadapter = new Cartadapter(cartActivity.this, userArrayList);
        recyclerView.setAdapter(cartadapter);
        EventChangListener();


    }

    private void EventChangListener() {
        db.collection(userID).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if(task.isSuccessful()){
                    int count =0;
                    for(DocumentSnapshot document : task.getResult()){
                        count++;
                    }
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                    if(count==0){
                        li.setVisibility(View.VISIBLE);
                        re.setVisibility(View.INVISIBLE);
                    }
                    else{
                        li.setVisibility(View.INVISIBLE);
                        re.setVisibility(View.VISIBLE);
                    }

                }
            }
        });
        db.collection(userID).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                    Log.e("Database error", error.getMessage());
                    return;
                }
                for (DocumentChange dc : value.getDocumentChanges()) {
                    if (dc.getType() == DocumentChange.Type.ADDED) {
                        final boolean add = userArrayList.add(dc.getDocument().toObject(User.class));
                    }
                    cartadapter.notifyDataSetChanged();
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                }

            }
        });

    }
}