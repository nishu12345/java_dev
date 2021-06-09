package week9.problem_solving_7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    N light bulbs are connected by a wire.
    Each bulb has a switch associated with it, however due to faulty wiring,
    a switch also changes the state of all the bulbs to the right of current bulb.
    Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
    You can press the same switch multiple times.
    Note: 0 represents the bulb is off and 1 represents the bulb is on.
    Input->
        [0,1,0,1]
    Output->
        4
    Explanation->
        press switch 0 : [1 0 1 0]
        press switch 1 : [1 1 0 1]
        press switch 2 : [1 1 1 0]
        press switch 3 : [1 1 1 1]


*/
public class Bulbs {
    private static final Logger LOGGER = LoggerFactory.getLogger(Bulbs.class);

    public static void main(String[] args) {
        int minimumSwitches = minimumSwitches(new int[]{0, 1, 0, 1});
        LOGGER.info("Minimum Switched Required to turn all bulbs on in given input is {}", minimumSwitches);
    }

    public static int minimumSwitches(int[] input) {
        int count = 0;
        for (int i = 0; i < input.length; ++i) {
            if (input[i] == 0) {
                count++;
                for (int j = i; j < input.length; ++j) {
                    input[j] = 1 - input[j];
                }
            }
        }
        return count;
    }
}
