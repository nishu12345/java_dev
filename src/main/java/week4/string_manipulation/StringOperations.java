package week4.string_manipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Akash likes playing with strings. One day he thought of applying following operations on the string in the given order:
    Concatenate the string with itself. Delete all the uppercase letters. Replace each vowel with '#'.
    You are given a string A of size N consisting of lowercase and uppercase alphabets.
    Return the resultant string after applying the above operations.
    NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.
    Input-> "AbcaZeoB"
    Output-> "bc###bc###"
*/
public class StringOperations {
    private static final Logger LOGGER = LoggerFactory.getLogger(StringOperations.class);

    public static void main(String[] args) {
        String performOperations = performOperations("AbcaZeoB");
        LOGGER.info("{}", performOperations);
    }

    public static String performOperations(String input) {
        StringBuffer str = new StringBuffer(input);
        str.append(str);
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u')
                    output.append('#');
                else output.append(str.charAt(i));
            }
        }
        return output.toString();
    }
}
