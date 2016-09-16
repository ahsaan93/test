package com.example.muhammadahsan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.muhammadahsan.intentactivites.MainActivity;
import com.example.muhammadahsan.intentactivites.R;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ListView listView = (ListView) findViewById(R.id.listView_numbers);

        final String items[]= new String[]{"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(NumbersActivity.this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);

/*
        listView.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(NumbersActivity.this,items[i],Toast.LENGTH_SHORT).show();
            }
        });
*/
    }
}
