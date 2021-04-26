package week4.string_manipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/*
    Given a string A of size N.
    Return the string A after reversing the string word by word.
    NOTE:
        A sequence of non-space characters constitutes a word.
        Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
        If there are multiple spaces between words, reduce them to a single space in the reversed string.
   Input->
        the sky is blue
   Output->
        blue is sky the
*/
public class ReverseTheString {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReverseTheString.class);

    public static void main(String[] args) {
        String reversedString = reverseString("the sky is blue");
        LOGGER.info("Reverse of string, the sky is blue is {}", reversedString);
    }

    public static String reverseString(String input) {
        if (input.length() < 2)
            return input;
        if (input.charAt(input.length() - 1) != ' ')
            input = input.concat(" ");
        ArrayList<StringBuffer> words = new ArrayList<>();
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) != ' ')
                temp.append(input.charAt(i));
            else if (temp.length() != 0) {
                words.add(temp);
                temp = new StringBuffer();
            }
        }
        temp = new StringBuffer();
        for (int i = words.size() - 1; i >= 0; --i) {
            temp.append(words.get(i));
            if (i != 0)
                temp.append(" ");
        }
        return temp.toString();
    }
}
