package com.example.pizza;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link nonveg_fregment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class nonveg_fregment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FirebaseUser mUser;
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    String userID, userID_fav;
    FirebaseFirestore db;

    public nonveg_fregment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment nonveg_fregment.
     */
    // TODO: Rename and change types and number of parameters
    public static nonveg_fregment newInstance(String param1, String param2) {
        nonveg_fregment fragment = new nonveg_fregment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_nonveg_fregment, container, false);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        Button pepper_cart = v.findViewById(R.id.pepper_cart);
        Button pepper_fav = v.findViewById(R.id.pepper_favourite);
        Button delight_cart = v.findViewById(R.id.delight_cart);
        Button delight_fav = v.findViewById(R.id.delux_favourite);
        progressDialog = new ProgressDialog(getActivity());
        Button supreme_cart = v.findViewById(R.id.supreme_cart);
        Button supreme_fav = v.findViewById(R.id.supreme_favourite);
        Button dominator_cart = v.findViewById(R.id.dominator_cart);
        Button dominator_fav = v.findViewById(R.id.digital_favourite);
        TextView pepper = v.findViewById(R.id.pepper);
        TextView pepper_p = v.findViewById(R.id.pepper_cart);
        TextView delight = v.findViewById(R.id.maxican);
        TextView delight_p = v.findViewById(R.id.delight_price);
        TextView supreme = v.findViewById(R.id.supreme);
        TextView supreme_p = v.findViewById(R.id.supreme_price);
        TextView dominator = v.findViewById(R.id.dominator);
        TextView dominator_p = v.findViewById(R.id.dominator_price);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        mUser = mAuth.getCurrentUser();
        userID = mUser.getEmail().toString() + "_cart";
        userID_fav = mUser.getEmail().toString() + "_fav";
        pepper_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Adding to cart...");
                progressDialog.show();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", pepper.getText().toString());
                hashMap.put("price", pepper_p.getText().toString());
                FirebaseFirestore.getInstance().collection(userID)
                        .add(hashMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        progressDialog.dismiss();
                        Toast.makeText(getActivity(), "Added to cart", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
        delight_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Adding to cart...");
                progressDialog.show();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", delight.getText().toString());
                hashMap.put("price", delight_p.getText().toString());
                FirebaseFirestore.getInstance().collection(userID)
                        .add(hashMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        progressDialog.dismiss();
                        Toast.makeText(getActivity(), "Added to cart", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
        supreme_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Adding to cart...");
                progressDialog.show();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", supreme.getText().toString());
                hashMap.put("price", supreme_p.getText().toString());
                FirebaseFirestore.getInstance().collection(userID)
                        .add(hashMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        progressDialog.dismiss();
                        Toast.makeText(getActivity(), "Added to cart", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
        dominator_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Adding to cart...");
                progressDialog.show();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", dominator.getText().toString());
                hashMap.put("price", dominator_p.getText().toString());
                FirebaseFirestore.getInstance().collection(userID)
                        .add(hashMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        progressDialog.dismiss();
                        Toast.makeText(getActivity(), "Added to cart", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        pepper_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Adding to favourites...");
                progressDialog.show();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", pepper.getText().toString());
                hashMap.put("price", pepper_p.getText().toString());
                FirebaseFirestore.getInstance().collection(userID_fav)
                        .add(hashMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        progressDialog.dismiss();
                        Toast.makeText(getActivity(), "Added to favourites", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
        supreme_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Adding to favourites...");
                progressDialog.show();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", supreme.getText().toString());
                hashMap.put("price", supreme_p.getText().toString());
                FirebaseFirestore.getInstance().collection(userID_fav)
                        .add(hashMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        progressDialog.dismiss();
                        Toast.makeText(getActivity(), "Added to favourites", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });


        return v;
    }
}