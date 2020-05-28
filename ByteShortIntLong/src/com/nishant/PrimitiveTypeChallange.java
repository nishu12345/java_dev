package com.nishant;

public class PrimitiveTypeChallange {

    public static void main(String[] args) {
        byte myByteNumber = 10;
        short myShortNumber = 20;
        int myIntegerNumber = 50;

        int myLongTotal = 50_000 + 10 * (myByteNumber + myShortNumber + myIntegerNumber);

        System.out.println("My Long Total = " + myLongTotal);
    }
}
