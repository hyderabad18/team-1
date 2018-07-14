package com.example.android.ieye;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText txtEmail;
    private EditText txtPassword;
    private FirebaseUser firebaseUser;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference rootReference;
    private GoogleSignInClient mGoogleSignInClient;
    private SignInButton signInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail=(EditText) findViewById(R.id.txtEmailRegister);
        txtPassword=(EditText) findViewById(R.id.txtPasswordRegister);
        firebaseAuth=firebaseAuth.getInstance();
        rootReference= FirebaseDatabase.getInstance().getReference();


        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient=GoogleSignIn.getClient(MainActivity.this,gso);
        signInButton=(SignInButton)findViewById(R.id.googleSignInButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 101);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == 101) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                // Log.w(TAG, "Google sign in failed", e);
                // ...
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account)
    {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Intent i=new Intent(MainActivity.this,StudentdashboardActivity.class);
                            startActivity(i);
                            finish();
                            Toast.makeText(MainActivity.this,"Welcome..",Toast.LENGTH_LONG).show();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this,"Error..",Toast.LENGTH_LONG).show();
                        }

                        // ...
                    }
                });








    }

    public void btnRegister_click(View v)
    {


        final String email=txtEmail.getText().toString();
        final String password=txtPassword.getText().toString();

        final ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this,"Please wait...","Processing" ,true);
        (firebaseAuth.createUserWithEmailAndPassword(txtEmail.getText().toString(),txtPassword.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if(task.isSuccessful())
                        {
                            firebaseUser = firebaseAuth.getCurrentUser();

                            Student user=new Student(txtEmail.getText().toString(),txtPassword.getText().toString(),
                                    "  ","  ","  ","  "
                                    ,"  ","  ","  ","  ","  ","  ","  ","  ");

                            rootReference.child("Student").child(firebaseUser.getUid()).setValue(user)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {


                                            String subject=" I&Eye Welcomes You";
                                            String message= "Here are your login details \n"+
                                                    "Email Id: " + email+ "\n" + "Password : " + password +"\nThank you..."+"\nTeam Home";

                                            if(task.isSuccessful())
                                            {
                                                SendMail sm = new SendMail(MainActivity.this, email, subject, message);
                                                sm.execute();

                                                //  Toast.makeText(MainActivity.this,"Welcome " +email,Toast.LENGTH_LONG).show();
                                                Toast.makeText(MainActivity.this,"Welcome "+ email +"\nA mail has been sent with your login " +
                                                        "credentials ",Toast.LENGTH_LONG).show();
                                                Intent i=new Intent(MainActivity.this,StudentdashboardActivity.class);
                                                startActivity(i);

                                            }
                                        }
                                    });

                        }
                        else{


                            Log.e("Error",task.getException().toString());
                            Toast.makeText(MainActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                            //   Intent i=new Intent(RegisterActivity.this,RegisterActivity.class);
                            //   startActivity(i);
                            //   Toast.makeText(getApplicationContext(),"Username already in Use", Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }

    public void btnLogin_click(View v){
        Intent i=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(i);
    }

}

