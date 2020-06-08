package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt_start;
    Animation frombottom , fromtop;
    ImageView appicon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_start =findViewById(R.id.btstart);
        appicon = findViewById(R.id.appicon);
        frombottom = AnimationUtils.loadAnimation(this,R.anim.frombottom);
        fromtop = AnimationUtils.loadAnimation(this,R.anim.fromtop);
        bt_start.setAnimation(frombottom);
        appicon.setAnimation(fromtop);
    }

    public void gotologin(View view) {
        Intent go = new Intent(this,LoginActivity.class);
        startActivity(go);
    }
}

