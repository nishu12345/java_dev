package week8.problem_solving_4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers A of size N which denotes N cylindrical empty bottles. The radius of the ith bottle is A[i].
    You can put the ith bottle into the jth bottle if the following conditions are met:
    ith bottle is not put into another bottle.
    jth bottle dosen't contain any other bottle.
    The radius of bottle i is smaller than bottle j (A[i] < A[j]).
    You can put bottles into each other any number of times. You want to MINIMIZE the number of visible bottles. A bottle is called visible if it is not put into any other bottle.
    Find and return the minimum number of visible bottles.
    Input->
        [1,1,1,2,2,3,4,4,4,4]
    Output->
        4
    Explanation->
        1-2-3-4
        1-2-4
        1-4
        4
*/
public class GameOfBottles {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameOfBottles.class);

    public static void main(String[] args) {
        int visibleBottles = visibleBottles(new int[]{1, 1, 1, 2, 2, 3, 4, 4, 4, 4});
        LOGGER.info("Total Visible bottles in given input is {}", visibleBottles);
    }

    public static int visibleBottles(int[] input) {
        int output = 1;
        Map<Integer, Integer> hashed = new HashMap<>();
        for (int i = 0; i < input.length; ++i) {
            if (hashed.containsKey(input[i])) {
                hashed.put(input[i], hashed.get(input[i]));
                if (hashed.get(input[i]) > output)
                    output = hashed.get(input[i]);
            } else hashed.put(input[i], 1);
        }
        return output;
    }
}
