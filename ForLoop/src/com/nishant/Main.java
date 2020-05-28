package com.nishant;

public class Main {

    public static void main(String[] args) {
        for (int i = 2; i <= 8; i++) {
            System.out.println("10,000 at " + i + "% interest = " + String.format("%.2f", calculateInterest(10000.0, i)));
        }

        for (int i = 8; i >= 2; i--) {
            System.out.println("10,000 at " + i + "% interest = " + String.format("%.2f", calculateInterest(10000.0, i)));
        }

    }

    public static double calculateInterest(double amount, double interestValue) {
        return (amount * (interestValue / 100));
    }
}
