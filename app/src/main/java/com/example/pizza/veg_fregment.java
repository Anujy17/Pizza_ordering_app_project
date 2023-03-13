package com.example.pizza;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link veg_fregment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class veg_fregment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    FirebaseUser mUser;
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    String userID, userId_fav;
    FirebaseFirestore db;
    private String mParam2;


    public veg_fregment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment veg_fregment.
     */
    // TODO: Rename and change types and number of parameters
    public static veg_fregment newInstance(String param1, String param2) {
        veg_fregment fragment = new veg_fregment();
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
        View v = inflater.inflate(R.layout.fragment_veg_fregment, container, false);
        mAuth = FirebaseAuth.getInstance();
        Button peppy_cart = v.findViewById(R.id.peppy_cart);

        Button peppy_fav = v.findViewById(R.id.peppy_favourite);
        Button maxican_cart = v.findViewById(R.id.maxican_cart);
        Button maxican_fav = v.findViewById(R.id.maxican_favourite);
        Button delux_cart = v.findViewById(R.id.delux_cart);
        Button delux_fav = v.findViewById(R.id.delux_favourite);
        Button digital_cart = v.findViewById(R.id.digital_cart);
        Button digital_fav = v.findViewById(R.id.digital_favourite);
        TextView peppy = v.findViewById(R.id.peppy);
        TextView peppy_p = v.findViewById(R.id.peppy_price);
        TextView maxican = v.findViewById(R.id.maxican);
        TextView maxican_p = v.findViewById(R.id.maxican_price);
        TextView delux = v.findViewById(R.id.delux);
        TextView delux_p = v.findViewById(R.id.delux_price);
        TextView digital = v.findViewById(R.id.digital);
        TextView digital_p = v.findViewById(R.id.digital_price);
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(getActivity());
        mUser = mAuth.getCurrentUser();
        userID = mUser.getEmail().toString() + "_cart";
        userId_fav = mUser.getEmail().toString() + "_fav";


        peppy_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Adding to cart...");
                progressDialog.show();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", peppy.getText().toString());
                hashMap.put("price", peppy_p.getText().toString());
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
        digital_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Adding to cart...");
                progressDialog.show();

                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", digital.getText().toString());
                hashMap.put("price", digital_p.getText().toString());
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
        maxican_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Adding to cart...");
                progressDialog.show();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", maxican.getText().toString());
                hashMap.put("price", maxican_p.getText().toString());
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
        delux_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Adding to cart...");
                progressDialog.show();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", delux.getText().toString());
                hashMap.put("price", delux_p.getText().toString());
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
        peppy_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Adding to favourites...");
                progressDialog.show();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", peppy.getText().toString());
                hashMap.put("price", peppy_p.getText().toString().trim());
                FirebaseFirestore.getInstance().collection(userId_fav)
                        .add(hashMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        progressDialog.dismiss();
                        Toast.makeText(getActivity(), "Added to Favourite", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
        digital_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Adding to favourites...");
                progressDialog.show();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", digital.getText().toString());
                hashMap.put("price", digital_p.getText().toString().trim());
                FirebaseFirestore.getInstance().collection(userId_fav)
                        .add(hashMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        progressDialog.dismiss();
                        Toast.makeText(getActivity(), "Added to favourite", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
        maxican_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Adding to favourites...");
                progressDialog.show();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", maxican.getText().toString().trim());
                hashMap.put("price", maxican_p.getText().toString().trim());
                FirebaseFirestore.getInstance().collection(userId_fav)
                        .add(hashMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        progressDialog.dismiss();
                        Toast.makeText(getActivity(), "Added to favourite", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
        delux_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Adding to favourites...");
                progressDialog.show();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", delux.getText().toString().trim());
                hashMap.put("price", delux_p.getText().toString().trim());
                FirebaseFirestore.getInstance().collection(userId_fav)
                        .add(hashMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        progressDialog.dismiss();
                        Toast.makeText(getActivity(), "Added to favourite", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });


        return v;
    }


}