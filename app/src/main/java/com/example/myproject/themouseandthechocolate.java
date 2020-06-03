package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class themouseandthechocolate extends AppCompatActivity {
    EditText etLine, etRaw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themouseandthechocolate);
        etLine = findViewById(R.id.edLine);
        etRaw = findViewById(R.id.edRaw);
    }

    public void goToGame(View view) {
        Intent intent = new Intent(this ,TheMouseAndTheChocolateGame.class);
        intent.putExtra("line", etLine.getText().toString());
        intent.putExtra("raw", etRaw.getText().toString());
        startActivity(intent);
    }
}