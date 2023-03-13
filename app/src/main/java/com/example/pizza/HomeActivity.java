package com.example.pizza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {
    MeowBottomNavigation navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        navigation = findViewById(R.id.navigation);
        navigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_baseline_home_24));
        navigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_baseline_favorite_24));
        navigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_menu_book_24));
        navigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_baseline_account_circle_24));

        navigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;
                switch (item.getId()) {
                    case 1:
                        fragment = new Home();
                        break;
                    case 2:
                        fragment = new favourites();
                        break;
                    case 3:
                        fragment = new menu();
                        break;
                    case 4:
                        fragment = new Account();
                        break;

                }
                loadFragment(fragment);
            }
        });

        navigation.show(1, true);
        navigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

            }
        });
        navigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

            }
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }

}