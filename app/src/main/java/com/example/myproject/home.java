package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void next(View view) {
        Intent go = new Intent(this,sbchangman.class);
        startActivity(go);
    }

    public void gotomouse(View view) {
        Intent go = new Intent(this,themouseandthechocolate.class);
        startActivity(go);
    }
}
