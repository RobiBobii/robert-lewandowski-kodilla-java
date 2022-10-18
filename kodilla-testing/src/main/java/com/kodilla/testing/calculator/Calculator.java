package com.kodilla.testing.calculator;

public class Calculator {

    private static int sum;
    private static int minus;

    public Calculator(int a, int b) {
        this.sum = a + b;
        this.minus = a - b;
    }

    public static int getSum() {
        return sum;
    }

    public static int getMinus() {
        return minus;
    }

}
