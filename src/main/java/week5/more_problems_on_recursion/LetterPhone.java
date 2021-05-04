package week5.more_problems_on_recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/*
    Given a digit string A, return all possible letter combinations that the number could represent.
    A mapping of digit to letters (just like on the telephone buttons) is given below.
    The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
    NOTE: Make sure the returned strings are lexicographically sorted.
    Input->
        23
    Output->
         ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
*/
public class LetterPhone {

    public static void main(String[] args) {
        String input = "23";
        Map<Character, String> hashed = new HashMap<>();
        hashed.put('0', "0");
        hashed.put('1', "1");
        hashed.put('2', "abc");
        hashed.put('3', "def");
        hashed.put('4', "ghi");
        hashed.put('5', "jkl");
        hashed.put('6', "mno");
        hashed.put('7', "pqrs");
        hashed.put('8', "tuv");
        hashed.put('8', "wxyz");
        ArrayList<String> output = new ArrayList<>();
        solve(input, 0, hashed, new StringBuffer(), output);
        for (String s : output)
            System.out.print(s + " ");
    }

    public static void solve(String input, int index, Map<Character, String> hashed, StringBuffer sb, ArrayList<String> output) {
        if (index == input.length()) {
            output.add(sb.toString());
            return;
        }

        String current = hashed.get(input.charAt(index));
        for (int i = 0; i < current.length(); ++i) {
            sb.append(current.charAt(i));
            solve(input, index + 1, hashed, sb, output);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
