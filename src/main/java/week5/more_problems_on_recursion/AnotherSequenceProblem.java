package week5.more_problems_on_recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Given a sequence f(A) = f(A-1) + f(A-2) + f(A-3) + A . Calculate the Ath term of the sequence.
    Given f(0)=1; f(1)=1; f(2)=2;
    Input->
        3
    Output->
        7
    Explanation->
         f(3) = f(2) + f(1) + f(0) + input = 2+1+1+3 = 7

*/
public class AnotherSequenceProblem {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnotherSequenceProblem.class);

    public static void main(String[] args) {
        int input = 3;
        int output = calTerm(input);
        LOGGER.info("Input(th) term of the given sequence is {}", output);
    }

    public static int calTerm(int input) {
        if (input == 0)
            return 1;
        if (input == 1 || input == 2)
            return input;
        return input + calTerm(input - 1) + calTerm(input - 2) + calTerm(input - 3);
    }
}
