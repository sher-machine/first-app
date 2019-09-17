package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private ListView list;
    private String [] names = new String[]{"John", "Bob", "Jorge", "Alex", "Kane"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        list();
    }

    public void list(){
        list = (ListView)findViewById(R.id.ListView);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.names,names);
        list.setAdapter(adapter);
        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                        String val = (String)list.getItemAtPosition(i);
                        Toast.makeText(
                                ThirdActivity.this, "Position" + i + "value:" + val, Toast.LENGTH_LONG
                        ).show();
                    }
                }
        );

    }
}
