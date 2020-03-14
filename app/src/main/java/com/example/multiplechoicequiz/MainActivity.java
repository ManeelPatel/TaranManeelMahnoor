package com.example.multiplechoicequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private QuestionLibrary nQuestionsLibrary = new QuestionLibrary();

    private TextView nScoreView;
    private TextView nQuestionView;
    private Button nButtonChoice1;
    private Button nButtonChoice2;
    private Button nButtonChoice3;

    private String nAnswer;
    private int nScore = 0;
    private int nQuestionsNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nScoreView = (TextView)findViewById(R.id.score);
        nQuestionView = (TextView)findViewById(R.id.question);
        nButtonChoice1 = (Button) findViewById(R.id.choice1);
        nButtonChoice2 = (Button) findViewById(R.id.choice2);
        nButtonChoice3 = (Button) findViewById(R.id.choice3);

        updateQuestion();


        nButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if (nButtonChoice1.getText() == nAnswer){
                    nScore = nScore +1;
                    updateScore(nScore);
                    updateQuestion();
                    Toast.makeText(MainActivity.this,"Correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this,"Wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        nButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if (nButtonChoice2.getText() == nAnswer){
                    nScore = nScore +1;
                    updateScore(nScore);
                    updateQuestion();
                    Toast.makeText(MainActivity.this,"Correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this,"Wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });


        nButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if (nButtonChoice3.getText() == nAnswer){
                    nScore = nScore +1;
                    updateScore(nScore);
                    updateQuestion();
                    Toast.makeText(MainActivity.this,"Correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this,"Wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });


    }

    private void updateQuestion(){
        nQuestionView.setText(nQuestionsLibrary.getQuestion(nQuestionsNumber));
        nButtonChoice1.setText(nQuestionsLibrary.getChoice1(nQuestionsNumber));
        nButtonChoice2.setText(nQuestionsLibrary.getChoice2(nQuestionsNumber));
        nButtonChoice3.setText(nQuestionsLibrary.getChoice3(nQuestionsNumber));

        nAnswer = nQuestionsLibrary.getCorrectAnswer(nQuestionsNumber);
        nQuestionsNumber++;
    }

    private void updateScore (int point) {
        nScoreView.setText("" + nScore);
    }
}
