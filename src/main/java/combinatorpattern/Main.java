package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Alex",
                "alex@email.com",
                "+0987654321",
                LocalDate.of(2000, 1, 1));

        boolean isValidCustomer = new CustomerValidatorService().isValid.test(customer);
//        System.out.println("Is Alex a valid Customer? " + isValidCustomer );


        //Validating email, phone and dob
        ValidationResult result = isEmailValid()
                .and(isPhoneValid())
                .and(isAdult())
                .apply(customer);

        //Validating email and phone
        ValidationResult validateEmailAndPhone = isEmailValid().and(isPhoneValid()).apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
