package com.nishant;

public class Main {

    public static void main(String[] args) {
        int sum = 0, count = 0;
        for (int i = 1; i < 1001; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println("Number " + i + " is divided by both 3 and 5");
                count++;
                sum = sum + i;
                if (count == 5) {
                    break;
                }
            }
        }
        System.out.println("Sum of 5 numbers between 1 and 1000 that are divisible by 3 and 5 = " + sum);
    }
}
