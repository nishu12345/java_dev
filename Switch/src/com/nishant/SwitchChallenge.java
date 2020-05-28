package com.nishant;

public class SwitchChallenge {

    public static void main(String[] args) {
        char myCharValue = 'D';
        switch (myCharValue){
            case 'A':
                System.out.println("Character A is found");
                break;
            case 'B':
                System.out.println("Character B is found");
                break;
            case 'C': case 'D': case 'E':
                System.out.println("Character " + myCharValue +" is found");
                break;
            default:
                System.out.println("Character is not A, B, C, D or E");
                break;
        }

        String month = "January";
        switch (month.toLowerCase()){
            case "january":
                System.out.println("Jan");
                break;
            case "june":
                System.out.println("Jun");
                break;
            default:
                System.out.println("Not sure");
        }
    }
}
