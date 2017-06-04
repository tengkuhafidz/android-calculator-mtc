package com.tengkuhafidz.calculatorbest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int operand1 = 0;
    private int operand2 = 0;
    private String operator = null;
    private TextView textViewCalculatorDisplay;
    private TextView textViewCalculatorButtonClear;
    private TextView textViewCalculatorButtonEquals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCalculatorDisplay = (TextView) findViewById(R.id.text_view_calculator_display);
        textViewCalculatorButtonClear = (TextView) findViewById(R.id.text_view_calculator_button_clear);
        textViewCalculatorButtonEquals = (TextView) findViewById(R.id.text_view_calculator_button_equals);

        textViewCalculatorButtonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetValues();
                updateDisplay();
            }
        });

        textViewCalculatorButtonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = calculate();

                textViewCalculatorDisplay.setText(result);
                resetValues();
                operand1 = Integer.parseInt(result);
            }
        });

    }

    public void onNumberButtonClick(View view) {
        TextView theThingBeingClicked = (TextView) view;
        String textLabel = theThingBeingClicked.getText().toString();


        if (operator == null) {
            if (operand1 == 0) {
                operand1 = Integer.parseInt(textLabel);
            } else {
                String currentOperandText = String.valueOf(operand1);
                currentOperandText = currentOperandText + textLabel;
                operand1 = Integer.parseInt(currentOperandText);
            }
        } else {
            if (operand2 == 0) {
                operand2 = Integer.parseInt(textLabel);
            } else {
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

        if (operator != null) {
            result += operator;
        }

        if (operand2 != 0) {
            result += operand2;
        }

        textViewCalculatorDisplay.setText(String.valueOf(result));
    }

    private void resetValues() {
        operand1 = 0;
        operand2 = 0;
        operator = null;
    }

    private String calculate(){
        String result = null;
        if (operator.equals(getResources().getString(R.string.calculator_button_operator_division))){
            int numResult = operand1 / operand2;
            result = String.valueOf((numResult));
        } else if (operator.equals(getResources().getString(R.string.calculator_button_operator_multiplication))) {
            int numResult = operand1 * operand2;
            result = String.valueOf((numResult));
        } else if (operator.equals(getResources().getString(R.string.calculator_button_operator_addition))) {
            int numResult = operand1 + operand2;
            result = String.valueOf((numResult));
        } else if (operator.equals(getResources().getString(R.string.calculator_button_operator_subtraction))) {
            int numResult = operand1 - operand2;
            result = String.valueOf((numResult));
        }

        return result;
    }

}