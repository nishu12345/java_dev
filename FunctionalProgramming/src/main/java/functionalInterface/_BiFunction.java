package functionalInterface;

import java.util.function.BiFunction;

/**
 * BiFunction<T,U,R>  It is pre-defined functional interface that takes two arguments(T,U) and return one value of type R
 */
public class _BiFunction {
    public static void main(String[] args) {
        System.out.println(incrementByOneAndMultiply(5, 10));
        System.out.println(incrementByOneAndMultiply.apply(5, 10));
        System.out.println(triFunction.apply(100, 200, 300));
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiply = (number, multiplyBy) -> (number + 1) * multiplyBy;

    static int incrementByOneAndMultiply(int number, int multiplyBy) {
        return (number + 1) * multiplyBy;
    }

    static _TriFunction<Integer, Integer, Integer, Integer> triFunction = (a, b, c) -> a + b + c;
}
