package week4.string_manipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/*
    Given a string A of size N consisting of lowercase alphabets.
    You can change at most B characters in the given string to any other lowercase alphabet
    such that the number of distinct characters in the string is minimized.
    Find the minimum number of distinct characters in the resulting string.
    Input-> "abcabbccd"
    Output -> 2
    Explanation->
        We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
        So the minimum number of distinct character will be 2.
*/
public class ChangeCharacter {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChangeCharacter.class);

    public static void main(String[] args) {
        int distinctCharacter = countDistinctCharacter("wfnfozvsrt", 4);
        LOGGER.info("Possible distinct character count for given input {}",distinctCharacter);
    }

    public static int countDistinctCharacter(String input, int B) {
        int distinctCount = 0;
        int[] countChar = new int[26];
        for (int i = 0; i < input.length(); ++i) {
            int index = input.charAt(i) - 97;
            countChar[index] = countChar[index] + 1;
        }
        Arrays.sort(countChar);
        for(int i = 0; i < countChar.length; ++i){
            if(countChar[i]<=B){
                B-=countChar[i];
                countChar[i]=0;
            }else if(countChar[i]!=0){
                distinctCount++;
            }
        }
        return distinctCount;
    }
}
