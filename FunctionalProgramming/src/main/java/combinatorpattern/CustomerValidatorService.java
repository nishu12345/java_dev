package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CustomerValidatorService {

    private Predicate<String> isValidEmail = email -> email.contains("@");

    private Predicate<String> isValidPhoneNumber = phoneNumber -> phoneNumber.startsWith("+0");

    private Predicate<LocalDate> isAdult = dob -> Period.between(dob, LocalDate.now()).getYears() > 16;

    public Predicate<Customer> isValid = customer -> {
      return isValidEmail.test(customer.getEmail()) &&
              isValidPhoneNumber.test(customer.getPhoneNumber()) &&
              isAdult.test(customer.getDob());
    };

}
