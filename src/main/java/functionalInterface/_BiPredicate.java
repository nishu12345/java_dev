package functionalInterface;


import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * BiPredicate<T,U> It take two arguments and return a boolean value.
 */
public class _BiPredicate {

    public static void main(String[] args) {
        System.out.println(biPredicate.test("Hello", "Hello"));

    }

    static BiPredicate<String, String> biPredicate = (argument1, argument2) -> argument1.equals(argument2);
}
