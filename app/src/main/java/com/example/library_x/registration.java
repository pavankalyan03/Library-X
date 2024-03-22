package com.example.library_x;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class registration extends AppCompatActivity {


    Button register;
    String date;
    private FirebaseAuth auth;
    EditText fname,sname,dob,phoneno,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        auth = FirebaseAuth.getInstance();

        fname  = findViewById(R.id.regifullname);
        sname = findViewById(R.id.regisurname);
        dob = findViewById(R.id.regidob);
        phoneno = findViewById(R.id.regiphoneno);
        email = findViewById(R.id.regiemail);
        password = findViewById(R.id.regipassword);

        register = findViewById(R.id.regiregister);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialouge();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String afname = fname.getText().toString();
                String asname = sname.getText().toString();
                String aphoneno = phoneno.getText().toString();
                String aemail = email.getText().toString();
                String apassword = password.getText().toString();
                String adob = dob.getText().toString();



                int a=0;
                if(afname.length()!=0)
                {
                    a+=1;
                }
                else{
                    fname.setError("Invalid name");
                }

                if(asname.length()!=0)
                {
                    a+=1;
                }
                else{
                    sname.setError("Invalid name");
                }

                if(aphoneno.length()==10)
                {
                    a+=1;
                }
                else{
                    phoneno.setError("Invalid phone number");
                }


                if (aemail.length() == 0 || !aemail.contains("@")) {
                    email.setError("Enter valid email");
                } else if (ArrayListHolder.username.contains(aemail)) {
                    email.setError("username already taken");
                } else {
                    a+=1;
                }



                if(apassword.length()<6){
                    password.setError("password must be 6 characters");
                }
                else {
                    a+=1;
                }

                if (a==5)
                {
//                    ArrayListHolder.username.add(aemail);
//                    ArrayListHolder.fullname.add(afname);
//                    ArrayListHolder.surname.add(asname);
//                    ArrayListHolder.phoneno.add(aphoneno);
//                    ArrayListHolder.password.add(apassword);
//                    ArrayListHolder.dateofbirth.add(adob);

                    String books = " ";
                    HelperClass helperClass = new HelperClass(afname,aemail,apassword,books,adob);

                    FirebaseDatabase.getInstance().getReference().child("users").child("afname").setValue(helperClass);

                    Toast.makeText(registration.this, "Registration Is successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(registration.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        });
    }



    private void showDatePickerDialouge() {
        {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            // Create a new DatePickerDialog
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            // Handle the selected date
                            date = dayOfMonth + " - " + (monthOfYear + 1) + " - " + year;
                            dob.setText(date);
                        }
                    },
                    year, month, day);

            // Show the DatePickerDialog
            datePickerDialog.show();


        }
    }


}