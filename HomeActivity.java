package com.example.apple.loginwithsql;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUpToolbar();
        navigationView = findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener
                (new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        //Toast.makeText(HomeActivity.this, "Clicked Home", Toast.LENGTH_SHORT).show();
                        Intent moveToHome = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(moveToHome);
                        break;

                    case R.id.nav_classes:
                        Toast.makeText(HomeActivity.this, "Clicked Classes", Toast.LENGTH_SHORT).show();
                        Intent moveToClass = new Intent(getApplicationContext(), ClassActivity.class);
                        startActivity(moveToClass);
                        break;

                    case R.id.nav_logOut:
                        Intent moveToFirstPage = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(moveToFirstPage);
                        break;
                }
                return false;
            }
        });
    }

    private void setUpToolbar()
    {
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                 R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle );
        actionBarDrawerToggle.syncState();
    }


}