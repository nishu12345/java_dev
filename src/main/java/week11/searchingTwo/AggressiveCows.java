package week11.searchingTwo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
/*
Farmer John has built a new long barn with N stalls.
Given an array of integers barns of size N where each element of the array represents the location of the stall
and an integer noOfCows which represents the number of cows.
His cows don't like this barn layout and become aggressive towards each other once put into a stall.
To prevent the cows from hurting each other, John wants to assign the cows to the stalls,
such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?

Input ->
        barns = [1,2,3,4,5]
        noOfCows = 3
Output -> 2
Explanation -> John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively.
               So the minimum distance will be 2.
*/
public class AggressiveCows {
    private static final Logger LOGGER = LoggerFactory.getLogger(AggressiveCows.class);

    public static void main(String[] args) {
//        int[] barns = {1,2,3,4,5};
//        int noOfCows = 3;
        int[] barns = {5,17,100,11};
        int noOfCows = 2;
        LOGGER.info("Largest Minimum Distance possible in given input is {}",maxMinDistance(barns,noOfCows));

    }

    public static int maxMinDistance(int[] barns, int noOfCows){
        Arrays.sort(barns);
        int minStalls = 0;
        int maxStalls = (barns[barns.length-1]-barns[0])/(noOfCows-1);
        int ans = -1;
        while(minStalls<=maxStalls){
            int mid = minStalls + (maxStalls-minStalls)/2;
            if(isPossible(mid,barns,noOfCows)){
                ans = mid;
                minStalls = mid+1;
            }else maxStalls = mid-1;
        }
        return ans;
    }

    public static boolean isPossible(int distance, int[] barns, int noOfCows){
        int prev = barns[0];
        int j = 1;
        int k = noOfCows-1;
        while(j<barns.length && k > 0){
            if(barns[j]-prev >= distance){
                k--;
                prev = barns[j];
            }j++;
        }
        return k==0?true:false;
    }


}
