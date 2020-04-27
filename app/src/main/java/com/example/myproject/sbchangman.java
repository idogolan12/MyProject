package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sbchangman extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sbchangman);
    }

    public void ams(View view) {
        Intent go = new Intent(this,hangm.class);
        go.putExtra("wordesType","a");
        startActivity(go);
    }

    public void cny(View view) {
        Intent go = new Intent(this,hangm.class);
        go.putExtra("wordesType","b");
        startActivity(go);
    }

    public void cts(View view) {
        Intent go = new Intent(this,hangm.class);
        go.putExtra("wordesType","c");
        startActivity(go);
    }
}
