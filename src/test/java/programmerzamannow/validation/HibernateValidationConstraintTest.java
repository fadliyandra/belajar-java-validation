package programmerzamannow.validation;

import org.junit.jupiter.api.Test;

public class HibernateValidationConstraintTest extends AbstractValidatorTest{

    @Test
    void testHibernateValidatorConstraintTest() {

        Payment payment= new Payment();
        payment.setAmount(1000L);
        payment.setOrderid("0001");
        payment.setCreditCard("433");

        validate(payment);
    }
    @Test
    void testHibernateValidatorConstraintValid() {

        Payment payment= new Payment();
        payment.setAmount(1000000L);
        payment.setOrderid("0001");
        payment.setCreditCard("499999999999999");

        validate(payment);
    }
}
