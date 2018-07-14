package com.example.android.ieye;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText txtEmailLogin;
    private EditText txtPasswordLogin;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtEmailLogin=(EditText) findViewById(R.id.txtEmailLogin);
        txtPasswordLogin=(EditText) findViewById(R.id.txtPasswordLogin);
        firebaseAuth=FirebaseAuth.getInstance();


    }






    public void btnLogin_click(View v)
    {

        final ProgressDialog progressDialog=ProgressDialog.show(LoginActivity.this,"Please Wait...","Processing...",true);
        (firebaseAuth.signInWithEmailAndPassword(txtEmailLogin.getText().toString(),txtPasswordLogin.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        Intent i1=getIntent();
                        String name=i1.getStringExtra("Name");
                        progressDialog.dismiss();
                        if(task.isSuccessful())
                        {
                            Toast.makeText(LoginActivity.this,"Welcome...",Toast.LENGTH_LONG).show();
                            Intent i=new Intent(LoginActivity.this,Stud_profile.class);
                            i.putExtra("Name",firebaseAuth.getCurrentUser().getEmail());
                            startActivity(i);
                        }
                        else
                        {
                            Log.e("Error",task.getException().toString());
                            Toast.makeText(LoginActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }
}