package week11.searchingOne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Given an integer A representing the number of square blocks. The height of each square block is 1.
    The task is to create a staircase of max height using these blocks.
    The first stair would require only one block, the second stair would require two blocks and so on.
    Find and return the maximum height of the staircase.
    Input > 20
    Output > 5
* */
public class MaximumHeightOfStaircase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MaximumHeightOfStaircase.class);

    public static void main(String[] args) {
        int input = 20;
        int maximumHeight = getMaximumHeight(input);
        LOGGER.info("Maximum Height of Staircase with given input {} is {}",input,maximumHeight);
    }

    public static int getMaximumHeight(int input){
        int heightOfStairCase = 0;
        int stepsConsumed = 0;
        while(input>stepsConsumed){
            stepsConsumed+=1;
            input-=stepsConsumed;
            heightOfStairCase++;
        }
        return heightOfStairCase;
    }
}
