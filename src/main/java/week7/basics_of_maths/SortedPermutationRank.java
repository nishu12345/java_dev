package week7.basics_of_maths;

import java.util.ArrayList;
import java.util.Collections;
/*
    Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
    Assume that no characters are repeated.
    Note: The answer might not fit in an integer, so return your answer % 1000003
    Input->
        acb
    Output->
        2
    Explanation->
         Given A = "acd".
         The order permutations with letters 'a', 'c', and 'b' :
            abc
            acb
            bac
            bca
            cab
            cba
        So, the rank of A is 2.
*/
public class SortedPermutationRank {

    public static void main(String[] args) {
        int rank = findRank("acb");
        System.out.println(rank);
    }

    public static int findRank(String input) {
        ArrayList<Character> sorted = new ArrayList<>();
        for (int i = 0; i < input.length(); ++i) {
            sorted.add(input.charAt(i));
        }
        Collections.sort(sorted);
        int output = 0;
        for (int i = 0; i < input.length(); ++i) {
            char temp = input.charAt(i);
            int smallCharsCount = getIndex(temp, sorted);
            sorted.remove(smallCharsCount);
            int permutationIndex = input.length() - (i + 1);
            output = output%1000003 + (smallCharsCount%1000003 * calPermutation(permutationIndex)%1000003);
        }
        return output+1;
    }

    public static int getIndex(char ch, ArrayList<Character> sortedString) {
        for (int i = 0; i < sortedString.size(); ++i) {
            if (ch == sortedString.get(i))
                return i;
        }
        return 0;
    }


    public static int calPermutation(int num) {
        if (num <= 1) {
            return num;
        }
        return (calPermutation(num - 1) * num)%1000003;
    }
}
