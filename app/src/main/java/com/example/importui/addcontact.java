package com.example.importui;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addcontact extends AppCompatActivity {
    EditText temp;
    Button more;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontact);

        more = (Button) findViewById( R.id.btnmore);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(addcontact.this,addmorecontact.class);
                startActivity(in);
            }
        });

    }

    public void register(View view) {
        Intent in = new Intent(this,addsymptoms.class);
        startActivity(in);
    }
}

