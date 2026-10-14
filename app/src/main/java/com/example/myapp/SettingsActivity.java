package com.example.myapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Switch sw = findViewById(R.id.switchDark);
        EditText et = findViewById(R.id.etName);
        Button btn = findViewById(R.id.btnSave);

        SharedPreferences prefs = getSharedPreferences("app", MODE_PRIVATE);
        et.setText(prefs.getString("name", ""));
        sw.setChecked(prefs.getBoolean("dark", false));

        btn.setOnClickListener(v -> {
            prefs.edit()
                .putString("name", et.getText().toString())
                .putBoolean("dark", sw.isChecked())
                .apply();
            Toast.makeText(this, "تم الحفظ!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
