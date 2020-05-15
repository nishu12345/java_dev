package functionalInterface;

/**
 * Custom functional interface to take three arguments(A,B,C) and return one value of type D
 *
 * @param <A> -> First Argument
 * @param <B> -> Second Argument
 * @param <C> -> Third Argument
 * @param <D> -> Return result
 */
@FunctionalInterface
public interface _TriFunction<A, B, C, D> {

    D apply(A a, B b, C c);
}
