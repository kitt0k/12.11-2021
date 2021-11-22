package com.example.a121121;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FinalWindow extends Activity {

    TextView tvView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalwindow);
        tvView = findViewById(R.id.tvView);

        Intent intent = getIntent();
        String LLogin = intent.getStringExtra("LLogin");
        String PPassword = intent.getStringExtra("PPassword");


        tvView.setText("Вы успешно авторизовались. " +
                "\nВаш Логин: " + LLogin + "," +
                "\nВаш  Пароль: " + PPassword + ".");
    }
}