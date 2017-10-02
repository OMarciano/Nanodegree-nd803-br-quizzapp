package com.evstarts.androidquizz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final View.OnClickListener submitButton = new View.OnClickListener() {
            public void onClick(final View v){
                check();
                montaTexto = "";

            }
        };



        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButton);


    }
    Button submit;
    int correctAnswers = 0;
    String montaTexto = "";
    boolean question1;
    boolean question2;
    boolean question3;
    boolean question4;

    private void checkQq1() {
        RadioButton radioButtonQ1 = (RadioButton) findViewById(R.id.rbRadioQ13);
        boolean isQuestion1Checked = radioButtonQ1.isChecked();
        if (isQuestion1Checked) {
            correctAnswers += 1;
            question1 = true;
            montaTexto += "Você acertou a questão 1! \n";
            Log.v("MainActivity", "Questão um foi");

        } else {
            montaTexto += "Hmmm... aparentemente você errou a primeira questão!! \n";
        }
    }


    private void checkQq2() {
        RadioButton radioButtonQ2 = (RadioButton) findViewById(R.id.rbRadioQ22);
        boolean isQuestion1Checked = radioButtonQ2.isChecked();
        if (isQuestion1Checked) {
            correctAnswers += 1;
            question2 = true;
            montaTexto += "Você acertou a questão 2! \n";

            Log.v("MainActivity", "Questão dois foi");


        } else {
            montaTexto += "Hmmm... aparentemente você errou a segunda questão!! \n";
        }
    }

    private String getQuestion3UserInput() {
        EditText userInput = (EditText) findViewById(R.id.etQ3);
        String name = userInput.getText().toString();
        return name;
    }

    private String getQuestion4UserInput() {
        EditText userInput = (EditText) findViewById(R.id.etQ4);
        String name = userInput.getText().toString();
        return name;
    }

    private void checkQq3() {
        String checkQuestion = getQuestion3UserInput();
        if (checkQuestion.trim().equalsIgnoreCase("google")) {

            correctAnswers += 1;
            question3 = true;
            montaTexto += "Você acertou a questão 3! \n";

            Log.v("MainActivity", "Questão tres foi");


        }else {
            montaTexto += "Hmmm... aparentemente você errou a terceira questão!! \n";
        }
    }

    private void checkQq4() {
        String checkQuestion = getQuestion4UserInput();
        if (checkQuestion.trim().equalsIgnoreCase("jetbrains")) {
            correctAnswers += 1;
            question4 = true;
            montaTexto += "Você acertou a questão 4! \n";
            Log.v("MainActivity", "Questão quatro foi");


        }else {
            montaTexto += "Hmmm... aparentemente você errou a terceira questão!! \n";
        }
    }


        
        public void check(){
        checkQq1();
        checkQq2();
        checkQq3();
        checkQq4();
        if (question1 && question2 && question3 && question4){
            montaTexto = "Você acertou todas as questões!";

    }
           Toast.makeText(MainActivity.this, montaTexto,
                    Toast.LENGTH_LONG).show();


}
}

