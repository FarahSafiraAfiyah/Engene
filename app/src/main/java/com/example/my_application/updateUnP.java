package com.example.my_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class updateUnP extends AppCompatActivity {

    EditText userEdited, passEdited;
    SharedPreferences preferences;
    public static final String SHAREDPREF = "mySharedPref";
    public static final String USERNAME_KEY = "username";
    public static final String PASSWORD_KEY = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_un_p);

        userEdited = findViewById(R.id.UNEdited);
        passEdited = findViewById(R.id.passwordEdited);

        preferences = getSharedPreferences(SHAREDPREF,MODE_PRIVATE);
        String UNEdit = preferences.getString(USERNAME_KEY,null);
        String PassEdit = preferences.getString(PASSWORD_KEY,null);

        userEdited.setText(UNEdit);
        passEdited.setText(PassEdit);
    }

    public void edited(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        String edit_user = userEdited.getText().toString();
        String edit_pass = passEdited.getText().toString();

        if ((!edit_user.equals(preferences.getString(USERNAME_KEY,null))) && (!edit_pass.equals(preferences.getString(PASSWORD_KEY,null)))){
            editor.putString(USERNAME_KEY,userEdited.getText().toString());
            editor.putString(PASSWORD_KEY,passEdited.getText().toString());
            editor.commit();
            Toast.makeText(updateUnP.this, "Update berhasil", Toast.LENGTH_SHORT).show();

        }else{
//            Intent intent = new Intent (Login.this,MainActivity.class);
//            startActivity(intent);
//            Toast.makeText(Login.this, "Login berhasil kak >_o", Toast.LENGTH_SHORT).show();
            Toast.makeText(updateUnP.this, "Update gagal", Toast.LENGTH_SHORT).show();
        }
    }
}