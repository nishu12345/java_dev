package functionalInterface;

/**
 * Custom functional interface to take three arguments and return one value.
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
