package com.evstarts.androidquizz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
    boolean question5;

    //TODO: Checar a resposta da questão 1 e caso esteja correto adicionar a resposta no montaTexto
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

    //TODO: Checar a resposta da questão 2 e caso esteja correto adicionar a resposta no montaTexto
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

    //TODO: Receber a entrada de usuario e converter em string, retorna o valor adicionado
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

    //TODO: checa que o usuario escreveu Google
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

        //// TODO: Checa se o usuario escreveu JetBrains
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

    //TODO: Verifica se a checkbox correta foi selecionada
    private void checkQq5(){
        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox);
        CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);

        boolean cb1isChecked = cb1.isChecked();
        boolean cb2isChecked = cb2.isChecked();
        boolean cb3isChecked = cb3.isChecked();

        if (cb1isChecked || cb2isChecked){
            montaTexto += "Hmmm... aparentemente você errou a terceira questão!! \n";
        }else if(cb3isChecked){
            question5 = true;
            correctAnswers += 1;
            montaTexto += "Você acertou a questão 5! \n";
            Log.v("MainActivity", "Questão quatro foi");
        }

    }
        //TODO: Verifica se o usuario acertou as questões e monta o texto/toast
        public void check(){
        checkQq1();
        checkQq2();
        checkQq3();
        checkQq4();
        checkQq5();
        if (question1 && question2 && question3 && question4 && question5){
            montaTexto = "Você acertou todas as questões!";




        }
           Toast.makeText(MainActivity.this, montaTexto,
                    Toast.LENGTH_LONG).show();

            question1 = false;
            question2 = false;
            question3 = false;
            question4 = false;
            question5 = false;

}
}

