package com.example.muhammadahsan.smartchat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;


public class MainActivity extends AppCompatActivity {
    static String currentActivity;
    private StorageReference mStorageRef;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         Intent intent = new Intent(getApplicationContext(),NameActivity.class);
         startActivity(intent);

         ImageView image = (ImageView) findViewById(R.id.im_profileImage);
         Button upload = (Button) findViewById(R.id.btn_upload);

         upload.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 mStorageRef = FirebaseStorage.getInstance().getReference();
                 Uri file = Uri.fromFile(new File("path/to/images/rivers.jpg"));

                 StorageReference riversRef = mStorageRef.child("images/rivers.jpg");

                 riversRef.putFile(file)
                         .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                             @Override
                             public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                 // Get a URL to the uploaded content
                                 Uri downloadUrl = taskSnapshot.getDownloadUrl();
                                 Toast.makeText(MainActivity.this, "Upload done", Toast.LENGTH_SHORT).show();
                             }
                         })
                         .addOnFailureListener(new OnFailureListener() {
                             @Override
                             public void onFailure(@NonNull Exception exception) {
                                 Toast.makeText(MainActivity.this, "Upload failed! "+exception.getMessage(), Toast.LENGTH_SHORT).show();

                                 // Handle unsuccessful uploads
                                 // ...
                             }
                         });
             }

         });
}
}
