package com.example.importui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class Login1Activity extends AppCompatActivity implements View.OnClickListener{
    public static final String EXTRA_TEXT ="com.example.importui.EXTRA_TEXT";
    EditText login_email;
    FirebaseAuth firebaseAuth;
    Button login_etop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activivty_login1);
        firebaseAuth=FirebaseAuth.getInstance();
        login_email=(EditText)findViewById(R.id.logemail);
        login_etop=(Button) findViewById(R.id.btnetop);
        login_etop.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v == login_etop)
        {
            String lg_email=login_email.getText().toString();
            Intent intent=new Intent(Login1Activity.this,Login2Activity.class);
            intent.putExtra(EXTRA_TEXT,lg_email);
            startActivity(intent);
        }
    }
}
