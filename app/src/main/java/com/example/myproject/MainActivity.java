package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void regist(View view) {
        Intent go = new Intent(this,register.class);
        startActivity(go);
    }

    public void log(View view) {
        Intent go = new Intent(this,home.class);
        startActivity(go);
    }
}
