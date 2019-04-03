package com.example.importui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class update_user_profile extends AppCompatActivity {

    Button btup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_profile);
        btup=(Button)findViewById(R.id.btup);
        btup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(update_user_profile.this,user_profile.class);
                startActivity(i);
            }
        });
    }
}
