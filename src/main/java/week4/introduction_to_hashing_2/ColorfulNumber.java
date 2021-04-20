package week4.introduction_to_hashing_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
    For Given Number A find if its COLORFUL number or not.
    If number A is a COLORFUL number return 1 else return 0.
    What is a COLORFUL Number:
    A number can be broken into different contiguous sub-subsequence parts.
    Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
    And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.

    Input-> 236
    Output-> 0
    Explanation->
        Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
        2 -> 2
        3 -> 3
        6 -> 6
        23 -> 6  (product of digits)
        36 -> 18  (product of digits)
        236 -> 36  (product of digits)
        This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same.
*/
public class ColorfulNumber {
    public static void main(String[] args) {
        int checkColorfulNumber = checkColorfulNumber(236);
        System.out.println("Check Colorful Number > " + checkColorfulNumber );
    }
    public static int checkColorfulNumber(int input) {
        ArrayList<Integer> numToDigits = new ArrayList<>();
        while (input > 0) {
            numToDigits.add(input % 10);
            input /= 10;
        }
        Map<Integer, Boolean> productHashed = new HashMap<>();
        for (int i = 0; i < numToDigits.size(); ++i) {
            int product = 1;
            for (int j = i; j < numToDigits.size(); ++j) {
                product *= numToDigits.get(j);
                if (productHashed.containsKey(product))
                    return 0;
                else productHashed.put(product, true);

            }
        }
        return 1;
    }
}
