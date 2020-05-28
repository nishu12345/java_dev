package com.nishant;

public class Main {

    public static void main(String[] args) {
        //a mile is equal to 1.609344 kilometers
        double kilometers = (100 * 1.609344);
        //Expression -> kilometers = (100 * 1.609344)
        //Statement -> double kilometers = (100 * 1.609344);

        int highScore = 50;
        //Expression -> highScore = 50
        //Statement -> int highScore = 50;

        if (highScore == 50) {
            System.out.println("This is an expression");
        }
        //Expression -> highScore == 50, This is an expression
        //Statement -> if (highScore == 50) , System.out.println("This is an expression");
    }
}
