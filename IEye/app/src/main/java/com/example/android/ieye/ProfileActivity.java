package com.example.android.ieye;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends Activity {


    private FirebaseAuth auth;
    private FirebaseUser user;
    private DatabaseReference reference;
    private ListView listView;
    private ProfileList adapter;
    private TextView email;
    private EditText first_name,last_name,month,year,day,mobile,work,add_lane_1,add_lane_2,country,state,pin_code;
    private Button submit_details;
    private List<Profile> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        email=(TextView) findViewById(R.id.email);
        listView=(ListView) findViewById(R.id.profile_list);
        list = new ArrayList<>();
        reference= FirebaseDatabase.getInstance().getReference().child("Student".toString()).child(user.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String first_name=dataSnapshot.child("first_name").getValue().toString();
                String last_name=dataSnapshot.child("last_name").getValue().toString();
                String month=dataSnapshot.child("month").getValue().toString();
                String year=dataSnapshot.child("year").getValue().toString();
                String day=dataSnapshot.child("day").getValue().toString();
                String email=dataSnapshot.child("email").getValue().toString();
                String mobile=dataSnapshot.child("mobile").getValue().toString();
                String work=dataSnapshot.child("work").getValue().toString();
                String add_lane_1=dataSnapshot.child("add_lane_1").getValue().toString();
                String add_lane_2=dataSnapshot.child("add_lane_2").getValue().toString();
                String country=dataSnapshot.child("country").getValue().toString();
                String state=dataSnapshot.child("state").getValue().toString();
                String pin=dataSnapshot.child("pin_code").getValue().toString();

                list.add(new Profile(1,first_name,last_name,month,year,day,email,mobile,work,add_lane_1,
                        add_lane_2,country,state,pin));


                adapter = new ProfileList(ProfileActivity.this, list);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //   list.add(new Profile(1,"Hemanth ","Loka","06","1998","19",
        //          "lokahemanthreddy@gmail.com","9959041441","7013805949",
        //         "Flat no:402 , Anu Residency","V.V.Nagar Colony, Mubharaknagar, Nizamabad","India","Telangana","503003"));




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Toast.makeText(getApplicationContext(),"Name is :" +view.getTag(),Toast.LENGTH_LONG).show();
            }
        });
    }


}
