package com.example.muhammadahsan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.muhammadahsan.intentactivites.MainActivity;
import com.example.muhammadahsan.intentactivites.R;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ListView listView = (ListView) findViewById(R.id.listView_Colors);

        final String items[]= new String[]{"Red","Green","Yellow","Blue","Pink","Black","White","Brown","Purpal","Grey"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ColorsActivity.this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);
/*
        listView.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(this,items[i],Toast.LENGTH_SHORT).show();
            }
        });
*/

    }
}
