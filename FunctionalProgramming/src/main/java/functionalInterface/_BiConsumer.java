package functionalInterface;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * BiConsumer<T,U> It takes two arguments and return nothing
 */
import java.util.function.BiConsumer;

public class _BiConsumer {

    public static void main(String[] args) {
//        biConsumer.accept(new _Consumer.Customer("Maria", "9876543210"), false);
        customTriConsumer.accept(10, 20, 30);
        biConsumer.andThen(biConsumer).accept(new _Consumer.Customer("Maria", "9876543210"), true);


    }

    static BiConsumer<_Consumer.Customer, Boolean> biConsumer = (customer, showNumber) ->
            System.out.println("Hello " + customer.getCustomerName() + " thank you for registering "
                    + (showNumber ? customer.getCustomerPhoneNumber() : "*********"));

    static _TriConsumer<Integer, Integer, Integer> customTriConsumer = (a, b, c) -> System.out.println("Result " + a * b * c);
}



