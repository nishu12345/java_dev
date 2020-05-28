package com.nishant;

public class MethodOverloadingChallange {

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        //one foot = 12inches
        //one inch = 2.54cm
        if (feet >= 0 && (inches >= 0 && inches <= 12)) {
            double centimeters = feet * 12 * 2.54;
            centimeters += inches * 2.54;
            System.out.println(feet + " feet, " + inches + " inches = " + centimeters + " cm");
            return centimeters;
        }
        return -1;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches >= 0) {
            double feet = (int) inches / 12;
            double remainingInch = inches % 12;
            calcFeetAndInchesToCentimeters(feet, remainingInch);
            return feet;
        }
        return -1;
    }

    public static void main(String[] args) {
        double result = calcFeetAndInchesToCentimeters(0, 12);
        result = calcFeetAndInchesToCentimeters(12);
        if (result < 0) {
            System.out.println("Invalid Parameters");
        }
    }
}
