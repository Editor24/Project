package com.example.importui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class addmorecontact extends AppCompatActivity {
    Button btnback,btndone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmorecontact);
        btnback = (Button) findViewById(R.id.btnback);
        btndone = (Button) findViewById(R.id.btndone);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(addmorecontact.this, MainActivity.class);
                startActivity(in);
            }
        });
        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(addmorecontact.this, addsymptoms.class);
                startActivity(in);
            }
        });
    }
}



