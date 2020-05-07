package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

    public void gograde(View view) {

        DBHelper hlp = new DBHelper(this);;
        SQLiteDatabase db = hlp.getWritableDatabase();
        Cursor c = db.query(DBHelper.TABLE_NAME2, null, DBHelper.NICKNAME+"=?", new String[]{MainActivity.USER},
                null,null,null);
        c.moveToFirst(); //?

        String grades = "";
        grades +=  "countries: " + c.getString(c.getColumnIndex(DBHelper.SUBJECTS[0]));
        grades +=  "\n" + "cities: " + c.getString(c.getColumnIndex(DBHelper.SUBJECTS[1]));
        grades +=  "\n" +"animals: " + c.getString(c.getColumnIndex(DBHelper.SUBJECTS[2]));
        Toast.makeText(this, grades, Toast.LENGTH_SHORT).show();

        db.close();
    }
}
