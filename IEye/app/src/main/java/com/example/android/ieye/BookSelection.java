package com.example.android.ieye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BookSelection extends AppCompatActivity {

    Button math,physics,chem;
    TextView classes;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference rootReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_selection);

        firebaseAuth=firebaseAuth.getInstance();
        classes=(TextView)findViewById(R.id.classes);
        classes.setText(getIntent().getExtras().getString("class"));
        String classes = getIntent().getStringExtra("class");
        Intent inten=new Intent();
        rootReference= FirebaseDatabase.getInstance().getReference().child("Class");
        math=(Button)findViewById(R.id.math);
        physics=(Button)findViewById(R.id.physics);
        chem=(Button)findViewById(R.id.chemistry);
    }
    public void btn_math(View view)
    {
        Intent i1=new Intent(BookSelection.this,MathBooks.class);
        startActivity(i1);
    }

    public void btn_phy(View view)
    {

    }


    public void btn_chem(View view)
    {

    }
}
