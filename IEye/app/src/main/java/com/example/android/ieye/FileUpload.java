package com.example.android.ieye;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class FileUpload extends AppCompatActivity {

    Button file_upload,upload;
    TextView notification;
    Uri audUri;

    FirebaseStorage firebaseStorage;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_upload);

        firebaseStorage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();

        file_upload = findViewById(R.id.button5);
        upload = findViewById(R.id.button6);
        notification = findViewById(R.id.textView);

        file_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(FileUpload.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    selectAudio();
                } else {
                    ActivityCompat.requestPermissions(FileUpload.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 9);
                }
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(audUri!=null)
                {
                    uploadFile(audUri);
                }
                else
                    Toast.makeText(FileUpload.this,"Select a file",Toast.LENGTH_LONG).show();

            }
        });
    }
    public void uploadFile(Uri audUri)
    {
        progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File");
        progressDialog.setProgress(0);
        progressDialog.show();

        final String filename=System.currentTimeMillis()+"";
        StorageReference storageReference=firebaseStorage.getReference();
        storageReference.child("uploads").child(filename).putFile(audUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>(){
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        String url=taskSnapshot.getDownloadUrl().toString();
                        DatabaseReference  reference=database.getReference();
                        reference.child(filename).setValue(url).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful())
                                    Toast.makeText(FileUpload.this,"File Successfull uploaded",Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(FileUpload.this,"File not Successfully uploaded",Toast.LENGTH_LONG).show();

                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener(){
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(FileUpload.this,"File not Successfully uploaded",Toast.LENGTH_LONG).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                int currentProgress=(int)(100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentProgress);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode==9 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
        {
            selectAudio();

        }
        else
            Toast.makeText(FileUpload.this,"please provide ",Toast.LENGTH_LONG).show();
    }


    private void selectAudio()
    {

        Intent i=new Intent();
        i.setType("audio/mp3");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(i,86);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //  super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==86 && resultCode==RESULT_OK && data!=null)
        {
            audUri=data.getData();
            notification.setText("A Audio is Selected: "+data.getData().getLastPathSegment());
        }
        else
            Toast.makeText(FileUpload.this,"Please select a file",Toast.LENGTH_LONG).show();
    }



}
