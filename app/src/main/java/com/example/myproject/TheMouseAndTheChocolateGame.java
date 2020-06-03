package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TheMouseAndTheChocolateGame extends AppCompatActivity implements View.OnClickListener{

    String player = "X";
    String line , raw;
    //int N = 10;
    //Button[][] btns=new Button[N][N];
    Button[][] btns;
    GridLayout boardGL;
    int btnWidth=100, btnHeight=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_mouse_and_the_chocolate_game);

        Intent takeIt = getIntent();
        line = takeIt.getStringExtra("line");
        raw = takeIt.getStringExtra("raw");
        Toast.makeText(this, line + "  " + raw, Toast.LENGTH_SHORT).show();

        boardGL= (GridLayout) findViewById(R.id.GRLT);
        boardGL.setColumnCount(Integer.parseInt(raw));
        build_board(Integer.parseInt(line), Integer.parseInt(raw));
    }

    private void build_board(int line, int raw) {
        btns=new Button[line][raw];
        int k=0;
        for(int i=0; i<btns.length; i++)
            for( int j=0; j<btns[i].length; j++)  {
                btns[i][j] = new Button(boardGL.getContext());
                boardGL.addView(btns[i][j],btnWidth,btnHeight);
                //btns[i][j].setText("" + (k+1));
                btns[i][j].setText("");
                btns[i][j].setPadding(10, 10, 10, 10);
                //btns[i][j].setId((k+1));
                btns[i][j].setId(i*10 + j);
                btns[i][j].setOnClickListener(this);
                k++;
            }
    }

    @Override
    public void onClick(View v) {

        int x = (v.getId()) / 10;
        int y = (v.getId()) % 10;
        //Toast.makeText(this, "x="+x+" y="+y, Toast.LENGTH_SHORT).show();
        if (((Button) v).getText().toString() != "X" && ((Button) v).getText().toString() != "O") {
            if (x == Integer.parseInt(line) - 1 && y == 0) {
                Toast.makeText(this, player + " LOSE!!!", Toast.LENGTH_SHORT).show();
                return;
            }
            for (int i = 0; i <= x; i++)
                for (int j = y; j < btns[i].length; j++)
                    //if (btns[i][j].getText() == "")
                    btns[i][j].setText(player);
            if (player == "X")
                player = "O";
            else
                player = "X";
        }
        else
            Toast.makeText(this, "oops...", Toast.LENGTH_SHORT).show();
    }

}