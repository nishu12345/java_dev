package com.nishant;

public class Main {

    public static void main(String[] args) {
        char myChar = 'D';
        char myUnicodeChar = '\u0044';
        int myCharInteger = (int) myUnicodeChar;
        System.out.println("My Char = " + myChar);
        System.out.println("My Unicode Char = " + myUnicodeChar);
        System.out.println("My Integer Character = " + myCharInteger);
        char myCopyrightChar = '\u00A9';
        System.out.println("My Copyright Character = " + myCopyrightChar);
        System.out.println("Character Max Value = " + Character.MAX_VALUE);
        System.out.println("Character Min Value = " + Character.MIN_VALUE);
        boolean isCustomerOverTwentyOne = true;

    }
}