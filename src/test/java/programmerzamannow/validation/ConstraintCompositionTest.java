package programmerzamannow.validation;

import org.junit.jupiter.api.Test;
import programmerzamannow.validation.group.CreditCardPaymentGroup;

public class ConstraintCompositionTest extends AbstractValidatorTest{

    @Test
    void testComposition() {


        Payment payment = new Payment();
        payment.setOrderid("09270274082482-48-284y");
        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }
}
