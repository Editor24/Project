package com.example.importui;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText user_name;
    EditText user_email;
    EditText user_password;
    EditText user_cpassword;
    Button btregistration;
    FirebaseAuth firebaseAuth;
    String email,password;
    TextView date1;
    DatePickerDialog.OnDateSetListener mdatesetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth=FirebaseAuth.getInstance();
        user_name=(EditText)findViewById(R.id.regname);
        user_email=(EditText)findViewById(R.id.regemail);
        user_password=(EditText)findViewById(R.id.logpass);
        user_cpassword=(EditText)findViewById(R.id.regcpassword);
        btregistration=(Button)findViewById(R.id.btreg);
        btregistration.setOnClickListener(this);
        date1 =(TextView) findViewById(R.id.tvdate);
        date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();


                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);

                DatePickerDialog dialog = new DatePickerDialog(     MainActivity.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,mdatesetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mdatesetListener =new DatePickerDialog.OnDateSetListener() {
            @Override

            public void onDateSet(DatePicker view, int day, int month, int year) {
                month =month+1;
                Log.d("Register","onDateSet:dd/mm/yy"+day+"/"+month+"/"+year);

                String date = year  +" / "+ month +" / "+day;
                date1.setText(date);
            }
        };
    }

    private void registeruser() {
        email=user_email.getText().toString();
    password=user_password.getText().toString();
    firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                   if(task.isSuccessful())
                   {
                       startActivity(new Intent(MainActivity.this,addcontact.class));
                       Toast.makeText(MainActivity.this, "Registration Succsesful", Toast.LENGTH_SHORT).show();
                   }
                   else
                   {
                       Toast.makeText(MainActivity.this, "Failed..Try Again Later..", Toast.LENGTH_SHORT).show();
                   }
                }
            });
    }


    @Override
    public void onClick(View v) {
        if(v==btregistration)
        {
            registeruser();
        }
    }
}
