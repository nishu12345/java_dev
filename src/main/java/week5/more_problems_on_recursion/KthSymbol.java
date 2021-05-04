package week5.more_problems_on_recursion;

/*
    On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01,
    and each occurrence of 1 with 10.
    Given row A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.) (1 indexed).
    Input->
        A = 2
        B = 2
    Output->
        1
    Explanation->
         Row 1: 0
         Row 2: 01 (Bth element i.e 2nd element of Ath row i.e 2nd row is 1)
*/
public class KthSymbol {

    public static void main(String[] args) {
        int a = 2;
        int b = 2;
        StringBuffer output = formString(2);
        if (output.charAt(b - 1) == '0')
            System.out.println(0);
        else System.out.println(1);
    }

    public static StringBuffer formString(int A) {
        if (A == 0)
            return new StringBuffer("0");
        StringBuffer temp = formString(A - 1);
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < temp.length(); ++i) {
            if (temp.charAt(i) == '0')
                output.append("01");
            else
                output.append("10");
        }
        return output;
    }
}
