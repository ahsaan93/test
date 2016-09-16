package com.example.muhammadahsan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.muhammadahsan.intentactivites.R;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ListView listView = (ListView) findViewById(R.id.listView_phrases);

        String items[]= new String[]{"PhrasOne","PhrasTwo","PhrasThree","PhrasFour","PhrasFive","PhrasSix","PhrasSeven","PhrasEight","PhrasNine","PhrasTen"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(PhrasesActivity.this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);
    }
}
