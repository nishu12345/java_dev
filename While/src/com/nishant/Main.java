package com.nishant;

public class Main {

    public static void main(String[] args) {
        int count = 1;
        while (count != 6) {
            System.out.println("Count value is " + count);
            count++;
        }
        count = 1;
        while (true) {
            if (count != 6) {
                System.out.println("Count value is " + count);
                count++;
                if (count == 3)
                    continue;
                System.out.println("After Continue");
            } else {
                break;
            }

        }

        count = 6;
        do {
            System.out.println("Count value was " + count);
            count++;
            if (count > 100) {
                break;
            }
        } while (count != 6);

        System.out.println("Is number 50 even ? " + isEvenNumber(50));
        System.out.println("Is number 25 even ? " + isEvenNumber(25));
        System.out.println("Is number 0 even ? " + isEvenNumber(0));

        int number = 4;
        int finishNumber = 20;
        int evenNumberCount = 0;
        while(number <= finishNumber){
            number++;
            if(!isEvenNumber(number)){
                continue;
            }

            evenNumberCount++;
            if(evenNumberCount == 5){
                break;
            }
        }
        System.out.println("Total Even number = " + evenNumberCount);
    }

    private static boolean isEvenNumber(int n){
        return n != 0 && n % 2 == 0;
    }

}
