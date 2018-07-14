package com.example.android.ieye;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginRedirectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_redirect);
    }

    public void studentclick(View v)    
    {
        Intent iStudent = new Intent(LoginRedirectActivity.this,MainActivity.class);
        startActivity(iStudent);
    }
    public void volunteerclick(View v)
    {
        Intent iVolunteer = new Intent(LoginRedirectActivity.this,VolunteerSignupActivity.class);
        startActivity(iVolunteer);
    }
}
