package com.nishant;

public class Main {

    public static void main(String[] args) {
        int myIntMinValue = Integer.MIN_VALUE;
        int myIntMaxValue = Integer.MAX_VALUE;
        System.out.println("Integer Minimum Value = " + myIntMinValue);
        System.out.println("Integer Maximum Value = " + myIntMaxValue);
        System.out.println("Busted Integer Minimum Value = " + (myIntMinValue - 2));
        System.out.println("Busted Integer Maximum Value = " + (myIntMaxValue + 2));

        int myMaxIntReadable = 2_14_74_83_647;

        byte myByteMinValue = Byte.MIN_VALUE;
        byte myByteMaxValue = Byte.MAX_VALUE;
        System.out.println("Byte Minimum Value = " + myByteMinValue);
        System.out.println("Byte Maximum Value = " + myByteMaxValue);
        System.out.println("Busted Byte Minimum Value = " + (byte)(myByteMinValue -1));
        System.out.println("Busted Byte Maximum Value = " + (byte)(myByteMaxValue +1));


        short myShortMinValue = Short.MIN_VALUE;
        short myShortMaxValue = Short.MAX_VALUE;
        System.out.println("Short Minimum Value = " + myShortMinValue);
        System.out.println("Short Maximum Value = " + myShortMaxValue);
        System.out.println("Busted Short Minimum Value = " + (short)(myShortMinValue -1));
        System.out.println("Busted Short Maximum Value = " + (short)(myShortMaxValue +1));
        short sumOfShort = (short) (myShortMaxValue + myShortMinValue);
        short shortTwo = 2;
        short divideOfShort = (short)(myShortMaxValue/shortTwo);
        System.out.println("Sum of Short = " + sumOfShort);

        long myLongMinValue = Long.MIN_VALUE;
        long myLongMaxValue = Long.MAX_VALUE;
        System.out.println("Long Minimum Value = " + myLongMinValue);
        System.out.println("Long Maximum Value = " + myLongMaxValue);
        System.out.println("Busted Long Minimum Value = " + (long)(myLongMinValue -1));
        System.out.println("Busted Long Maximum Value = " + (long)(myLongMaxValue +1));
    }
}
