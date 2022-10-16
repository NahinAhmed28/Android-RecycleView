package com.example.bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CapitalsActivity extends AppCompatActivity {

    ListView listView;
    String[] capitals = {"Dhaka", "Delhi", "Islamabad", "Kathmandu"  };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitals);

        listView =findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CapitalsActivity.this, android.R.layout.simple_dropdown_item_1line, capitals);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CapitalsActivity.this,  capitals[i] +" is clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}