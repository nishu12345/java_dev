package week3.introduction_to_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Given an array A of N strings, return all groups of strings that are anagrams.
    Represent a group by a list of integers representing the index(1-based) in the original list.
    Input-> [cat, dog, god, tca]
    Output->
        [ [1, 4],
        [2, 3] ]
    Explanation->
    "cat" and "tca" are anagrams which correspond to index 1 and 4 and "dog" and "god" are another set of anagrams which correspond to index 2 and 3.
    The indices are 1 based ( the first element has index 1 instead of index 0).
*/
public class Anagrams {

    public static void main(String[] args) {

        ArrayList<String> input = new ArrayList<>();
        input.add("cat");
        input.add("dog");
        input.add("god");
        input.add("tca");
        input.add("abc");

        ArrayList<ArrayList<Integer>> indexesOfAnagrams = findAnagrams(input);
        for (ArrayList<Integer> temp : indexesOfAnagrams) {
            for (Integer index : temp) {
                System.out.print(index + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> findAnagrams(ArrayList<String> input) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        Map<String, Integer> hashedInput = new HashMap<>();
        for (int i = 0; i < input.size(); ++i) {
            String sortedString = sortString(input.get(i));
            if (hashedInput.containsKey(sortedString)) {
                int a = hashedInput.get(sortedString);
                ArrayList<Integer> temp = output.get(a - 1);
                temp.add(i + 1);
                output.remove(a - 1);
                output.add(a - 1, temp);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i + 1);
                output.add(temp);
                hashedInput.put(sortedString, output.size());
            }
        }
        return output;
    }

    public static String sortString(String inputString) {
        char[] toCharArray = inputString.toCharArray();
        Arrays.sort(toCharArray);
        return new String(toCharArray);
    }
}
