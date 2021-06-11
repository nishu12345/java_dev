package week9.basic_of_storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

/*
    Given a string A representing an absolute path for a file (Unix-style).
    Return the string A after simplifying the absolute path.
    Note:
        Absolute path always begin with '/' ( root directory ).
        Path will not have whitespace characters.

    Input-> "/a/./b/../../c/"
    Output->    "/c"
*/
public class SimplifyDirectoryPath {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimplifyDirectoryPath.class);

    public static void main(String[] args) {
        String simplifiedPath = simplifyPath("/a/./b/../../c/");
        LOGGER.info("Simplified path for given input is {}", simplifiedPath);
    }

    public static String simplifyPath(String input) {
        Stack<String> stacked = new Stack<>();
        String[] split = input.split("/");
        for (String s : split) {
            if (s.equals("..") && stacked.size() != 0)
                stacked.pop();
            else if (!s.equals("..") && !s.equals("."))
                stacked.push(s);
        }

        StringBuffer str = new StringBuffer();
        for (String s : stacked) {
            if (!s.equals("")) {
                str.append("/");
                str.append(s);
            }
        }
        return str.toString();
    }
}
