package com.example.muhammadahsan.smartchat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class User_Chat_Activity extends AppCompatActivity {
    static String currentActivity;
    private static final String
            id_key = "id",
            name_key = "name",
            mobileNo_key = "mobileNo",
            picUri_key = "picUri";
    SharedPreferences preferences;
    int intent_registration_key = 100;
    User user;
    ImageView send_btn;
    EditText message;
    ListView listView;
    DatabaseReference db;
    Message mgs;
    MessageAdaptor messageAdaptor;
    ArrayList<Message> messageArrayList;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_chat);



        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.onStart();

        initGedgets();
        //getSharePreference();
        gedgetsListners();
        firebaseListeners();

        progressDialog.cancel();
    }

    private void initGedgets() {
        currentActivity = "activity_main";
        message = (EditText) findViewById(R.id.et_message);
        listView = (ListView) findViewById(R.id.lv_messages);
        send_btn = (ImageView) findViewById(R.id.pic_send);

        //user = new User("100","Muhammad Ahsan","03003545121","gs://smartchat-89d8a.appspot.com/ahsan.jpg");
        user = new User();
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        messageArrayList = new ArrayList<Message>();
        messageAdaptor = new MessageAdaptor(this, messageArrayList);
        listView.setAdapter(messageAdaptor);

        db = FirebaseDatabase.getInstance().getReference().child("message");

    }

    private void gedgetsListners() {
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (message.length() >  0) {
                    mgs = new Message(
                            new SimpleDateFormat("hh:mm:ss a").format(Calendar.getInstance().getTime()),
                            message.getText().toString(),
                            db.push().getKey().toString()
                    );

                    FirebaseDatabase.getInstance().getReference()
                            .child("message")
                            .child(mgs.getKey())
                            .setValue(mgs);

                    message.setText(null);
                }
            }
        });
    }
    public void firebaseListeners(){

        FirebaseDatabase.getInstance().getReference().child("message")
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        Message mess = dataSnapshot.getValue(Message.class);

                        messageArrayList.add(mess);
                        messageAdaptor.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                        messageAdaptor.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                        messageAdaptor.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                        messageAdaptor.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                        messageAdaptor.notifyDataSetChanged();
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        setSharePreference();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    public void onBackPressed() {
        if(preferences.getString(id_key,"").length() == 0){
            Intent intent = new Intent(User_Chat_Activity.this, SignUpActivity.class);
            startActivity(intent);
        }else{
            if(currentActivity.equals("activity_main")){
                super.onBackPressed();
            }else{
                super.onPause();
            }
        }
    }


    private void setSharePreference(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(id_key,user.getId());
        editor.putString(name_key,user.getName());
        editor.putString(mobileNo_key,user.getMobileNo());
        editor.putString(picUri_key,user.getPicUri());
        editor.apply();
    }

    private void getSharePreference() {
        if (preferences.getString(id_key, "").length() > 0) {
            user.setId(preferences.getString(id_key, ""));
            user.setName(preferences.getString(name_key, ""));
            user.setMobileNo(preferences.getString(mobileNo_key, ""));
            user.setPicUri(preferences.getString(picUri_key, ""));
            Toast.makeText(this, "Welcome back.", Toast.LENGTH_SHORT).show();
        } else {

            //setContentView(R.layout.activity_sign_up);

            Intent intent = new Intent(User_Chat_Activity.this, SignUpActivity.class);
            startActivity(intent);


            //setContentView(R.layout.activity_sign_up);
            //Toast.makeText(this, "Welcome to Hello Android!", Toast.LENGTH_SHORT).show();
        }
    }
}
