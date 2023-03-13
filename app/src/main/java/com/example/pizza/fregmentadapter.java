package com.example.pizza;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class fregmentadapter extends FragmentStateAdapter {
    public fregmentadapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {

            case 1:
                return new nonveg_fregment();
            case 2:
                return new burger_fregment();
            case 3:
                return new fries_fregment();
            case 4:
                return new drinks_fragment();
            case 5:
                return new dessert_fragment();
        }
        return new veg_fregment();
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
