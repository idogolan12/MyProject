package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    public static String USER = "";
    public static String PASS = "";

    SQLiteDatabase sqdb;
    DBHelper my_db;
    Button btnGolog;
    EditText etNickLog, etPassLog;
    String[] infa=new String[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        my_db=new DBHelper(this);
        sqdb=my_db.getWritableDatabase();
        sqdb.close();

        btnGolog= (Button) findViewById(R.id.btnGolog);
        btnGolog.setOnClickListener(this);
        etNickLog= (EditText) findViewById(R.id.etNickLog);
        etPassLog= (EditText) findViewById(R.id.etPassLog);
    }
    public void reg(View view) {
        Intent go = new Intent(this,register.class);
        startActivity(go);
    }

    @Override
    public void onClick(View view) {
        infa[0] = etNickLog.getText().toString();
        infa[1] = etPassLog.getText().toString();
        if (infa[0].isEmpty() && infa[1].isEmpty()) {
            Toast.makeText(this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
        }
          else if (infa[0].isEmpty()) {
            etNickLog.setError("Please enter your username");
            etNickLog.requestFocus();
        } else if (infa[1].isEmpty()) {
            etPassLog.setError("Please enter your password");
            etPassLog.requestFocus();
        }
        etNickLog.setText("");
        etPassLog.setText("");
        if (!infa[0].isEmpty() && !infa[1].isEmpty()) {
            if (is_found(infa[0], infa[1])) {
                Toast.makeText(this,
                        "Ok",
                        Toast.LENGTH_LONG).show();
                USER = infa[0];
                PASS = infa[1];
                Intent goStart = new Intent(this, home.class);
                startActivity(goStart);
            } else {
                Toast.makeText(this, "The username or password is incorrect" + "\n" + "Please check if you already have a user", Toast.LENGTH_SHORT).show();
            }
        }
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
}