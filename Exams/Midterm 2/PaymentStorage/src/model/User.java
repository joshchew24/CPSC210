package model;

public class User {

    PaymentHistory paymentHistory;

    public User() {
        paymentHistory = new PaymentHistory(this);
    }

}
