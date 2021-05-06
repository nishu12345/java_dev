package week6.problem_solving_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


/*
    You love reading books, and you also love reading books that you've already read (weird you).
    In a day, you read a total of N times, consisting of some books. Each book is represented by an index in array A.
    You write the number of each book you read in the order of reading them in the array A.
    You are supposed to find the book that you've least recently read (the book you haven't read for as long as possible)
    out of the books you've read that day (Books in array A).
    Input->
         [7, 8, 4, 2, 7]
    Output->
        8
    Explanation->
         8 is the least recently read book.
*/
public class BookLover {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookLover.class);

    public static void main(String[] args) {
        int longestRead = longestRead(new int[]{4, 8, 1, 3, 1});
        LOGGER.info("Least recently read book in given input {}", longestRead);
    }

    public static int longestRead(int[] input) {
        int output = Integer.MAX_VALUE;
        Map<Integer, Integer> hashed = new HashMap<>();
        for (int i = 0; i < input.length; ++i) {
            hashed.put(input[i], i);
        }
        for (int i = 0; i < input.length; ++i) {
            int temp = hashed.get(input[i]);
            if (temp < output)
                output = temp;
        }
        return input[output];
    }
}
