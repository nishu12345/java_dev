package functionalInterface;

import java.util.function.Predicate;


/**
 * Predicate<T> It takes one argument and returns a boolean value.
 */
public class _Predicate {

    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("987654321"));
        System.out.println(isPhoneNumberValid.test("9876543210"));

        System.out.println(isPhoneNumberValid.and(isPhoneNumber).test("0987654321"));
        System.out.println(isPhoneNumberValid.or(isPhoneNumber).test("1234567890"));
    }

    static Predicate<String> isPhoneNumberValid = phoneNumber -> phoneNumber.length() == 10;

    static Predicate<String> isPhoneNumber = phoneNumber -> phoneNumber.startsWith("09");

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.length() == 10;
    }

}
