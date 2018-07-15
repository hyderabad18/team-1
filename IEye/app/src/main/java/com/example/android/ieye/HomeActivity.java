package com.example.android.ieye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    Button button;
    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        t1=(TextView)findViewById(R.id.text);
        t2=(TextView)findViewById(R.id.text2);
      // button=(TextView)findViewById(R.id.gohome);
    }
    public void btn_Select(View view)
    {
        Intent i=new Intent(HomeActivity.this,SelectCandidateList.class);
        startActivity(i);
    }

}
