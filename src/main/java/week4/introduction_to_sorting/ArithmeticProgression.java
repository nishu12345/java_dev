package week4.introduction_to_sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/*
    Given an integer array A of size N. Return 1 if the array can be rearranged to form an arithmetic progression, otherwise, return 0.
    A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
    Input->
        A = [3, 5, 1]
    Output->
        1
    Explanation->
         We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.

*/
public class ArithmeticProgression {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArithmeticProgression.class);

    public static void main(String[] args) {
        int isArithmeticMean = checkArithmeticProgression(new int[]{3, 5, 1});
        LOGGER.info("Is [3,5,1] arithmetic mean {}",isArithmeticMean);
    }

    public static int checkArithmeticProgression(int[] input){
        Map<Integer,Boolean> hashed = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MIN_VALUE;
        for(int num : input){
            if(hashed.containsKey(num))
                return 0;
            else hashed.put(num,true);
            if(num < min){
                secondMin = min;
                min = num;
            }else if(num < secondMin)
                secondMin = num;
        }
        int d = secondMin - min;
        for(int i = 0; i < input.length; ++i){
            int element = min + (i*d);
            if(!hashed.containsKey(element))
                return 0;
        }
        return 1;
    }
}
