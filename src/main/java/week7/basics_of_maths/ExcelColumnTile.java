package week7.basics_of_maths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Given a positive integer A, return its corresponding column title as appear in an Excel sheet.
    For Example-
        1 -> A
        2 -> B
        3 -> C
        ...
        26 -> Z
        27 -> AA
        28 -> AB
    Input->
        27
    Output->
        "AA"
*/
public class ExcelColumnTile {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelColumnTile.class);

    public static void main(String[] args) {
        String column = getColumn(78);
        LOGGER.info("Column name for given column number is {}", column);
    }

    public static String getColumn(int columnNumber) {
        StringBuffer output = new StringBuffer();
        while (columnNumber > 0) {
            int num = columnNumber % 26;
            if (num == 0)
                num = 26;
            char ch = (char) (64 + num);
            StringBuffer temp = new StringBuffer(String.valueOf(ch));
            temp.append(output);
            output = temp;
            columnNumber /= 26;
            if (num == 26)
                columnNumber--;
        }
        return output.toString();
    }
}
