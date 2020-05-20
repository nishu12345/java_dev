package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import java.util.function.Supplier;

import static combinatorpattern.CustomerRegistrationValidator.*;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@") ?
                SUCCESS : INVALID_EMAIL;
    }

    static CustomerRegistrationValidator isPhoneValid() {
        return customer -> customer.getPhoneNumber().startsWith("+0") ?
                SUCCESS : INVALID_PHONE_NUMBER;
    }

    static CustomerRegistrationValidator isAdult() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                SUCCESS : NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            //if result is equals to success check for other validation else result the result
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }


    enum ValidationResult {
        SUCCESS,
        INVALID_EMAIL,
        INVALID_PHONE_NUMBER,
        NOT_AN_ADULT
    }


}
