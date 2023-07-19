package model;

import java.util.TreeSet;

public class PaymentHistory {

    private TreeSet<Payment> payments;
    private User user;

    public PaymentHistory(User u) {
        user = u;
        payments = new TreeSet<>();
    }

    private void addPayment(Payment p) {
        payments.add(p);
    }

}
