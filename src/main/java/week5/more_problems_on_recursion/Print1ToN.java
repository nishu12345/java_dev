package week5.more_problems_on_recursion;


/*
    You are given an integer N, print 1 to N using using recursion.
    Input->
        10
    Output->
        1 2 3 4 5 6 7 8 9 10

*/
public class Print1ToN {
    public static void main(String[] args) {
        //pass one number greater to input
        int input = 10;
        print(input + 1);
    }

    public static int print(int input) {
        if (input == 1) {
            return input;
        }
        System.out.print(print(input - 1) + " ");
        return input;
    }
}
