package week5.more_problems_on_recursion;

/*
    You are given an integer N, print N to 1 using using recursion.
    Input->
        10
    Output->
        10 9 8 7 6 5 4 3 2 1
*/
public class PrintNTo1 {

    public static void main(String[] args) {
        int input = 10;
        print(input);
    }

    public static int print(int n) {
        if (n == 0) {
            return n;
        }
        System.out.print(n + " ");
        return print(n - 1);
    }
}
