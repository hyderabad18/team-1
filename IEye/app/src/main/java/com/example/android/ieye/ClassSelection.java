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

public class ClassSelection extends AppCompatActivity {

    RadioButton radioButton;
    RadioGroup radioGroup;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference rootReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_selection);
       // radioGroup=findViewById(R.id.radioGroup);

        firebaseAuth=firebaseAuth.getInstance();
        rootReference= FirebaseDatabase.getInstance().getReference().child("Class");
        createRadioButtons();
        setUpPrintSelectedButton();

    }


    private void setUpPrintSelectedButton() {
        Button button=(Button) findViewById(R.id.radio_fyear);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idofselected = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton=findViewById(idofselected);
                String message=radioButton.getText().toString();
            }
        });
    }

    private void createRadioButtons()
    {
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.radio_group_install_size);

        int[] numpannels=getResources().getIntArray(R.array.num_solar_panels);
        for(int i=0;i< numpannels.length;i++)
        {
            final int numpannel=numpannels[i];

            RadioButton button=new RadioButton(this);
            button.setText(numpannel +" class ");

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ClassSelection.this,"You clicked " +numpannel,Toast.LENGTH_LONG).show();
                }
            });
            if(numpannel==10)
            {
                Intent i1=new Intent(ClassSelection.this,BookSelection.class);
                startActivity(i1);

                Intent i2=new Intent(ClassSelection.this,MathBooks.class);
                i2.putExtra("Class",numpannel);
              //  rootReference.child("10").child("Books");
            }
            if(numpannel==11)
            {
                rootReference.child("11").child("Books");
            }

            radioGroup.addView(button);
        }
    }
}
