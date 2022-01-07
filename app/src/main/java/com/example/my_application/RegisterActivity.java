package com.example.my_application;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText namaLengkap, user, pass;
    SharedPreferences preferences;
    public static final String SHAREDPREF = "mySharedPref";
    public static final String USERNAME_KEY = "username";
    public static final String PASSWORD_KEY = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        namaLengkap = findViewById(R.id.etNamaLengkap);
        user =findViewById(R.id.et_emailSignup);
        pass =findViewById(R.id.et_passwordSignup);
    }

    public void toLogin(View view) {
        Intent intent = new Intent(RegisterActivity.this,Login.class);
        startActivity(intent);
    }

    public void create(View view) {
        preferences = getSharedPreferences(SHAREDPREF, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USERNAME_KEY,user.getText().toString());
        editor.putString(PASSWORD_KEY, pass.getText().toString());
        editor.commit();
        Toast.makeText(getApplicationContext(), "Berhasil Tersimpan", Toast.LENGTH_SHORT).show();

    }

}