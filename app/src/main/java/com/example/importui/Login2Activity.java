package com.example.importui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login2Activity extends AppCompatActivity implements View.OnClickListener {
    FirebaseAuth firebaseAuth;
    EditText login_password;
    Button btn_login;
    EditText eid;
    String emailid,password,ea,pa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        Intent intent=getIntent();
        emailid=intent.getStringExtra(Login1Activity.EXTRA_TEXT);
        //eid.setText(emailid);
        firebaseAuth=FirebaseAuth.getInstance();
        login_password=(EditText)findViewById(R.id.logpass);
        btn_login=(Button)findViewById(R.id.btlogin);
        btn_login.setOnClickListener(this);

        }

    @Override
    public void onClick(View v) {
        if(v==btn_login)
        {
            password=login_password.getText().toString();
            loginuser();
        }
    }
    private void loginuser() {

        //String email=emailid.toString().trim();
        ea=emailid;
        pa=password;
        firebaseAuth.signInWithEmailAndPassword(ea,pa)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Login2Activity.this, "Login Succsesful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Login2Activity.this,addcontact.class));
                        }
                        else
                        {
                            Toast.makeText(Login2Activity.this, "Check email or password", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Login2Activity.this,MainActivity.class));
                        }
                    }
                });
    }

}
