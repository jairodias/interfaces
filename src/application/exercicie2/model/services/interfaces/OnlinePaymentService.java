package application.exercicie2.model.services.interfaces;

public interface OnlinePaymentService {
    double paymentFee(double amount);

    double interest(double amount, int months);
}
