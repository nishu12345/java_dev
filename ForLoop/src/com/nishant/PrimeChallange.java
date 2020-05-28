package com.nishant;

public class PrimeChallange {

    public static void main(String[] args) {
        int count = 0;
        for(int i = 100; i < 1000; i++){
            if(isPrime(i)){
                System.out.println("Number " + i + " is a prime number");
                count++;
                if(count == 3 ){
                    System.out.println("Exiting for loop");
                    break;
                }
            }

        }
    }

    private static boolean isPrime(int n){
        if(n == 1){
            return false;
        }

        for(int i = 2; i <= (int)Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
