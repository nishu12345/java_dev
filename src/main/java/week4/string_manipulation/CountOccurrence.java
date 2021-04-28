package week4.string_manipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Find number of occurrences of bob in the string A consisting of lowercase english alphabets.
    Input-> abobc
    Output-> 1

*/
public class CountOccurrence {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountOccurrence.class);

    public static void main(String[] args) {
        int totalBobCount = countTotalBob("bobbob");
        LOGGER.info("Total 'bob' count in given input {}", totalBobCount);
    }

    public static int countTotalBob(String input) {
        if (input.length() < 3)
            return 0;
        int totalOccurrence = 0;
        StringBuffer temp = new StringBuffer("bob");
        temp.setCharAt(0, input.charAt(0));
        temp.setCharAt(1, input.charAt(1));
        temp.setCharAt(2, input.charAt(2));
        if (temp.toString().equals("bob"))
            totalOccurrence = 1;
        for (int i = 3; i < input.length(); ++i) {
            temp.setCharAt((0), temp.charAt(1));
            temp.setCharAt(1, temp.charAt(2));
            temp.setCharAt(2, input.charAt(i));
            if (temp.toString().equals("bob"))
                totalOccurrence++;
        }
        return totalOccurrence;
    }
}
