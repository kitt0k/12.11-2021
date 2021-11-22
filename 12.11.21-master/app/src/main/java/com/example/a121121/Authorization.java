package com.example.a121121;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Authorization extends Activity {

    EditText etLLogin;
    EditText etPPassword;
    EditText etLogin;
    EditText etPassword;

    Button btnSubmit;
    Button btnBack;

    TextView tvView;

    SharedPreferences sPref;
    SharedPreferences sPref1;

    final String LOGIN = "Login";
    final String PASSWORD = "Password";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorization);

        etLLogin = findViewById(R.id.etLLogin);
        etPPassword = findViewById(R.id.etPPassword);
        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);

        tvView = findViewById(R.id.tvView);

        loadText();

        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                if ((TextUtils.equals(etLLogin.getText(), etLogin.getText())) && (TextUtils.equals(etPPassword.getText(), etPassword.getText()))) {
                    Intent intent = new Intent(Authorization.this, FinalWindow.class);
                    intent.putExtra("LLogin", etLLogin.getText().toString());
                    intent.putExtra("PPassword", etPPassword.getText().toString());
                    startActivity(intent);
                } else {
                    tvView.setText("Введен неверный логин или пароль,повторите попытку заного.");
                }
            }

        });
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Authorization.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    void loadText() {
        sPref =  getSharedPreferences(LOGIN,MODE_PRIVATE);
        String savedLogin = sPref.getString(LOGIN, "");
        etLogin.setText(savedLogin);

        sPref1 = getSharedPreferences(PASSWORD,MODE_PRIVATE);
        String savedPassword = sPref1.getString(PASSWORD, "");
        etPassword.setText(savedPassword);
    }

}