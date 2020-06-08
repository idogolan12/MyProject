package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.tv.TvView;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class achievements extends AppCompatActivity {

    SQLiteDatabase sqdb;
    DBHelper my_db;
    TextView ani, coun , cit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        ani = findViewById(R.id.ani);
        coun = findViewById(R.id.coun);
        cit = findViewById(R.id.cit);
        my_db = new DBHelper(this);
        sqdb=my_db.getWritableDatabase();
        Cursor c=sqdb.query(DBHelper.TABLE_NAME2,
                null, null, null, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            String t1=c.getString(0);
            String t2=c.getString(1);
            if (LoginActivity.USER.equals(t1)&&LoginActivity.PASS.equals(t2))
            {
                coun.setText(c.getString(2));
                cit.setText(c.getString(3));
                ani.setText(c.getString(4));
                break;
            }
            c.moveToNext();
        }
        c.close();
        sqdb.close();
    }
}
