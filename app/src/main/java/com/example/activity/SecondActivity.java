package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends Activity {
    TextView tvNumber, tvText, tvEmail, tvTime, tvDate;
    String TAG = SecondActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Intent intent = getIntent();

        String action = intent.getStringExtra("number");
        Log.e(TAG, "" + intent.getStringExtra("number"));
        tvNumber = findViewById(R.id.tvNumber);
        tvDate = findViewById(R.id.tvDate);
        tvText = findViewById(R.id.tvText);
        tvEmail = findViewById(R.id.tvEmail);
        tvTime = findViewById(R.id.tvTime);


        tvDate.setText(intent.getStringExtra("date"));
        tvNumber.setText(intent.getStringExtra("number"));
        tvText.setText(intent.getStringExtra("text"));
        tvEmail.setText(intent.getStringExtra("Email"));
        tvTime.setText(intent.getStringExtra("time"));


        Toast.makeText(this, "" + action, Toast.LENGTH_SHORT).show();
    }
}
