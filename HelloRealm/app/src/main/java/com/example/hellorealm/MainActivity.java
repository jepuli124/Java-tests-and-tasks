package com.example.hellorealm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText input1;
    private EditText input2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.numberInput1);
        input2 = findViewById(R.id.numberInput2);
        result = findViewById(R.id.resultOfCalculation);
    }

    public void resultPlus(View view){
        int calculation = Integer.parseInt(input1.getText().toString()) + Integer.parseInt(input2.getText().toString());
        result.setText(String.format(Integer.toString(calculation)));
    }

    public void resultMinus(View view){
        int calculation = Integer.parseInt(input1.getText().toString()) - Integer.parseInt(input2.getText().toString());
        result.setText(String.format(Integer.toString(calculation)));
    }

    public void resultMultiply(View view){
        int calculation = Integer.parseInt(input1.getText().toString()) * Integer.parseInt(input2.getText().toString());
        result.setText(String.format(Integer.toString(calculation)));
    }

    public void resultDivide(View view){
        int calculation = Integer.parseInt(input1.getText().toString()) / Integer.parseInt(input2.getText().toString());
        result.setText(String.format(Integer.toString(calculation)));
    }
}