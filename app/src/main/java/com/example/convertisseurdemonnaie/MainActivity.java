package com.example.convertisseurdemonnaie;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public abstract class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RadioButton bt1, bt2;
    Button bt3;
    TextView T , t;
    EditText E;
    double USD = 3.14;
    double DINART = 1 / USD;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = findViewById(R.id.b1);
        bt2 = findViewById(R.id.b2);
        bt3 = findViewById(R.id.b3);
        T = findViewById(R.id.TV);
        E = findViewById(R.id.edit);
        bt3.setOnClickListener(this) ;}
    @Override
    public void onClick(View view) {
        String input = E.getText().toString();
        if (input.isEmpty()) {
            String msg="veuillez entrer un montant que vous voulez la convertir !";
            Toast.makeText(getApplicationContext() ,msg,Toast.LENGTH_SHORT).show();

        } else {
            double money = Double.parseDouble(input);
            result=0;
            if (bt1.isChecked()) {
                result = money * USD;
                T.setText("resultat: " + result);
            } else if (bt2.isChecked()) {
                result = money * DINART;
                T.setText("resultat: " + result);
            } else {
                Toast.makeText(getApplicationContext() ,"séléctionner la conversion que vous voulez l'efféctuer ", Toast.LENGTH_LONG).show();
            }

        }
    }
}