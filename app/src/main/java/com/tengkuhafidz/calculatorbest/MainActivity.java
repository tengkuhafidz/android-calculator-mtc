package com.tengkuhafidz.calculatorbest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tengkuhafidz.calculatorbest.models.Calculator;

public class MainActivity extends AppCompatActivity {
    private TextView textViewCalculatorDisplay;
    private TextView textViewCalculatorButtonClear;
    private TextView textViewCalculatorButtonEquals;
    private Calculator calculator = new Calculator();

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
                calculator.clear();
                updateDisplay();
            }
        });

        textViewCalculatorButtonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = String.valueOf(calculator.calculate());

                textViewCalculatorDisplay.setText(result);
                calculator.clear();
                calculator.setOperand1(Integer.parseInt(result));
            }
        });

    }

    public void onNumberButtonClick(View view) {
        TextView theThingBeingClicked = (TextView) view;
        String textLabel = theThingBeingClicked.getText().toString();

        if (calculator.getOperator() == null) {
            if (calculator.getOperand1() == 0) {
                calculator.setOperand1(Integer.parseInt(textLabel));
            } else {
                String currentOperandText = String.valueOf(calculator.getOperand1());
                currentOperandText = currentOperandText + textLabel;
                calculator.setOperand1(Integer.parseInt(currentOperandText));
            }
        } else {
            if (calculator.getOperand2() == 0) {
                calculator.setOperand2(Integer.parseInt(textLabel));
            } else {
                String currentOperandText = String.valueOf(calculator.getOperand2());
                currentOperandText = currentOperandText + textLabel;
                calculator.setOperand2(Integer.parseInt(currentOperandText));
            }
        }

        updateDisplay();

    }

    public void onOperationButtonClick(View view) {
        TextView theThingBeingClicked = (TextView) view;
        calculator.setOperator(theThingBeingClicked.getText().toString());

        updateDisplay();
    }

    private void updateDisplay() {

        String result = String.valueOf(calculator.getOperand1());

        if (calculator.getOperator() != null) {
            result += calculator.getOperator();
        }

        if (calculator.getOperand2() != 0) {
            result += calculator.getOperand2();
        }

        textViewCalculatorDisplay.setText(String.valueOf(result));
    }

}