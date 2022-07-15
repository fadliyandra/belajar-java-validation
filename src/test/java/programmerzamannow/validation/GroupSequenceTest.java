package programmerzamannow.validation;

import org.junit.jupiter.api.Test;
import programmerzamannow.validation.group.PaymentGroup;

public class GroupSequenceTest extends AbstractValidatorTest{

    @Test
    void testGroupSequence() {

        Payment payment = new Payment();
        payment.setOrderid("0001");
        payment.setAmount(20_000L);
        payment.setCreditCard("411111111111111");
        validateWithGroups(payment, PaymentGroup.class);
    }
}
