package com.example.android.ieye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectCandidateList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_candidate_list);
    }
    public void Admin_click(View view)
    {

    }
    public void volunteer_click(View view)
    {
        Intent intent=new Intent(SelectCandidateList.this,Main2Activity.class);
        startActivity(intent);
}  public void user_click(View view)
    {
        Intent intent=new Intent(SelectCandidateList.this,MainActivity.class);
         startActivity(intent);
    }
}
