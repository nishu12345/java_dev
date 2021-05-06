package week6.problem_solving_1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Mohit and Akshat are great fans of even numbers and they have A number of apples with them.
    They want to divide the apples in such a way that each of the two gets positive even number of apples,
    at the same time both should have unequal number of apples.
    The boys are extremely tired and want to start their meal as soon as possible,
    that's why you should help them and find out, if they can divide in the way they want.
    Input 1->
        4
    Output 1->
        0
    Input 2->
        8
    Output 2->
        1
    Explanation->
        4 can be divided into two even numbers but both of them will have 2 and 2 apples so it returned 0.
    Explanation 2->
        8 can be divided into two even numbers 2 and 6 and both are different.
*/
public class EvenPartition {
    private static final Logger LOGGER = LoggerFactory.getLogger(EvenPartition.class);

    public static void main(String[] args) {
        int isEvenPartition = isEvenPartition(8);
        LOGGER.info("Is given input be divided in two unequal even parts {}", isEvenPartition);
    }

    public static int isEvenPartition(int input) {
        if (input <= 5)
            return 0;
        if (input % 2 == 1)
            return 0;
        return 1;
    }
}
