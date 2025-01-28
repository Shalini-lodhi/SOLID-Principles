interface Payment {
    void processPayment();
}

class CreditCardPayment implements Payment {
    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment...");
    }
}

class PayPalPayment implements Payment {
    @Override
    public void processPayment() {
        System.out.println("Processing PayPal payment...");
    }
}

class PaymentProcessor {
    public void processPayment(Payment payment) {
        payment.processPayment();
    }
}

public class WithOCP {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment(new CreditCardPayment());
        processor.processPayment(new PayPalPayment());
    }
}
