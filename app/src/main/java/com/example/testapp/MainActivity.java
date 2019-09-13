package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onButtonClick();
    }

    public void onButtonClick(){
        pass = (EditText)findViewById(R.id.editText);
        btn = (Button)findViewById(R.id.but1);
        btn.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(                //Всплывающее окно
                                MainActivity.this, pass.getText(), LENGTH_LONG
                        ).show();                   // метод, который покажет всплвающее окно
                    }
                }
        );
    }


}
