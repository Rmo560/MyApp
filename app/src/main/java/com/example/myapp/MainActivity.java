package com.example.myapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private boolean darkMode = false;
    private TextView tvTitle, tvCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        tvCounter = findViewById(R.id.tvCounter);
        Button btnCounter = findViewById(R.id.btnCounter);
        Button btnSecond = findViewById(R.id.btnSecond);
        Button btnSettings = findViewById(R.id.btnSettings);

        btnCounter.setOnClickListener(v -> {
            count++;
            tvCounter.setText("العداد: " + count);
            darkMode = !darkMode;
            int bg = darkMode ? Color.parseColor("#1A237E") : Color.parseColor("#E3F2FD");
            int fg = darkMode ? Color.WHITE : Color.parseColor("#1A237E");
            findViewById(android.R.id.content).setBackgroundColor(bg);
            tvTitle.setTextColor(fg);
        });

        btnSecond.setOnClickListener(v -> startActivity(new Intent(this, SecondActivity.class)));
        btnSettings.setOnClickListener(v -> startActivity(new Intent(this, SettingsActivity.class)));
    }
}
