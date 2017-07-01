package com.example.muhammadahsan.smartchat;

import android.app.ProgressDialog;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static android.content.Intent.ACTION_PICK;

public class NameActivity extends AppCompatActivity {

    private static final String
            id_key = "id",
            name_key = "name",
            mobileNo_key = "mobileNo",
            picUri_key = "picUri";
    SharedPreferences preferences;
    StorageReference storageRef;
    StorageReference storage;
    EditText name;
    TextView tv_profile_setting;
    Button next;
    ImageView profilePic;
    private final int SELECT_PHOTO = 1;
    static Uri imageUri,downloadUrl;
    DatabaseReference db;
    User user;
    String generatedId;
    UploadTask uploadTask;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        initGedgets();
        gedgetsListners();
    }

    private void initGedgets() {
        MainActivity.currentActivity = "activity_name";

        progressDialog = new ProgressDialog(this);
        db = FirebaseDatabase.getInstance().getReference().child("users");
        name = (EditText) findViewById(R.id.ed_name);
        next = (Button) findViewById(R.id.btn_next);
        profilePic = (ImageView) findViewById(R.id.im_profilePic);
        tv_profile_setting = (TextView) findViewById(R.id.tv_profile_settingUP);
    }

    private void gedgetsListners() {
        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, SELECT_PHOTO);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = name.getText().toString();
                if(name1.length() == 0){
                    Toast.makeText(NameActivity.this, "Name not found!", Toast.LENGTH_SHORT).show();
                }else{
                    progressDialog.setMessage("Registering");
                    progressDialog.show();
                    generatedId = db.push().getKey().toString();
                    user = new User(
                                    generatedId,
                                    name1,
                                    SignUpActivity.mobileNumber,
                                    downloadUrl.toString());

                    db.child(generatedId).child("id").setValue(user.getId());
                    db.child(generatedId).child("name").setValue(user.getName());
                    db.child(generatedId).child("mobileNo").setValue(user.getMobileNo());
                    db.child(generatedId).child("picUri").setValue(user.getPicUri());

                    Toast.makeText(NameActivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NameActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SELECT_PHOTO && resultCode == RESULT_OK){

            progressDialog.setMessage("Uploading started...");
            progressDialog.show();

            Uri file = data.getData();
            StorageReference riversRef = FirebaseStorage.getInstance()
                    .getReference().child("images/"+file.getLastPathSegment());
            uploadTask = riversRef.putFile(file);

            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {

                    Toast.makeText(NameActivity.this, "upload failed", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    progressDialog.dismiss();
                    Toast.makeText(NameActivity.this, "upload done", Toast.LENGTH_SHORT).show();
                    Picasso.with(getApplicationContext())
                            .load(downloadUrl)
                            .placeholder(R.drawable.profile_pic_loading)
                            .into(profilePic);

                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        if(MainActivity.currentActivity.equals("activity_name")){
            super.onPause();
            //super.onBackPressed();
        }else{
            super.onBackPressed();
        }
    }
}
