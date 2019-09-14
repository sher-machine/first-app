package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    private Button btn, btn2, btn3;         //тип данных для кнопки
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton() ;
    }

    public void addListenerOnButton(){
        pass = (EditText)findViewById(R.id.editText);
        btn = (Button)findViewById(R.id.but1);
        btn2= (Button)findViewById(R.id.other_button);
        btn3= (Button)findViewById(R.id.alert);

        btn.setOnClickListener(                 //обработчик событий
                new View.OnClickListener(){     //новое действие при нажатии на кнопку
                    @Override
                    public void onClick(View v) {
                        btn.setText("DONE");                     //Установка текста после нажатия
                        btn.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));     //
                        Toast.makeText(                // метод создания всплывающего окна
                                MainActivity.this, pass.getText(), LENGTH_LONG
                        ).show();                   // метод, который покажет всплвающее окно
                    }
                }
        );

        btn2.setOnClickListener(                 //обработчик событий
                new View.OnClickListener(){     //новое действие при нажатии на кнопку
                    @Override
                    public void onClick(View v) {
                        btn.setBackgroundTintList(ColorStateList.valueOf(Color.RED));     //
                        Toast.makeText(                     // метод создания всплывающего окна
                                MainActivity.this, "Other_button", LENGTH_LONG
                        ).show();                            // метод, который покажет всплвающее окно
                    }
                }
        );



        btn3.setOnClickListener(                 //обработчик событий
                new View.OnClickListener() {     //новое действие при нажатии на кнопку
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this); //билдер всплывающих окон
                        a_builder.setMessage("Do u want close app?")
                                .setCancelable(false)   //нет кнопки закрыть
                                .setPositiveButton("YES", new DialogInterface.OnClickListener() {   //обработчик нажатия на кнопку "YES"
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();   //полное закрытие прилолжения
                                    }
                                })
                                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel(); //закрыть всплывающее окно
                                    }
                                });
                        AlertDialog alert = a_builder.create();         //само всплывающее окно
                        alert.setTitle("Close app");         //Заголовок для всплывающего окна
                        alert.show();
                    }
                }
        );
    }
}

