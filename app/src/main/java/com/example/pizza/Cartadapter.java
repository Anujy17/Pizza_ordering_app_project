package com.example.pizza;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Cartadapter extends RecyclerView.Adapter<Cartadapter.CartViewHolder> {
    Context context;
    ArrayList<User> userArrayList;

    public Cartadapter(Context context, ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public Cartadapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new CartViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Cartadapter.CartViewHolder holder, int position) {
        User user = userArrayList.get(position);
        holder.name.setText(user.name);
        holder.price.setText(user.price);
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            price = itemView.findViewById(R.id.tv_price);
        }
    }


}
