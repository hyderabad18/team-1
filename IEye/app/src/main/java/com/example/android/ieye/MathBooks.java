package com.example.android.ieye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MathBooks extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_books);
    }

    public void request(View view)
    {
        Intent i=new Intent(MathBooks.this,Main3Activity.class);
        startActivity(i);
    }
}
