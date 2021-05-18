package week7.basic_math_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
    Since the answer may be large, return the answer modulo (109 + 7).
    Input->
        [5,17,100,11]
        b = 28
    Output->
        1
    Explanation->
        [17,11] is the only pair divisible by 28.
*/
public class PairSumDivisibleByM {
    private static final Logger LOGGER = LoggerFactory.getLogger(PairSumDivisibleByM.class);

    public static void main(String[] args) {
        int totalPairs = countTotalPairs(new int[]{1, 2, 3, 4, 5}, 2);
        LOGGER.info("Total pairs sum divisible by b in given input is {}", totalPairs);
    }

    public static int countTotalPairs(int[] input, int b) {
        Map<Integer, Integer> hashed = new HashMap<>();
        for (int i = 0; i < input.length; ++i) {
            int mod = input[i] % b;
            input[i] = mod;
            if (hashed.containsKey(mod))
                hashed.put(mod, hashed.get(mod) + 1);
            else hashed.put(mod, 1);
        }
        int output = 0;
        for (int i = 0; i < input.length; ++i) {
            int current = input[i];
            if (current == 0) {
                if (hashed.containsKey(0)) {
                    output += (hashed.get(0) - 1);
                    if (hashed.get(0) != 1)
                        hashed.put(0, hashed.get(0) - 1);
                    else hashed.remove(0);
                }
            } else if (hashed.containsKey(b - current)) {
                if (current == b - current)
                    output += (hashed.get(current) - 1);
                else output += hashed.get(b - current);
                if (hashed.containsKey(current)) {
                    if (hashed.get(current) != 1)
                        hashed.put(current, hashed.get(current) - 1);
                    else hashed.remove(current);
                }
            }
        }
        return output % 1000000007;
    }
}
