package com.kodilla.testing.calculator;

import com.kodilla.testing.calculator.Calculator;

import java.util.Objects;

public class TestingMain1 {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(4,5);

        int result = Calculator.getSum();
        int resultMinus = Calculator.getMinus();

        if (result == 4 + 5) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        if (resultMinus == -1) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
    }
}