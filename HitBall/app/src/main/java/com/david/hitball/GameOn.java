package com.david.hitball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GameOn extends AppCompatActivity {

    private BallTable ballTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_game_on);
        ballTable = new BallTable(this);

        setContentView(ballTable);
    }
}