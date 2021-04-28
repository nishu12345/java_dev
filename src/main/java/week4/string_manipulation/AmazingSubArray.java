package week4.string_manipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    You are given a string S, and you have to find all the amazing substrings of S.
    Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
    Input->
        ABEC
    Output->
        6
    Explanation->
        Amazing substrings of given string are :
            1. A
            2. AB
            3. ABE
            4. ABEC
            5. E
            6. EC
        Here number of substrings are 6 and 6 % 10003 = 6
*/
public class AmazingSubArray {
    private static final Logger LOGGER = LoggerFactory.getLogger(AmazingSubArray.class);

    public static void main(String[] args) {
        String s = new String("AzZGBauYuTknYjjWEEbLvqMQwnoSgXKBdHKEVpeoxYNNtBfrxQrPauttMzjKFayKwMeuChjzCocgAHfAmPCatOqarzLuabyTnxoheeocVshfERNssVPfRyPmwvOVGbzNAuvryYNWwIeyZLMlLbkcFFJRHjEIgIwOThRJJFpLbunVrbhAYsMtdsKslLAGElwrZjvZweIytMpPEYVmktQeNleNROcTjrNxXeHvOMMTMfqZHTUjetojHFzZwOekfAILYISANxeJFRNgeZDKoOTddXqxduPIjGXsRSSkgIqKMeSqlQwAKtdrkvHLgmKleNAPEztGMPmZzUuCImLAhzUnXmsVzFvJUTeIKleuRnMPNAPWJYAZLXgzTBPmkXVShbBSlIAJSeFgvRFvcoqfVFgHUefxUxuYFCfUxbxlOslUhYRFXKmMmqDIQhhfXyGqUwGMSYeLLpEsKAhvFUzavDCOUgtmmNMnsvfmCdPWuWIjuUfZCBTrWnaDopbqXcjzSqRMpQWIBNnMcOQZjDkjPkxsuwENYQyjgSHFJrgSLnwbEInBfdeIfBbVuZZbBrblJgKHOmLZACLQkSRxxQJeUMPIQutraxFtrRcSeqAejOTSqaFGglQOoWPkcNOnLIgfclWNtjGQRVMlqCPUnUlOLbHfkzUyNAmTsswWtZjIGUBrLmRmstHgVcRUgWdQTCEPRzjPVTMJRJocYHftwoRzOSyQexjmceRHdqFdgNuGmGTUdXQaNwKmvOUzZPzGCBVcbVLgMoQrESbpVGteVVntOwEWxXsZnSAoIfBSsWVhDFBuDTkcrnsPdmmSHymouxHlcgtjgKUAPznxsIRUjDFsrjadJjEtPaWTVBHpatqYeSgrpWJDOGfgIGQPcTIXVsCVyCfKMpcXWGkvwuRuTmvCbNMLeUkZrEpYZdlKAgFELfwCCbZCYBcXhfUrsIHfdwhYyxHKAMYMERwlyRtxObDoxBhjXmynYkmkYZrkzlCuvrhW");
        int totalAmazingSubArray = countAmazingSubArray(s);
        LOGGER.info("Total Amazing Sub Array in Input String is {}", totalAmazingSubArray);
    }

    public static int countAmazingSubArray(String input) {
        int amazingSubArrayCount = 0;
        StringBuffer str = new StringBuffer(input);
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                str.setCharAt(i, (char) (str.charAt(i) - 32));
            if (str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O' || str.charAt(i) == 'U')
                amazingSubArrayCount += (str.length() - i);
        }
        return amazingSubArrayCount % 10003;
    }
}
