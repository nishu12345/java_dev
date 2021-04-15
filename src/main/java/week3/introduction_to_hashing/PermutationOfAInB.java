package week3.introduction_to_hashing;

import java.util.HashMap;
import java.util.Map;

/*
    You are given two strings A and B of size N and M respectively.
    You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.
    Input->
        A = "ebbp"
        B = "qaoedpcebeaqocbacoccqoebpqdoqcpbdbqcecdoqcpebqpebbabqdpepcpbqbepbabocpc"
    Output->
        2
    Explanation->
        pebb and bepb

 */
public class PermutationOfAInB {

    public static void main(String[] args) {
        int totalPermutationCount = calculatePermutation("ebbp", "qaoedpcebeaqocbacoccqoebpqdoqcpbdbqcecdoqcpebqpebbabqdpepcpbqbepbabocpc");
        System.out.println(totalPermutationCount);
    }

    public static int calculatePermutation(String A, String B) {
        int output = 0;
        Map<Character, Integer> frequencyOfA = new HashMap<>();
        Map<Character, Integer> frequencyOfB = new HashMap<>();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            frequencyOfA.put(ch, 0);
            frequencyOfB.put(ch, 0);
        }
        char[] stringAToChar = A.toCharArray();
        char[] stringBToChar = B.toCharArray();
        for (int i = 0; i < stringAToChar.length; ++i) {
            frequencyOfA.put(stringAToChar[i], frequencyOfA.get(stringAToChar[i]) + 1);
            frequencyOfB.put(stringBToChar[i], frequencyOfB.get(stringBToChar[i]) + 1);
        }
        if (frequencyOfB.equals(frequencyOfA))
            output++;


        int temp = 0;
        for (int i = A.length(); i < B.length(); ++i) {
            frequencyOfB.put(stringBToChar[i], frequencyOfB.get(stringBToChar[i]) + 1);
            frequencyOfB.put(stringBToChar[temp], frequencyOfB.get(stringBToChar[temp]) - 1);
            temp++;
            if (frequencyOfB.equals(frequencyOfA))
                output++;
        }

        return output;

    }


}
