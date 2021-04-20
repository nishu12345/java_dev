package week4.introduction_to_hashing_2;

import java.util.HashMap;
import java.util.Map;

/*
    In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
    The order of the alphabet is some permutation of lowercase letters.
    Given an array of words A of size N written in the alien language, and the order of the alphabet denoted by string B of size 26,
    return 1 if and only if the given words are sorted lexicographicaly in this alien language else return 0.

    Input->
        A = ["hello", "scaler", "interviewbit"]
        B = "adhbcfegskjlponmirqtxwuvzy"
    Output->
        1
*/
public class IsDictionary {
    public static void main(String[] args) {
//        String[] A = {"ipial", "qjqgt", "vfnue", "vjqfp", "eghva", "ufaeo", "atyqz", "chmxy", "ccvgv", "ghtow"};
//        String B = "nbpfhmirzqxsjwdoveuacykltg";
        String[] A = {"hello", "scaler", "interviewbit"};
        String B = "adhbcfegskjlponmirqtxwuvzy";
        int checkDictionary = checkDictionary(A, B);
        System.out.println("Is Dictionary > " + checkDictionary);
    }

    public static int checkDictionary(String[] inputA, String inputB) {
        char[] inputBToChar = inputB.toCharArray();
        Map<Character, Integer> weightMap = new HashMap<>();
        for (int i = 0; i < inputBToChar.length; ++i) {
            weightMap.put(inputBToChar[i], i);
        }
        for (int i = 0; i < inputA.length - 1; ++i) {
            char[] firstWordChar = inputA[i].toCharArray();
            char[] secondWordChar = inputA[i + 1].toCharArray();
            boolean isDictionary = checkWeight(firstWordChar, secondWordChar, weightMap);
            if (!isDictionary)
                return 0;
        }
        return 1;
    }

    public static boolean checkWeight(char[] firstWord, char[] secondWord, Map<Character, Integer> weightedMap) {
        int firstWordLength = firstWord.length;
        int secondWordLength = secondWord.length;
        int length = firstWordLength;
        if (secondWordLength < firstWordLength)
            length = secondWordLength;
        boolean isCharSame = false;
        for (int i = 0; i < length; ++i) {
            int inputACharWeight = weightedMap.get(firstWord[i]);
            int inputBCharWeight = weightedMap.get(secondWord[i]);
            if (inputACharWeight < inputBCharWeight)
                return true;
            else if (inputBCharWeight < inputACharWeight)
                return false;
            else isCharSame = true;
        }
        if (isCharSame && secondWordLength < firstWordLength)
            return false;
        else return true;

    }
}
