package com.tengkuhafidz.calculatorbest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.LoggingMXBean;

public class MainActivity extends AppCompatActivity {
    private int operand1 = 0;
    private int operand2 = 0;
    private String operator = null;
    private TextView textViewCalculatorDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCalculatorDisplay = (TextView) findViewById(R.id.text_view_calculator_display);
    }

    public void onNumberButtonClick(View view) {
        TextView theThingBeingClicked = (TextView) view;
        String textLabel = theThingBeingClicked.getText().toString();


        if (operator == null) {
            if(operand1 == 0){
                operand1 = Integer.parseInt(textLabel);
            } else{
                String currentOperandText = String.valueOf(operand1);
                currentOperandText = currentOperandText + textLabel;
                operand1 = Integer.parseInt(currentOperandText);
            }
        } else {
            if(operand2 == 0){
                operand2 = Integer.parseInt(textLabel);
            } else{
                String currentOperandText = String.valueOf(operand2);
                currentOperandText = currentOperandText + textLabel;
                operand2 = Integer.parseInt(currentOperandText);
            }
        }

        updateDisplay();

        Toast.makeText(this, textLabel, Toast.LENGTH_SHORT).show();
    }

    public void onOperationButtonClick(View view) {
        TextView theThingBeingClicked = (TextView) view;
        operator = theThingBeingClicked.getText().toString();

        updateDisplay();

        Toast.makeText(this, operator, Toast.LENGTH_SHORT).show();
    }

    private void updateDisplay() {

        String result = String.valueOf(operand1);

        if(operator != null) {
            result += operator;
        }

        if(operand2 != 0){
            result += operand2;
        }

        textViewCalculatorDisplay.setText(String.valueOf(result));
    }
}