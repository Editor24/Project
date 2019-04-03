package com.example.importui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class user_account extends AppCompatActivity {
    Button btaddep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        btaddep=(Button)findViewById(R.id.btaddep);
        btaddep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(user_account.this,main_bottomnavigation.class);
                startActivity(i);
            }
        });
    }
}