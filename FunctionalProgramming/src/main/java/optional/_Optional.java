package optional;

import java.util.List;
import java.util.Optional;

public class _Optional {

    public static void main(String[] args) {
        List<Customer> customerList = List.of(new Customer(1, "Alex"),
                new Customer(2, "Maria"),
                new Customer(2, "Alice"),
                new Customer(4, "Mojo"),
                new Customer(5, "Rose"));

        System.out.println("Name " + getNameById(customerList, 2));

        Optional.ofNullable(getNameById(customerList, 6)).ifPresentOrElse(System.out::println, () -> System.out.println("Not Found"));

    }

    static String getNameById(List<Customer> customerList, Integer id) {
        return customerList.stream().filter(customer -> customer.getId() == id).findFirst().map(Customer::getName)
                .orElse("Not Found");
    }
}
