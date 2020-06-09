package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class sbchangman extends AppCompatActivity {
    Intent go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sbchangman);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //todo פעולה לבניית תפריט העושה שימוש בקובץ xml
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { //todo פעולה להפעלת תפריט בהתאם לבחירת רכיב בתפריט
        switch (item.getItemId()) //todo זיהוי הרכיב מתבצע ע"י המזהה id של כל רכיב
        {
            case R.id.credit:
                 go = new Intent(this,credit.class);
                 startActivity(go);
            case R.id.guide:
                 go = new Intent(this,guide.class);
                startActivity(go);
            case R.id.achievements:
                go = new Intent(this,achievements.class);
                startActivity(go);

        }
        return super.onOptionsItemSelected(item);

    }

    public void ams(View view) { //todo on click
        go = new Intent(this,hangm.class);
        go.putExtra("wordesType","a"); //todo מעבר לאקטיביטי כולל העברת מידע המציין את הנושא שנבחר
        startActivity(go);
    }

    public void cny(View view) {
        go = new Intent(this,hangm.class);
        go.putExtra("wordesType","b");
        startActivity(go);
    }

    public void cts(View view) {
        go = new Intent(this,hangm.class);
        go.putExtra("wordesType","c");
        startActivity(go);
    }


}
