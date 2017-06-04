package com.tengkuhafidz.calculatorbest.models;

/**
 * Created by tengkuhafidz on 4/6/17.
 */

public class Calculator {
    private Integer operand1;
    private Integer operand2;
    private String operator;

    public Calculator (){
        operand1 = 0;
        operand2 = 0;
        operator = null;
    }

    public Integer calculate(){
        Integer result = 0;
        if (operator.equals("\u00f7")){
            result = operand1 / operand2;
        } else if (operator.equals("x")) {
            result = operand1 * operand2;
        } else if (operator.equals("+")) {
            result = operand1 + operand2;
        } else if (operator.equals("-")) {
            result = operand1 - operand2;
        }
        return result;
    }

    public void clear(){
        operand1 = 0;
        operand2 = 0;
        operator = null;
    }

    public Integer getOperand1() {
        return operand1;
    }

    public Integer getOperand2() {
        return operand2;
    }

    public void setOperand1(Integer operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(Integer operand2) {
        this.operand2 = operand2;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
