package programmerzamannow.validation;

import org.junit.jupiter.api.Test;
import programmerzamannow.validation.group.CreditCardPaymentGroup;

import java.util.Locale;

public class MessageInternationalizationTest extends AbstractValidatorTest{

    @Test
    void testI18N() {

        Locale.setDefault(new Locale("in","ID"));

        Payment payment = new Payment();
        payment.setOrderid("09407204702740092799");
        payment.setAmount(10L);

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }
    @Test
    void testMessageInterpolator() {

        Locale.setDefault(new Locale("in","ID"));

        Payment payment = new Payment();
        payment.setOrderid("09407204702740092799");
        payment.setAmount(10L);

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }
}
