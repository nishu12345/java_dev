package week3.arrays_and_dynamic_arrays;

import java.util.Scanner;
/*
* You are given an integer T (Number of test cases). For each test case, you are given an integer array A and an integer B.
* You have to print the same array after rotating it B times towards right.
* Input:
*  2
*  4 1 2 3 4
*  2
*  3 1 2 4
*  1
* Output:
*  3 4 1 2
*  4 1 2
* Explanation:
* For Test Case 1:
*  [1,2,3,4] => [4,1,2,3] => [3,4,1,2]
* For Test Case 2:
*  [1,2,4] => [4,1,2]
* */
public class RotationGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputCount = scanner.nextInt();
        while(inputCount > 0){
            int length = scanner.nextInt();
            int[] input = new int[length];
            for(int i = 0; i < length; i++){
                input[i] = scanner.nextInt();
            }
            int rotationValue = scanner.nextInt();
            rotateArray(input,length,rotationValue%length);
            for(int num : input){
                System.out.print(num + " ");
            }
            System.out.println();
            --inputCount;
        }
    }

    private static int[] rotateArray(int[] input, int length, int rotationValue){
        reverseArray(input,0,length-1);
        reverseArray(input,0,rotationValue-1);
        reverseArray(input,rotationValue,length-1);
        return input;

    }

    private static int[] reverseArray(int[] input, int start, int end){
        int limit = start + ((end+1)-start)/2;
        for(int i = start; i < limit; i++){
            input[i] = input[i] + input[end];
            input[end] = input[i] - input[end];
            input[i] = input[i] - input[end];
            --end;
        }
        return input;
    }
}
