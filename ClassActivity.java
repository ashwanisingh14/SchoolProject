package com.example.apple.loginwithsql;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class ClassActivity extends AppCompatActivity {

    GridLayout mainGrid;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        setUpToolBar();
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
                                Toast.makeText(ClassActivity.this, "Clicked Classes", Toast.LENGTH_SHORT).show();
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

        mainGrid = findViewById(R.id.mainGrid);


        //set event
        setSingleEvent(mainGrid);
       // setToggleEvent(mainGrid);

    }

    private void setUpToolBar() {

        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle );
        actionBarDrawerToggle.syncState();
    }

    /*private void setToggleEvent(GridLayout mainGrid) {

        for(int i = 0; i < mainGrid.getChildCount();i++){

           final CardView cardView=(CardView)mainGrid.getChildAt(i);
            final int finalI= i;
            cardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {

                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(ClassActivity.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(ClassActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }*/


    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(ClassActivity.this,ActivityOne.class);
                    intent.putExtra("info","This is activity from card item index  "+finalI);
                    startActivity(intent);

                }
            });
        }
    }
}
