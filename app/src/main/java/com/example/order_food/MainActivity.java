package com.example.order_food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.order_food.Fragment.CartFragment;
import com.example.order_food.Fragment.HistoryFragment;
import com.example.order_food.Fragment.HomeFragment;
import com.example.order_food.Fragment.ProfileFragment;
import com.example.order_food.Fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    CartFragment cartFragment;
    SearchFragment searchFragment;
    ProfileFragment profileFragment;
    HistoryFragment historyFragment;

    FragmentManager fragmentManager;

    FragmentTransaction frag_tran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = HomeFragment.newInstance(null,null);
        cartFragment = CartFragment.newInstance(null,null);
        searchFragment = SearchFragment.newInstance(null,null);
        historyFragment = HistoryFragment.newInstance(null,null);
        profileFragment = ProfileFragment.newInstance(null,null);

        fragmentManager = getSupportFragmentManager();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.home){
                    frag_tran = fragmentManager.beginTransaction();
                    frag_tran.replace(R.id.fragmentContainerView,homeFragment,"homeFragment");
                    frag_tran.commit();
                    return true;
                }
                else if(id == R.id.cart){
                    frag_tran = fragmentManager.beginTransaction();
                    frag_tran.replace(R.id.fragmentContainerView,cartFragment,"cartFragment");
                    frag_tran.commit();
                    return true;
                }
                else if(id == R.id.search){
                    frag_tran = fragmentManager.beginTransaction();
                    frag_tran.replace(R.id.fragmentContainerView,searchFragment,"searchFragment");
                    frag_tran.commit();
                    return true;
                }
                else if(id == R.id.history){
                    frag_tran = fragmentManager.beginTransaction();
                    frag_tran.replace(R.id.fragmentContainerView,historyFragment,"historyFragment");
                    frag_tran.commit();
                    return true;
                }
                else if(id == R.id.profile){
                    frag_tran = fragmentManager.beginTransaction();
                    frag_tran.replace(R.id.fragmentContainerView,profileFragment,"profileFragment");
                    frag_tran.commit();
                    return true;
                }
                return false;
            }
        });
    }
}