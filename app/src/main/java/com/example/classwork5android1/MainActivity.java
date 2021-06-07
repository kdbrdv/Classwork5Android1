package com.example.classwork5android1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import com.example.classwork5android1.databinding.ActivityMainBinding;
import com.example.classwork5android1.fragments.DashFragment;
import com.example.classwork5android1.fragments.HomeFragment;
import com.example.classwork5android1.fragments.NotificationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private HomeFragment homeFragment = new HomeFragment();
    private DashFragment dashFragment = new DashFragment();
    private NotificationFragment notificationFragment = new NotificationFragment();

    private FragmentManager fm = getSupportFragmentManager();
    Fragment active = homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        binding.bottomNav.setOnNavigationItemSelectedListener(listener);
        fm.beginTransaction().add(R.id.fm_container, notificationFragment, "notif").hide(notificationFragment).commit();
        fm.beginTransaction().add(R.id.fm_container, dashFragment, "Dash").hide(dashFragment).commit();
        fm.beginTransaction().add(R.id.fm_container, homeFragment, "Home").commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            item -> {
                switch (item.getItemId()) {
                    case R.id.home_fragment:
                        // Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        fm.beginTransaction().setCustomAnimations(R.anim.fade_out, R.anim.slide_in)
                                .hide(active).show(homeFragment).commit();
                        active = homeFragment;
                        return true;
                    case R.id.dashboard_fragment:
                        //Toast.makeText(MainActivity.this, "Dashboard", Toast.LENGTH_SHORT).show();
                        fm.beginTransaction().hide(active).show(dashFragment).commit();
                        active = dashFragment;
                        return true;
                    case R.id.notification_fragment:
                        //Toast.makeText(MainActivity.this, "Notification", Toast.LENGTH_SHORT).show();
                        fm.beginTransaction().setCustomAnimations(R.anim.fade_out, R.anim.slide_in).
                                hide(active).show(notificationFragment).commit();
                        active = notificationFragment;
                        return true;
                }
                return false;
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }

    public void hideBottomNavigation() {
        binding.bottomNav.setVisibility(View.GONE);
    }

    public void showBottomNavigation() {
        binding.bottomNav.setVisibility(View.VISIBLE);
    }

    public void hideToolbar() {
        binding.toolbar.setVisibility(View.GONE);
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}