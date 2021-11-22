package com.example.a121121;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText etLogin;
    EditText etPassword;

    Button btnSubmit;

    SharedPreferences sPref;
    SharedPreferences sPref1;

    final String LOGIN = "Login";
    final String PASSWORD = "Password";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLogin = findViewById(R.id.etLogin);
        etPassword = findViewById(R.id.etPassword);



        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.btnSubmit:
                saveText();
                break;
            default:
                break;
        }

        Intent intent = new Intent(MainActivity.this, Authorization.class);
        startActivity(intent);

    }

    void saveText() {
        sPref = getSharedPreferences(LOGIN,MODE_PRIVATE);
        Editor save = sPref.edit();
        save.putString(LOGIN, etLogin.getText().toString());
        save.commit();

        sPref1 = getSharedPreferences(PASSWORD,MODE_PRIVATE);
        Editor saved = sPref1.edit();
        saved.putString(PASSWORD, etPassword.getText().toString());
        saved.commit();
        Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();
    }

}