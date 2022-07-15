package programmerzamannow.validation;

import org.junit.jupiter.api.Test;
import programmerzamannow.validation.group.CreditCardPaymentGroup;

public class CustomConstrainTest extends AbstractValidatorTest{

    @Test
    void testCustomConstraint() {

        Payment payment = new Payment();
        payment.setOrderid("eko");

        validateWithGroups(payment, CreditCardPaymentGroup.class);


    }
}
