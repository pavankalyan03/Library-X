package com.example.library_x;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    Button mlogin,mregister;
    EditText memail,mpassword;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //user 1
        ArrayListHolder.username.add("mahendra@gmail.com");
        ArrayListHolder.password.add("mahendra");
        ArrayListHolder.fullname.add("mahendra");
        ArrayListHolder.surname.add("vangara");
        ArrayListHolder.dateofbirth.add("23-06-2004");
        ArrayListHolder.phoneno.add("7396362838");

        //user 2
        ArrayListHolder.username.add("sample@gmail.com");
        ArrayListHolder.password.add("sample");
        ArrayListHolder.fullname.add("sample");
        ArrayListHolder.surname.add("sample");
        ArrayListHolder.dateofbirth.add("13-06-2005");
        ArrayListHolder.phoneno.add("9876362838");

        //user 3
        ArrayListHolder.username.add("yaswanth@gmail.com");
        ArrayListHolder.password.add("yaswanth123");
        ArrayListHolder.fullname.add("yaswanth");
        ArrayListHolder.surname.add("pulugu");
        ArrayListHolder.dateofbirth.add("12-02-2004");
        ArrayListHolder.phoneno.add("7398973482");

        //user 4
        ArrayListHolder.username.add("pavan@gmail.com");
        ArrayListHolder.password.add("pavan234");
        ArrayListHolder.fullname.add("pavan kumar");
        ArrayListHolder.surname.add("s1");
        ArrayListHolder.dateofbirth.add("23-06-2004");
        ArrayListHolder.phoneno.add("7396362838");

        //user 5
        ArrayListHolder.username.add("manikanta@gmail.com");
        ArrayListHolder.password.add("manikanta@12");
        ArrayListHolder.fullname.add("manikanta");
        ArrayListHolder.surname.add("athuluri");
        ArrayListHolder.dateofbirth.add("17-06-2003");
        ArrayListHolder.phoneno.add("7396368765");

        //user 6
        ArrayListHolder.username.add("omkar@gmail.com");
        ArrayListHolder.password.add("omkar@143");
        ArrayListHolder.fullname.add("omkar");
        ArrayListHolder.surname.add("peta");
        ArrayListHolder.dateofbirth.add("24-02-2002");
        ArrayListHolder.phoneno.add("8765492838");

        //user 7
        ArrayListHolder.username.add("baji@gmail.com");
        ArrayListHolder.password.add("baji123!");
        ArrayListHolder.fullname.add("baji");
        ArrayListHolder.surname.add("shaik");
        ArrayListHolder.dateofbirth.add("15-11-2003");
        ArrayListHolder.phoneno.add("8965683586");

        //user 8
        ArrayListHolder.username.add("211FA18046@gmail.com");
        ArrayListHolder.password.add("adithya46");
        ArrayListHolder.fullname.add("adithya");
        ArrayListHolder.surname.add("jagrutha");
        ArrayListHolder.dateofbirth.add("14-03-2003");
        ArrayListHolder.phoneno.add("8654262838");

        //user 9
        ArrayListHolder.username.add("vamsikrishna@gmail.com");
        ArrayListHolder.password.add("vamsi18");
        ArrayListHolder.fullname.add("vamsi");
        ArrayListHolder.surname.add("siddamsetti");
        ArrayListHolder.dateofbirth.add("29-02-2004");
        ArrayListHolder.phoneno.add("7856284637");

        //user 10
        ArrayListHolder.username.add("koti@gmail.com");
        ArrayListHolder.password.add("koti@12345");
        ArrayListHolder.fullname.add("koti");
        ArrayListHolder.surname.add("koti");
        ArrayListHolder.dateofbirth.add("12-09-2003");
        ArrayListHolder.phoneno.add("1029384756");


        mlogin = findViewById(R.id.mainlogin);
        mregister = findViewById(R.id.loginregister);
        memail = findViewById(R.id.mainemail);
        mpassword = findViewById(R.id.mainpassword);

        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputlogin = memail.getText().toString();
                String inputpassword = mpassword.getText().toString();

                int index = ArrayListHolder.username.indexOf(inputlogin);
                if (index == -1)
                {
                    memail.setError("Invalid username");
                }
                else
                {
                    if (!inputpassword.equals(ArrayListHolder.password.get(index))) {
                        mpassword.setError("Wrong password");
                    }
                    else
                    {
                        // Password is correct, proceed with login
                        // You can add your logic here, such as starting a new activity
                        ArrayListHolder.current=inputlogin;
                        Toast.makeText(MainActivity.this,"Login Sucessful",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this,navigation.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });

        mregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,registration.class);
                startActivity(intent);

            }
        });

    }
}