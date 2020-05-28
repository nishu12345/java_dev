package com.nishant;

public class OperatorChallange {

    public static void main(String[] args) {
        double myFirstVariable = 20.00d;
        double mySecondVariable = 80.00d;
        double sumOfBothVariable = myFirstVariable + mySecondVariable;
        double sumMultiplyByHundred = sumOfBothVariable * 100.00d;

        double remainder = sumMultiplyByHundred % 40.00d;
        boolean isRemainderTrue = true;
        if(remainder != 0) {
             isRemainderTrue = false;
        }
        System.out.println("isRemainderTrue = " + isRemainderTrue);
        if(!isRemainderTrue){
            System.out.println("Got some remainder");
        }
    }
}
