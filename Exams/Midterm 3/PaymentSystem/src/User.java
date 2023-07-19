public class User {

    private PaymentHistory history;

    public User() {
        history = new PaymentHistory(this);
    }
}
