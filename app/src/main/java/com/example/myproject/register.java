package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity implements View.OnClickListener {

    SQLiteDatabase sqdb;
    DBHelper my_db;
    Button bt3;
    EditText etnick, etpass, etmail, etphone;
    String[] infa = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        my_db = new DBHelper(this);
        sqdb = my_db.getWritableDatabase();
        sqdb.close();

        bt3 = findViewById(R.id.bt3);
        bt3.setOnClickListener(this);
        etnick = findViewById(R.id.etnick);
        etpass = findViewById(R.id.etpass);
        etmail = findViewById(R.id.etmail);
        etphone = findViewById(R.id.etphone);
    }


    @Override
    public void onClick(View view) {
        infa[0] = etnick.getText().toString();
        infa[1] = etpass.getText().toString();
        infa[2] = etmail.getText().toString();
        infa[3] = etphone.getText().toString();
        etnick.setText("");
        etpass.setText("");
        etmail.setText("");
        etphone.setText("");




        if (is_found(infa[0], infa[1])) {
            Toast.makeText(this,
                    "This name and pass is found",
                    Toast.LENGTH_LONG).show();
            finish();
        } else
            go_regist();
    }

    private boolean is_found(String s1, String s2) {
        boolean flag=false;
        sqdb=my_db.getWritableDatabase();
        Cursor c=sqdb.query(DBHelper.TABLE_NAME,
                null, null, null, null, null, null);
       int col1=c.getColumnIndex(DBHelper.NICKNAME);
        int col2=c.getColumnIndex(DBHelper.PASS);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            String t1=c.getString(col1);
            String t2=c.getString(col2);
            if (s1.equals(t1)&&s2.equals(t2))
                flag=true;
            c.moveToNext();
        }
        c.close();
        sqdb.close();
        return flag;
    }

    private boolean is_empty() {
        sqdb=my_db.getWritableDatabase();
        int count=0;
        Cursor c=sqdb.query(DBHelper.TABLE_NAME,
                null, null, null, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast()&&count==0) {
            count++;
            c.moveToNext();
        }
        c.close();
        return (count==0);
    }

   private void go_regist() {
        ContentValues cv=new ContentValues();
        cv.put(my_db.NICKNAME, infa[0]);
        cv.put(my_db.PASS, infa[1]);
        cv.put(my_db.EMAIL, infa[2]);
        cv.put(my_db.PHONE, infa[3]);

        sqdb=my_db.getWritableDatabase();
        sqdb.insert(my_db.TABLE_NAME, null, cv);
        sqdb.close();
        Intent goStart=new Intent(this, home.class);
        startActivity(goStart);
    }

    }


