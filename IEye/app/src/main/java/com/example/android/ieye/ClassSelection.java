package com.example.android.ieye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.BindException;

public class ClassSelection extends AppCompatActivity {

    RadioButton radioButton;
    Button b1,b2,b3;
    RadioGroup radioGroup;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference rootReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_selection);
       // radioGroup=findViewById(R.id.radioGroup);

        b1=(Button)findViewById(R.id.button5);
        b2=(Button)findViewById(R.id.button6);
        b3=(Button)findViewById(R.id.button7);
        firebaseAuth=firebaseAuth.getInstance();
        rootReference= FirebaseDatabase.getInstance().getReference().child("Class");

    }

    public void btn_class10(View view)
    {
        Intent i=new Intent(ClassSelection.this,BookSelection.class);
        startActivity(i);
    }


    public void btn_class11(View view)
    {
        Intent i=new Intent(ClassSelection.this,BookSelection.class);
        startActivity(i);
    }


    public void btn_class12(View view)
    {
        Intent i=new Intent(ClassSelection.this,BookSelection.class);
        startActivity(i);
    }

}
