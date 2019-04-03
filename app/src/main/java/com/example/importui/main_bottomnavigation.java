package com.example.importui;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class main_bottomnavigation extends AppCompatActivity {
    BottomNavigationView btm_navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bottomnavigation);
        btm_navigation=findViewById(R.id.btm_items);
        btm_navigation.setSelectedItemId(R.id.nav_home);
        btm_navigation.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.btm_container,new homefragment()).commit();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()) {
                case R.id.nav_home:
                    selectedFragment= new homefragment();
                    break;


                case R.id.nav_rssfeed:
                    selectedFragment = new rssfeedfragment();
                    break;


                case R.id.nav_sos:
                    selectedFragment= new sosfragment();
                    break;

                case R.id.nav_chat:
                    selectedFragment= new chatfragment();
                    break;


                case R.id.nav_setting:
                    selectedFragment = new settingfragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.btm_container, selectedFragment).commit();
            return true;
        }

    };
}
