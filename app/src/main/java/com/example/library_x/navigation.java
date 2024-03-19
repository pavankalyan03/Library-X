package com.example.library_x;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class navigation extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;


    homefragment homefragment = new homefragment();
    profilefragment profilefragment = new profilefragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        bottomNavigationView = findViewById(R.id.botton);

        getSupportFragmentManager().beginTransaction().replace(R.id.mainpage,profilefragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {

                int itemid = item.getItemId();

                if(itemid == R.id.home)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainpage,homefragment).commit();
                }
                if(itemid == R.id.info)
                {
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainpage,profilefragment).commit();
                }

                if(itemid == R.id.signout)
                {
                    ArrayListHolder.current=" ";
                    Intent intent = new Intent(navigation.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                return false;
            }
        });

    }
}