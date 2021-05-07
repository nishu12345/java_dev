package week6.problem_solving_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
    Given an one-dimensional integer array A of size N and an integer B.
    Count all distinct pairs with difference equal to B.
    Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.
    Input->
        [8,12,16,4,0,20]
    Output->
        5
    Explanation->
         There are 5 unique pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20}
*/
public class PairsWithGivenDifference {
    private static final Logger LOGGER = LoggerFactory.getLogger(PairsWithGivenDifference.class);

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(8);
        input.add(12);
        input.add(16);
        input.add(4);
        input.add(0);
        input.add(20);

        int totalPairsWithGivenDifference = pairsCountWithGivenDifference(input, 4);
        LOGGER.info("Total Unique Pairs With given difference in input array is {}", totalPairsWithGivenDifference);
    }

    public static int pairsCountWithGivenDifference(ArrayList<Integer> input, int difference) {
        Map<Integer, Integer> hashed = new HashMap<>();
        for (Integer num : input) {
            if (hashed.containsKey(num))
                hashed.put(num, hashed.get(num) + 1);
            else
                hashed.put(num, 1);
        }
        Map<ArrayList<Integer>, Boolean> output = new HashMap<>();
        if (difference == 0) {
            for (Integer num : input) {
                if (hashed.get(num) > 1) {
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(num);
                    pair.add(num);
                    output.put(pair, true);
                }
            }
        } else {
            for (Integer num : input) {
                int sum = difference + num;
                if (hashed.containsKey(sum)) {
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(num);
                    pair.add(sum);
                    output.put(pair, true);
                }
            }
        }
        return output.size();
    }
}
