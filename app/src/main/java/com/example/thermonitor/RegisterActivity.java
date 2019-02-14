package com.example.thermonitor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
     private TextView s;
     private EditText f;
     private EditText u;
     private EditText p;
     private EditText c;
     private Button r;
     private TextView h;
     private Button l;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        s = findViewById(R.id.textView);
        f = findViewById(R.id.FullName);
        u = findViewById(R.id.username);
        p = findViewById(R.id.password);
        c = findViewById(R.id.ConfirmPassword);
        r = findViewById(R.id.register);
        h = findViewById(R.id.textView3);
        l = findViewById(R.id.login);

        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }
        private void registerUser(){

            //getting email and password from edit texts
            String email = u.getText().toString().trim();
            String password  = p.getText().toString().trim();

            //checking if email and passwords are empty
            if(TextUtils.isEmpty(email)){
                Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
                return;
            }

            if(TextUtils.isEmpty(password)){
                Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
                return;
            }

            //if the email and password are not empty
            //displaying a progress dialog

            //progressDialog.setMessage("Registering Please Wait...");
            //progressDialog.show();

            //creating a new user
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //checking if success
                            if(task.isSuccessful()){
                                //display some message here
                                Toast.makeText(RegisterActivity.this,"Successfully registered",Toast.LENGTH_LONG).show();
                            }else{
                                //display some message here
                                Toast.makeText(RegisterActivity.this,"Registration Error",Toast.LENGTH_LONG).show();
                            }
                           // progressDialog.dismiss();
                        }
                    });

        }







}


