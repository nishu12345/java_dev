package week6.problem_solving_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    There are N shops for chocolates and there is an "offer that you can't refuse".
    Each of the shops has some amount of chocolates represented as an array A[] of size N
    where Ai represents the number of chocolates ith shop has. So according to the offer,
    you can select any number of contiguous shops but those shops should have a non-decreasing order of amount of chocolates.
    Determine the maximum number of chocolates that you can have.
    Input->
        shopCount = 6
        [2,2,1,3,4,1]
    Output->
        8
    Explanation->
        You can pick shop number (3,4,5) which has a non-decreasing order and the sum of chocolates you can have is 8.
*/
public class ChocolateShops {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChocolateShops.class);

    public static void main(String[] args) {
        int maxChocolates = maxChocolates(6, new int[]{2, 2, 1, 3, 4, 1});
        LOGGER.info("Max Chocolates in non decreasing order from given input {}", maxChocolates);
    }

    public static int maxChocolates(int shopCount, int[] input) {
        int max = 0;
        int sum = input[0];
        for (int i = 1; i < shopCount; ++i) {
            if (input[i] >= input[i - 1])
                sum += input[i];
            else {
                if (sum > max)
                    max = sum;
                sum = input[i];
            }
        }
        if (sum > max)
            max = sum;
        return max;
    }
}
