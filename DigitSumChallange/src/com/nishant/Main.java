package com.nishant;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        System.out.println("The sum of the digits in number 125 is " +sumDigit.apply(125));
        System.out.println("The sum of the digits in number -125 is " +sumDigit.apply(-125));
        System.out.println("The sum of the digits in number 4 is " +sumDigit.apply(4));
        System.out.println("The sum of the digits in number 32123 is " +sumDigit.apply(32123));
    }

    private static Function<Integer, Integer> sumDigit = n -> {
        int sum = 0;
        if (n > 9) {
            int remainder;
            while (n > 0) {
                remainder = n % 10;
                sum += remainder;
                n = n / 10;
            }
        } else {
            sum = -1;
        }
        return sum;
    };
}
