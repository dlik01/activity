package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public  Button btnIntent, btnSave;
    EditText etnum, ettext, etemail, etime, etdate;
    SharedPreferences sharedPreferences;
    Editor editor;
    public static String NUM = "number";
    public static String DATE = "date";
    public static String TIME = "time";
    public static String TEXT = "text";
    public static String EMAIL = "Email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getPreferences(MODE_PRIVATE);
        editor = sharedPreferences.edit();
        etnum = findViewById(R.id.etnum);
        ettext = findViewById(R.id.ettext);
        etemail = findViewById(R.id.etemail);
        etime = findViewById(R.id.etime);
        etdate = findViewById(R.id.etdate);
        btnIntent = findViewById(R.id.btnIntent);
        btnSave = findViewById(R.id.btnSave);
        loadText();
    }

    private void saveText() {
        editor.putString(NUM, String.valueOf(etnum.getText()));
        editor.putString(DATE, String.valueOf(etdate.getText()));
        editor.putString(TIME, String.valueOf(etime.getText()));
        editor.putString(TEXT, String.valueOf(ettext.getText()));
        editor.putString(EMAIL, String.valueOf(etemail.getText()));
        editor.commit();
    }

    private void loadText() {
        String num = sharedPreferences.getString(NUM, "");
        String date = sharedPreferences.getString(DATE, "");
        String  time = sharedPreferences.getString(TIME, "");
        String text = sharedPreferences.getString(TEXT, "");
        String email = sharedPreferences.getString(EMAIL, "");

        etnum.setText(num);
        ettext.setText(text);
        etemail.setText(email);
        etime.setText(time);
        etdate.setText(date);

        editor.clear();
        editor.commit();

    }

    public void onClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(NUM, etnum.getText().toString());
        intent.putExtra(DATE, etdate.getText().toString());
        intent.putExtra(TIME, etime.getText().toString());
        intent.putExtra(TEXT, ettext.getText().toString());
        intent.putExtra(EMAIL, etemail.getText().toString());
        startActivity(intent);
    }

    public void onClickSave(View view) {
        saveText();
    }
}
