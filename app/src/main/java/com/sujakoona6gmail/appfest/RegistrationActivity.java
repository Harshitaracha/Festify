package com.sujakoona6gmail.appfest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {



    ProgressBar progressBar;
        EditText editTextEmail, editTextPassword;

        private FirebaseAuth mAuth;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registration);

            editTextEmail = (EditText) findViewById(R.id.editTextemail);
            editTextPassword = (EditText) findViewById(R.id.editTextPassword);
            progressBar = (ProgressBar) findViewById(R.id.progressbar);

            mAuth = FirebaseAuth.getInstance();

            findViewById(R.id.buttonRegister).setOnClickListener(this);
            findViewById(R.id.textviewsignin).setOnClickListener(this);
        }

    private void registerUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Please enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError("Minimum lenght of password should be 6");
            editTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    finish();
                    Toast.makeText(getApplicationContext(), "Successfully registered", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                } else {

                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(getApplicationContext(), "You are already registered", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonRegister:
                registerUser();
                break;

            case R.id.textviewsignin:
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}


       /*** progressdialog=new ProgressDialog(this);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        editTextemail = (EditText) findViewById(R.id.editTextemail);
        editTextpassword = (EditText) findViewById(R.id.editTextPassword);
        textViewsignin = (TextView) findViewById(R.id.textviewsignin);
        buttonRegister.setOnClickListener(this);
        textViewsignin.setOnClickListener(this);
        firebaseauth=FirebaseAuth.getInstance();
        if(firebaseauth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }}

    private void registerUser(){
        String email=editTextemail.getText().toString().trim();
        String password=editTextpassword.getText().toString().trim();
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this,"Enter your email",Toast.LENGTH_SHORT).show();
            //stop the function exectution
            return;
        }
        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"Enter your password",Toast.LENGTH_SHORT).show();
            //stop the function exectution
            return;
        }

        //if validation is ok
        progressdialog.setMessage("You are registering, Please wait");
        progressdialog.show();
        firebaseauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressdialog.dismiss();
                        if(task.isSuccessful()){
                            //user is successfully registered.
                            //v will start the profile activity
                            Toast.makeText(RegistrationActivity.this,"Registered Successfully",Toast.LENGTH_SHORT).show();

                            finish();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }
                        else{
                            Toast.makeText(RegistrationActivity.this," Not Registered Successfully",Toast.LENGTH_SHORT).show();

                        }

                    }
                }
        );
    }


    @Override
    public void onClick(View view) {
        if (view == buttonRegister) {
            registerUser();
        }
        if (view == textViewsignin) {
            //we will open the login activity
            startActivity(new Intent(this,LoginActivity.class));
        }
    }

    }}

*/