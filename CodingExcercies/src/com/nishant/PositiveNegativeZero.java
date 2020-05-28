package com.nishant;

public class PositiveNegativeZero {

    public static void main(String[] args) {
    checkNumber(5);
    checkNumber(-5);
    }

    public static void checkNumber(int number){
        if(number > 0){
            //positive number
            System.out.println("positive");
        }else if(number < 0){
            //negative number
            System.out.println("negative");
        }else{
            System.out.println("zero");
        }
    }
}
