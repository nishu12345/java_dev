package week10.timeAndSpacePlusArrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RainWaterTrapped {
    private static final Logger LOGGER = LoggerFactory.getLogger(RainWaterTrapped.class);

    public static void main(String[] args) {
//        int waterTrapped = getWaterTrapped(new int[]{2, 4, 2, 6, 4, 2, 5, 3, 7});
//        int waterTrapped = getWaterTrappedBetter(new int[]{2, 4, 2, 6, 4, 2, 5, 3, 7});
        int waterTrapped = getWaterTrappedBest(new int[]{2, 4, 2, 6, 4, 2, 5, 3, 7});
        LOGGER.info("Total Rainwater Trapped in given input is {}", waterTrapped);
    }

    /*-----Time Complexity -> O(n*n)-----*/
    public static int getWaterTrapped(int[] input) {
        int totalWater = 0;
        int inputLength = input.length;
        for (int i = 0; i < inputLength; ++i) {
            int maxLeft = 0;
            int maxRight = 0;
            for (int j = 0; j < i; ++j) {
                if (input[j] > maxLeft)
                    maxLeft = input[j];
            }
            for (int k = i + 1; k < inputLength; ++k) {
                if (input[k] > maxRight)
                    maxRight = input[k];
            }
            int waterTrapped = Math.min(maxLeft, maxRight) - input[i];
            if (waterTrapped > 0)
                totalWater += waterTrapped;
        }
        return totalWater;
    }

    /*-----Time Complexity -> O(n) | Space Complexity -> O(n)-----*/
    public static int getWaterTrappedBetter(int[] input) {
        int totalWater = 0;
        int inputLength = input.length;
        int[] leftMax = new int[inputLength];
        int[] rightMax = new int[inputLength];
        int leftMaxElement = input[0];
        int rightMaxElement = input[inputLength - 1];
        for (int i = 1; i < inputLength; ++i) {
            leftMax[i] = leftMaxElement;
            if (input[i] > leftMaxElement)
                leftMaxElement = input[i];
        }
        for (int i = inputLength - 2; i >= 0; --i) {
            rightMax[i] = rightMaxElement;
            if (input[i] > rightMaxElement)
                rightMaxElement = input[i];
        }

        for (int i = 0; i < inputLength; ++i) {
            int sum = Math.min(leftMax[i], rightMax[i]) - input[i];
            if (sum > 0)
                totalWater += sum;
        }
        return totalWater;
    }

    /*-----Time Complexity -> O(n) | Space Complexity -> O(1)-----*/
    public static int getWaterTrappedBest(int[] input) {
        int totalWater = 0;
        int maxHeight = input[0];
        int maxHeightIndex = 0;
        int inputLength = input.length;
        for (int i = 1; i < inputLength; ++i) {
            if (input[i] > maxHeight) {
                maxHeight = input[i];
                maxHeightIndex = i;
            }
        }

        int leftMax = input[0];
        for (int i = 1; i < maxHeightIndex; ++i) {
            int sum = Math.min(leftMax, maxHeight) - input[i];
            if (sum > 0)
                totalWater += sum;
            if (input[i] > leftMax)
                leftMax = input[i];
        }
        int rightMax = input[inputLength - 1];
        for (int i = inputLength - 2; i > maxHeightIndex; --i) {
            int sum = Math.min(maxHeight, rightMax) - input[i];
            if (sum > 0)
                totalWater += sum;
            if (input[i] > rightMax)
                rightMax = input[i];
        }
        return totalWater;
    }


}
