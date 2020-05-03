package functionalInterface;

import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        System.out.println(incrementByOne(1));
        System.out.println(incrementByOne.apply(1));
        System.out.println(new _Function().decrementByOne.apply(2));
        System.out.println(multiplyBy10.apply(10));

        System.out.println(incrementByOne.andThen(multiplyBy10).apply(5));
    }

    //imperative approach
    static int incrementByOne(int n) {
        return n + 1;
    }

    //declarative approach
    static Function<Integer, Integer> incrementByOne = n -> n + 1;
    static Function<Integer,Integer> multiplyBy10 = n -> n*10;
    Function<Integer, Integer> decrementByOne = n -> n - 1;
}
