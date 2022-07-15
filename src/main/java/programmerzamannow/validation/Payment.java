package programmerzamannow.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;
import programmerzamannow.validation.constraint.CheckCase;
import programmerzamannow.validation.enums.CaseMode;
import programmerzamannow.validation.group.CreditCardPaymentGroup;
import programmerzamannow.validation.group.VirtualAccountPaymentGroup;
import programmerzamannow.validation.payload.EmailErrorPayload;

public class Payment {

    @CheckCase(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
    mode = CaseMode.UPPER, message = "{order.id.upper}")
    @NotBlank(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            message = "{order.id.notblank}")
    @Size(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            min = 1, max = 10, message = "{order.id.size}")
    private String orderid;

    @Range(groups = {CreditCardPaymentGroup.class,VirtualAccountPaymentGroup.class},
            min = 10_000l, max = 100_0000_000L, message = "{order.amount.range}")
    @NotNull(groups = {CreditCardPaymentGroup.class,VirtualAccountPaymentGroup.class},
            message = "amount id can not null")
    private Long amount;

    @LuhnCheck(groups = {CreditCardPaymentGroup.class},message = "invalid credit card number",
    payload = {EmailErrorPayload.class})
    @NotBlank(groups = {CreditCardPaymentGroup.class},message = "credit card id can not blank")
    private String creditCard;

    @NotBlank(groups = {VirtualAccountPaymentGroup.class},message = "virtual account id can not blank")
    private String virtualAccount;

    @Valid
    @NotNull(groups = {VirtualAccountPaymentGroup.class, CreditCardPaymentGroup.class},
    message = "Customers can not null")

    @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
    @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
    private Customer customer;


    @Override
    public String toString() {
        return "Payment{" +
                "orderid='" + orderid + '\'' +
                ", amount=" + amount +
                ", creditCard='" + creditCard + '\'' +
                ", virtualAccount='" + virtualAccount + '\'' +
                ", customer=" + customer +
                '}';
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
