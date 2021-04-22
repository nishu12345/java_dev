package week4.introduction_to_sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/*
    Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p.
    If such an integer is found return 1 else return -1.

    Input-> [3,2,1,2]
    Output-> 1
    Explanation-> For 2, there are exactly 2 integers greater than 2 i.e [3,3]. So it is a noble integer.
*/
public class NobleInteger {
    private static final Logger LOGGER = LoggerFactory.getLogger(NobleInteger.class);

    public static void main(String[] args) {
        int checkNobleInteger = checkNobleInteger(new int[]{3, 2, 1, 3});
        LOGGER.info("Is {} a noble integer {}", "3,2,1,3", checkNobleInteger);
    }

    public static int checkNobleInteger(int[] input) {
        Arrays.sort(input);
        if (input[input.length - 1] == 0)
            return 1;
        for (int i = 0; i < input.length - 1; ++i) {
            if (input[i] != input[i + 1] && input[i] == input.length - (i + 1))
                return 1;
        }
        return -1;
    }
}
