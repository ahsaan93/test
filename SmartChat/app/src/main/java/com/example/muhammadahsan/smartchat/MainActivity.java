package com.example.muhammadahsan.smartchat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ImageView send_btn;
    EditText message;
    ListView listView;
    DatabaseReference db;
    Message mgs;
    MessageAdaptor messageAdaptor;
    ArrayList<Message> messageArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initGedgets();
        gedgetsListners();
        firebaseListeners();
    }

    private void initGedgets() {

        message = (EditText) findViewById(R.id.et_message);
        listView = (ListView) findViewById(R.id.lv_messages);
        send_btn = (ImageView) findViewById(R.id.pic_send);

        messageArrayList = new ArrayList<Message>();

        messageAdaptor = new MessageAdaptor(this, messageArrayList);
        listView.setAdapter(messageAdaptor);

        db = FirebaseDatabase.getInstance().getReference().child("message/");

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
}
