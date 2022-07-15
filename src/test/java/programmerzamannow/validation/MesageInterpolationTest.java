package programmerzamannow.validation;

import org.junit.jupiter.api.Test;
import programmerzamannow.validation.group.VirtualAccountPaymentGroup;

public class MesageInterpolationTest extends AbstractValidatorTest{

    @Test
    void testMessage() {

        Payment payment =new Payment();
        payment.setOrderid("99900900099999990000099");
        payment.setVirtualAccount("67373883");
        payment.setAmount(10L);
        validateWithGroups(payment, VirtualAccountPaymentGroup.class);
    }
}
