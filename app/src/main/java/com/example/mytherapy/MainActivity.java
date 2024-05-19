package com.example.mytherapy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.mytherapy.databinding.ActivityMainBinding;
import com.example.mytherapy.ui.dashboard.DashboardFragment;
import com.example.mytherapy.ui.main.MainFragment;
import com.example.mytherapy.ui.main.time.TimeItem;
import com.example.mytherapy.ui.profile.ProfileFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    public static ArrayList<TimeItem> timeItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new MainFragment());

        binding.bottomNavView.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.navigation_home:
                    replaceFragment(new MainFragment());
                    break;
                case R.id.navigation_profile:
                    replaceFragment(new ProfileFragment());
                    break;
                case R.id.navigation_dashboard:
                    replaceFragment(new DashboardFragment());
                    break;
            }
            return true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout,fragment);
        fragmentTransaction.commit();
    }
}