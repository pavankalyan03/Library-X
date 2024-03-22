package com.example.library_x;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class navigation extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
    String navuser, navemail, navpass, navdob, navname;


    homefragment homefragment = new homefragment();
    profilefragment profilefragment = new profilefragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        bottomNavigationView = findViewById(R.id.botton);

        Intent i = getIntent();

        navuser = i.getStringExtra("username");
        navemail = i.getStringExtra("email");
        navpass = i.getStringExtra("password");
        navdob = i.getStringExtra("dob");
        navname = i.getStringExtra("name");

        profilefragment ldf = new profilefragment();

        Bundle bundle = new Bundle();
        bundle.putString("username", navuser);
        bundle.putString("email", navemail);
        bundle.putString("password", navpass);
        bundle.putString("dob", navdob);
        bundle.putString("name", navname);

        ldf.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.mainpage, ldf).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                int itemid = item.getItemId();

                if (itemid == R.id.home) {
                    homefragment hf = new homefragment();
                    Bundle bund = new Bundle();
                    bund.putString("username", navuser);
                    hf.setArguments(bund);
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainpage, hf).commit();
                }
                if (itemid == R.id.info) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.mainpage, profilefragment).commit();
                }

                if (itemid == R.id.signout) {
                    ArrayListHolder.current = " ";
                    Intent intent = new Intent(navigation.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                return false;
            }
        });

    }
}