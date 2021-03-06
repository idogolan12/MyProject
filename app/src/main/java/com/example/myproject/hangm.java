package com.example.myproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class hangm extends AppCompatActivity implements View.OnClickListener {
    int aa = 0;
    Intent go;
    int mistake , score = 0;
    String av;
    int grade = 0;
    Button bt8 , bt9;
    GridLayout BGT;
    LinearLayout LLLet;
    int btnWidth = 100, btnHeight = 100;
    String a = "כיטחזוהדגבאתשרקצפעסנמלץףךןם"; //FOR ENGLISH
    //String a = "אבגדהוזחטיכלמנסעפצקרשתךףץםן"; //FOR HEBREW
    int G = a.length();
    Button[] bt = new Button[G];
    TextView[] tv;
    ArrayList<String> words = new ArrayList<>();
    int[] IVS = {R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g}; //todo עשינו שימוש במערך של מזהי התמונות
    ImageView IV;
    InputStream is;
    InputStreamReader isr;
    BufferedReader br;
    String st;
    int size;
    int counter = 0;
    String wordesType;
    int[] files = {R.raw.animals, R.raw.countries,R.raw.israelcities}; //todo עשינו שימוש במערך של מזהי הקבצים

    @Override
    protected void onCreate(Bundle savedInstanceState) { //todo: הפעולה מחברת את הרכיבים למשתנים, מקבלת באינטנט קליטה את המידע מהאקטיביטי הקודם המציין את הנושא שנבחר למשחק ומכניסה אותו לרכיב וורדסטייפ מסוג סטרינג, מזמנת את הפעולה לבניית משחק, מזמנת פעולה שבונה לו של כפתורים וכל כפתור מייצג אות לפי סדר האלף בית
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangm);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);
        BGT = findViewById(R.id.BGT);
        IV = findViewById(R.id.iv);
        Intent i = getIntent();
        wordesType = i.getStringExtra("wordesType");
        BGT.setColumnCount(11);
        //IV.getBackground().setAlpha(64);
        newGame();
        Build_board2();
        Toast.makeText(this, "Hello " + LoginActivity.USER, Toast.LENGTH_SHORT).show();
    }



    private void newGame() { //todo: הפעולה יודעת מאיזה קובץ לקרוא את המילים על פי המידע שנמצא ברכיב וורדסטייפ, היא מגרילה מילה מתוך הקובץ שנבחר, מגדירה את מספר האותיות במילה לגודל מערך מסוג טקסטוויו וקוראת לפעולה בורד1 ומעבירה אליה את מספר האותיות ואת המילה
        counter = 0;
        LLLet = findViewById(R.id.LLLet);
        //is = getResources().openRawResource(files[wordesType]);
        if (wordesType.equals("a"))
            is = getResources().openRawResource(files[0]);
        if (wordesType.equals("b"))
            is = getResources().openRawResource(files[1]);
        if (wordesType.equals("c"))
            is = getResources().openRawResource(files[2]);
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
        LLLet.removeAllViews();
        while (true) {
            try {
                if (!((st = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            words.add(st);
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        size = words.size();
        int num = (int) ((size * Math.random()));
        tv = new TextView[words.get(num).length()];
        Build_board1(words.get(num).length() , words.get(num));
        av = words.get(num);
    }


    private void Build_board1(int NumLet , String st1) { //todo הפעולה יוצרת רכיבי טקסטוויו לפי מספר האותיות במילה שהוגרלה
        //LLLet.clear...
        for (int i = 0; i < NumLet; i++) {
            tv[i] = new TextView(LLLet.getContext());
            LLLet.addView(tv[i], btnWidth, btnHeight);
            tv[i].setGravity(Gravity.CENTER);
            tv[i].setText("____");
            if (st1.charAt(i) == ' ') {
                tv[i].setVisibility(View.INVISIBLE);
                counter=1;
            }
        }
    }

    private void Build_board2() { //TODO הפעולה יוצרת לוח של כפתורים באורך ה-א ב ועליהם רשום את אותיות האלף בית לפי הסדר
        //BGT.clear...
        for (int i = 0; i < bt.length; i++) {
            bt[i] = new Button(BGT.getContext());
            BGT.addView(bt[i], btnHeight, btnWidth);
            String ab = a.charAt(i) + "";
            bt[i].setText(ab);
            bt[i].setOnClickListener(this);
            bt[i].setBackgroundColor(0xFFFFFFF9);
            bt[i].getBackground().setAlpha(64);

        }

    }

    @Override
    public void onClick(View v) { //TODO הפעולה בהתחלה בודקת האם הצלחת לנחש אות הנמצאת במילה כל פעם שהצלחת לנחש אות היא מכניסה את האות לטקסוויו המתאים וצובעת את הלחצן המייצג את האות בצבע ירוק והיא סופרת את כמות הפעמים שהצלחת לנחש אות, וכל פעם שלא הצלחת לנחש אות היא צובעת את הלחצן המייצג את המילה בצבע אדום ומחליפה את התמונה הנתונה במשחק לתמונה הבאה וסופאת את כמות הטעויות, אם כמות ההצלחות שווה לאורך המילה אז היא סופרת את כמות הפעמים שהצלחת לנחש את כל המילה,פותחת תיבת דו שיח ושואלת אותך האם אתה רוצה להמשיך למילה הבאה או לצאת מהמשחק אם אתה יוצא מהמשחק אז היא מזמנת  את הפעולה "עדכוןציון" אם אתה מחליט להמשיך לשחק אז היא משאיקה את מספר הטעויות שטעית, את התמונה, ומזמנת את הפעולה "משחקחדש", אם לא הצלחת לנחש את המילה וטעית יותר פעמים ממה שהיה מותר לטעות היא פותחת תיבת דו שיח ושואלת אותך האם אתה רוצה לצאת מהשחק לגמרי , לצאת לבחר נושאים אחרים לשחק בהם או להמשיך לשחק באותו נושא ואחרי שבחרת את מה שאתה רוצה היא לוקחת את הציון האחרון שלך ומזמנת את הפעולה "מעדכןציון".כ
        String a = ((Button) v).getText().toString();
        if (v.getId() != R.id.bt1)
        {
            if (av.indexOf(((Button) v).getText().toString()) != -1) {
                for (int i = 0; i < av.length(); i++) {
                    if (((Button) v).getText().equals(av.charAt(i) + "")) {
                        tv[av.length() - i -1].setText(((Button) v).getText());//FOR ENGLISH
                        //tv[i].setText(((Button) v).getText()); //FOR HEBREW
                        v.setBackgroundColor(0xFF00FF00);
                        v.setId(R.id.bt1);
                        counter++;
                        if (counter == av.length()) {
                            score++;
                            grade++;
                            bt9.setText(score + "");
                            AlertDialog.Builder ads = new AlertDialog.Builder(this);
                            ads.setTitle("כל הכבוד!                                              ");
                            ads.setMessage("הצלחת לנחש את המילה" + " " + "*" + av + "*" + "\n" + "מה ברצונך לעשות?");
                            ads.setPositiveButton("להמשיך", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    for (int i = 0 ; i < bt.length; i++)
                                    {
                                        bt[i].setBackgroundColor(0xFFFFFFF9);
                                        bt[i].getBackground().setAlpha(64);
                                        bt[i].setId(R.id.bt2);

                                    }
                                    newGame();
                                }
                            });
                            ads.setNegativeButton("לצאת", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    UpdateGrade(grade);
                                    go = new Intent(getApplicationContext(),home.class);
                                    startActivity(go);
                                }
                            });

                            AlertDialog ad = ads.create();
                            ad.show();
                        }


                    }


                }
            }
            else
            {
                if (aa < 5)
                {
                    IV.setImageResource(IVS[aa]);
                    aa++;
                    mistake = Integer.parseInt(bt8.getText().toString()) - 1 ;
                    bt8.setText(mistake + "");
                    //Toast.makeText(this, "dosen't exist", Toast.LENGTH_SHORT).show();
                    v.setBackgroundColor(0xFFFF0000);
                    v.setId(R.id.bt1);
                }
                else
                {
                    mistake = Integer.parseInt(bt8.getText().toString()) - 1 ;
                    bt8.setText(mistake + "");
                    IV.setImageResource(IVS[aa]);
                    finishGame();
                }
            }
        }
    }

    private void UpdateGrade(int grade) {
        //Toast.makeText(hangm.this, "grade: " + grade, Toast.LENGTH_SHORT).show();
        DBHelper hlp = new DBHelper(this);;
        SQLiteDatabase db = hlp.getWritableDatabase();
        ContentValues cv = new ContentValues();

        String whereFind=DBHelper.NICKNAME+"=? AND "+DBHelper.PASS+"=?";
        String[] whatFind=new String[] {LoginActivity.USER, LoginActivity.PASS};

        Cursor c = db.query(DBHelper.TABLE_NAME2, null, whereFind, whatFind, null,null,null);
        c.moveToFirst(); //?
        String oldGrade = "";
        if (wordesType.equals("b"))
        {
            oldGrade = c.getString(c.getColumnIndex(DBHelper.SUBJECTS[0]));
            if (grade > Integer.parseInt(oldGrade))
            {
                cv.put(DBHelper.SUBJECTS[0], "" + grade);
                db.update(DBHelper.TABLE_NAME2, cv, whereFind, whatFind);
                db.close();
            }
        }
        if (wordesType.equals("c"))
        {
            oldGrade = c.getString(c.getColumnIndex(DBHelper.SUBJECTS[1]));
            if (grade > Integer.parseInt(oldGrade) )
            {
                cv.put(DBHelper.SUBJECTS[1], "" + grade);
                db.update(DBHelper.TABLE_NAME2, cv, whereFind, whatFind);
                db.close();
            }
        }
        if (wordesType.equals("a"))
        {
            oldGrade = c.getString(c.getColumnIndex(DBHelper.SUBJECTS[2]));
            if(grade > Integer.parseInt(oldGrade))
            {
                cv.put(DBHelper.SUBJECTS[2], "" + grade);
                db.update(DBHelper.TABLE_NAME2, cv, whereFind, whatFind);
                db.close();
            }
        }
    }


    private void finishGame()
    {
        //Toast.makeText(this, "finish game", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle( "לא הצלחת לנחש את המילה והפסדת:(      "  );
        adb.setMessage("המילה הייתה" + " " + "*" + av + "*" + " " + "מה תרצה לעשות?");
        adb.setPositiveButton("לשחק שוב באותו נושא", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                UpdateGrade(grade);
                go = new Intent(getApplicationContext(),hangm.class);
                go.putExtra("wordesType",wordesType.toString());
                startActivity(go);
            }
        });
        adb.setNeutralButton("משחקי איש תלוי בנושאים אחרים", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                UpdateGrade(grade);
                go = new Intent(getApplicationContext(), sbchangman.class);
                startActivity(go);


            }
        });
        adb.setNegativeButton("לצאת", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                UpdateGrade(grade);
                go = new Intent(getApplicationContext(),home.class);
                startActivity(go);
            }
        });


        AlertDialog ad = adb.create();
        ad.show();
    }
}
