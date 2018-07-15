package com.example.android.ieye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Volunteer_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_profile2);

    }
    public void btn_math(View view)
    {
        Intent i=new Intent(Volunteer_profile.this,MathBooks.class);
        startActivity(i);
    }
}
