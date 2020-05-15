package functionalInterface;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Consumer<T> It takes one argument and return nothing.
 */
public class _Consumer {

    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "9876543210");
        greetCustomer(maria);
        customerConsumer.accept(maria);
    }


    static Consumer<Customer> customerConsumer = customer -> System.out.println("Hello " + customer.customerName +
            " thank you for registering phone number " + customer.customerPhoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName + " thank you for registering phone number " + customer.customerPhoneNumber);
    }

    static class Customer {
        private String customerName;
        private String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getCustomerPhoneNumber() {
            return customerPhoneNumber;
        }

        public void setCustomerPhoneNumber(String customerPhoneNumber) {
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
