package functionalInterface;

import java.util.function.Supplier;

/**
 * Supplier<T> It takes no arguments and return a value of type T
 */
public class _Supplier {

    public static void main(String[] args) {
        System.out.println(getDBUrl());
        System.out.println(getDBUrl.get());
    }

    static Supplier<String> getDBUrl = () -> "jdbc://localhost:3306/user";

    static String getDBUrl(){
        return "jdbc://localhost:3306/user";
    }
}
