package com.example.muhammadahsan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.muhammadahsan.intentactivites.R;

public class FamilyMembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_members);

        ListView listView = (ListView) findViewById(R.id.listView_familyMembers);

        String items[]= new String[]{"Shabbir Ahmed","Zahoor Elahi","Rabnawaz","Naseem Akhtar","Haqnawaz","Imran","Farhan","Ahsan","Sadaf"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(FamilyMembersActivity.this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);
    }
}
