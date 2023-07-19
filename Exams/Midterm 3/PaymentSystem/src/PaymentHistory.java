import java.util.ArrayList;
import java.util.List;

public class PaymentHistory {

    private User user;
    private List<Payment> payments;

    public PaymentHistory(User user) {
        this.user = user;
        payments = new ArrayList<>();
    }

    public void addPayment(Payment payment) {
        if (!payments.contains(payment)) {
            payments.add(payment);
        }
    }
}
