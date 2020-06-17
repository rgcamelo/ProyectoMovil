package com.example.proyecto.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.proyecto.R;
import com.example.proyecto.Controller.fragments.HomeFragment;
import com.example.proyecto.Controller.fragments.MapFragment;
import com.example.proyecto.Controller.fragments.ProfileFragment;
import com.example.proyecto.Controller.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ContainerActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        showSelectedFragment( new HomeFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.nav_search:
                        selectedFragment = new SearchFragment();
                        break;
                    case R.id.nav_map:
                        selectedFragment = new MapFragment();
                        break;
                }
                showSelectedFragment(selectedFragment);
                return true;
            }
        });
    }

    private void showSelectedFragment( Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_navigation,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
