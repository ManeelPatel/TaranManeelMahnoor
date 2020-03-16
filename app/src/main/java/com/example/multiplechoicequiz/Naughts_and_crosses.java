package com.example.multiplechoicequiz;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.TextView;

import android.widget.Toast;

public class Naughts_and_crosses extends AppCompatActivity implements View.OnClickListener {

    private Button [][] buttons = new Button[3] [3];

    private boolean player1Turn= true; // when games starts it is set to player 1 9 (starting)

    private int roundCount; //count the rounds

    private int p1points; //P1 points

    private int p2points;

    private TextView textViewplayer1; // display points for player 1

    private TextView textViewplayer2;

// commit

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textViewplayer1 = findViewById(R.id.text_view_p1);

        textViewplayer2 = findViewById(R.id.text_view_p2);

        for (int i= 0; i<3;i++){

            for (int j =0; j<3; j++){

                String buttonID= "button_" + i + j;

                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());

                buttons [i][j]= findViewById(resID);

                buttons [i][j].setOnClickListener(this);

            }

        }

        Button buttonReset = findViewById(R.id.button_reset);

        buttonReset.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                resetGame();

            }

        });

    }

    @Override

    public void onClick(View view) {

        if (!((Button) view).getText().toString().equals("")) { //! checks that when button is clicked it is empty, if not empty it was used before

            return; //this changes the text of the button to X or O

        }

        if (player1Turn){

            ((Button)view).setText("X");

        }else{

            ((Button)view).setText("O");

        }

        roundCount++;

        if (checkForWin()){

            if (player1Turn){

                player1Wins();

            } else {

                player2Wins();

            }

        }else if(roundCount== 9){

            draw();

        }else {

            player1Turn = !player1Turn;

        }

    }

    private boolean checkForWin(){

        String [][]field = new String [3][3];

        for (int i = 0; i<3; i++){

            for (int j = 0; j<3; j++){

                field[i][j] = buttons [i][j].getText().toString();

            }

        }

        for (int i = 0; i<3; i++){

            if (field[i][0].equals(field[i][1])

                    && field[i][0].equals(field[i][2])

                    && !field[i][0].equals("")){

                return true; //checks to see for potential winner (row)

            }

        }

        for (int i = 0; i<3; i++){

            if (field[0][i].equals(field[1][i])

                    && field[0][i].equals(field[2][i])

                    && !field[0][i].equals("")){

                return true; //checks to see for potential winner(column)

            }

        }

        if (field[0][0].equals(field[1][1])

                && field[0][0].equals(field[2][2])

                && !field[0][0].equals("")){

            return true; //checks for potential winner (diagonal)

        }

        if (field[0][2].equals(field[1][1])

                && field[0][2].equals(field[2][0])

                && !field[0][2].equals("")){

            return true; //checks for potential winner (diagonal)

        }

        return false;

    }

    private void player1Wins() {

        p1points++;

        Toast.makeText(this, "Player 1 is the winnner!", Toast.LENGTH_SHORT).show();

        updatePointsText();

        resetBoard();

    }

    private void player2Wins() {

        p2points++;

        Toast.makeText(this, "Player 2 is the winner!", Toast.LENGTH_SHORT).show();

        updatePointsText();

        resetBoard();

    }

    private void draw() {

        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();

        resetBoard();

    }

    private void updatePointsText() {

        textViewplayer1.setText("Player 1: " + p1points);

        textViewplayer2.setText("Player 2: " + p2points);

    }

    private void resetBoard(){

        for (int i=0 ; i <3; i++){

            for (int j=0; j<3; j++){

                buttons[i][j].setText("");

            }

        }

        roundCount = 0;

        player1Turn = true;

    }

    private void resetGame(){

        p1points = 0;

        p2points = 0;

        updatePointsText();

        resetBoard();

    }

    @Override

    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        outState.putInt("roundCount", roundCount);

        outState.putInt("Player1points", p1points);

        outState.putInt("Player2points", p2points);

        outState.putBoolean("player1Turn", player1Turn);

    }

    @Override

    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        roundCount = savedInstanceState.getInt("RoundCount");

        p1points = savedInstanceState.getInt("Player1Points");

        p2points = savedInstanceState.getInt("Player2Points");

        player1Turn = savedInstanceState.getBoolean("Player1Turn");

    }

}
