package com.example.android.ieye;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InsertUserData extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseUser user;
    private DatabaseReference reference;
    private EditText email;
    private EditText first_name,last_name,month,year,day,mobile,work,add_lane_1,add_lane_2,country,state,pin_code;
    private Button submit_details;
    EditUser editUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_user_data);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();

        first_name=(EditText) findViewById(R.id.First_name);
        last_name=(EditText) findViewById(R.id.Last_name);
        month=(EditText)findViewById(R.id.month);
        year=(EditText)findViewById(R.id.year);
        day=(EditText)findViewById(R.id.day);
        email=(EditText) findViewById(R.id.email);
        mobile=(EditText) findViewById(R.id.mobile_no);
        work=(EditText)findViewById(R.id.work_no);
        add_lane_1=(EditText)findViewById(R.id.add_lane_1);
        add_lane_2=(EditText)findViewById(R.id.add_lane_2);
        country=(EditText)findViewById(R.id.country);
        state=(EditText)findViewById(R.id.state);
        pin_code=(EditText)findViewById(R.id.pin_code);


        reference= FirebaseDatabase.getInstance().getReference();
        email.setText(user.getEmail());

        editUser=new EditUser();

    }

    private void getValues()
    {
        editUser.setFirst_name(first_name.getText().toString());
        editUser.setLast_name(last_name.getText().toString());
        editUser.setMonth(month.getText().toString());
        editUser.setYear(year.getText().toString());
        editUser.setDay(day.getText().toString());
        editUser.setEmail(email.getText().toString());
        editUser.setMobile(mobile.getText().toString());
        editUser.setWork(work.getText().toString());
        editUser.setAdd_lane_1(add_lane_1.getText().toString());
        editUser.setAdd_lane_2(add_lane_2.getText().toString());
        editUser.setCountry(country.getText().toString());
        editUser.setState(state.getText().toString());
        editUser.setPin_code(pin_code.getText().toString());
    }




    public void submitButtonUserDetails(View view)
    {
        boolean done=false;
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                getValues();
                reference.child("Student".toString()).child(user.getUid()).setValue(editUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        Toast.makeText(getApplicationContext(),"Edited Successfully...",Toast.LENGTH_LONG).show();
                        Intent i=new Intent(InsertUserData.this,Stud_profile.class);
                        startActivity(i);
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });


    }
}

