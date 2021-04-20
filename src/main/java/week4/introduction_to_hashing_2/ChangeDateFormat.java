package week4.introduction_to_hashing_2;

import java.util.HashMap;
import java.util.Map;

/*
    Given a date string in the format Day Month Year, where:
    Day is in the set {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", ..., "29th", "30th", "31st"}.
    Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
    Year is in the inclusive range [1900, 3000].

    Convert the date string to the format YYYY-MM-DD, where:
    YYYY denotes the 4 digit year.
    MM denotes the 2 digit month.
    DD denotes the 2 digit day.
    For example:
    1st Mar 1984 → 1984-03-01
    2nd Feb 2013 → 2013-02-02 4th Apr 1900 → 1900-04-04
 */
public class ChangeDateFormat {
    public static void main(String[] args) {
        String changedDateFormat = changeDateFormat("26 Mar 1984");
        System.out.println("Changed Date Format > " + changedDateFormat);
    }
    public static String changeDateFormat(String inputDate) {
        String output = "";
        String[] inputDateInArray = inputDate.split(" ");
        output = inputDateInArray[2] + "-";
        output += monthMap().get(inputDateInArray[1]) + "-";
        char[] numericalDate = inputDateInArray[0].toCharArray();
        if (numericalDate[1] >= '0' && numericalDate[1] < '9')
            output += numericalDate[0] + numericalDate[1];
        else
            output += "0" + numericalDate[0];
        return output;
    }

    public static Map<String, String> monthMap() {
        Map<String, String> abbToNumber = new HashMap<>();
        abbToNumber.put("Jan", "01");
        abbToNumber.put("Feb", "02");
        abbToNumber.put("Mar", "03");
        abbToNumber.put("Apr", "04");
        abbToNumber.put("May", "05");
        abbToNumber.put("Jun", "06");
        abbToNumber.put("Jul", "07");
        abbToNumber.put("Aug", "08");
        abbToNumber.put("Sep", "09");
        abbToNumber.put("Oct", "10");
        abbToNumber.put("Nov", "11");
        abbToNumber.put("Dec", "12");
        return abbToNumber;
    }
}
