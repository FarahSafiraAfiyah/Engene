package com.example.my_application;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText user, pass;
    SharedPreferences preferences;
    public static final String SHAREDPREF = "mySharedPref";
    public static final String USERNAME_KEY = "username";
    public static final String PASSWORD_KEY = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.et_emailSignin);
        pass = findViewById(R.id.et_passwordSignin);

    }

    public void Login(View view) {

        preferences = getSharedPreferences(SHAREDPREF, Activity.MODE_PRIVATE);
        String Username = user.getText().toString();
        String Password = pass.getText().toString();

        if ((!Username.equals(preferences.getString(USERNAME_KEY,null))) && (!Password.equals(preferences.getString(PASSWORD_KEY,null)))){

            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.toast_custom, (ViewGroup) findViewById(R.id.custom_toast_layout_id));
            TextView tv = (TextView) layout.findViewById(R.id.text);
            tv.setText("ada kesalahan pada USERNAME atau PASSWORD");

            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();
        }else{
            Intent intent = new Intent (Login.this,MainActivity.class);
            startActivity(intent);
            Toast.makeText(Login.this, "Login berhasil kak >_o", Toast.LENGTH_SHORT).show();
        }

    }

    public void toRegist(View view) {
        Intent intent = new Intent(Login.this,RegisterActivity.class);
        startActivity(intent);
    }
}