package com.example.multiplechoicequiz;

public class QuestionLibrary {

    private String nQuestions [] = {
            "I _____ basketball after school yesterday.",
            "We _____ going to Spain for our summer holiday.",
            "I _____ my arm while playing football last week.",
            "I _____ up late this morning."


    };

    private String nChoices [][] = {

            {"Play","Played","Will Play"},
            {"Are","Will","Did"},
            {"Broke","Break","Broken"},
            {"Got","Get","Getting"}
    };

    private String nCorrectAnswers[] = {"Played", "Are" , "Broke" , "Got"};


    public String getQuestion(int a){
        String question = nQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice0 = nChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a){
        String choice1 = nChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a){
        String choice2 = nChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a){
        String answer = nCorrectAnswers[a];
        return answer;

    }
}
