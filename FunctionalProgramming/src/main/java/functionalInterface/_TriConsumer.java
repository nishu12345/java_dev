package functionalInterface;


/**
 * _TriConsumer<A,B,C> It takes three arguments and return nothing.
 * @param <A>
 * @param <B>
 * @param <C>
 */

@FunctionalInterface
public interface _TriConsumer<A,B,C> {

    public abstract void accept(A a, B b, C c);
}
